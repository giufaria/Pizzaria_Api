package com.pizzariacapricho.demo.controllers;

import com.pizzariacapricho.demo.models.Cliente;
import com.pizzariacapricho.demo.models.Pizza;
import com.pizzariacapricho.demo.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @RequestMapping(value = "/cadcliente", method = RequestMethod.POST)
    public Cliente save() {
        Cliente c = new Cliente();
        c.setNome("Diego");
        c.setTelefone("4002-8922");
        c.setEndereco("rua mariana, n 302 - SP");
        c.setLogin("diego27@");
        c.setSenha("100423");
        c = this.clienteRepository.save(c);
        return c;
    }

    @RequestMapping(value = "/excluircliente/{id_Cliente}", method = RequestMethod.DELETE)
    public String deletePizza(@PathVariable("id_Cliente") long id_Cliente) {
        clienteRepository.deleteById(id_Cliente);
        return "Cliente com ID " + id_Cliente + " excluído com sucesso!";
    }

    @RequestMapping(value = "/mostrarclientes", method = RequestMethod.GET)
    public List<Cliente> findAll() {
        List<Cliente> clientes = this.clienteRepository.findAll();
        return clientes;
    }

    @RequestMapping(value = "/mostrarcliente/{id_Cliente}", method = RequestMethod.GET)
    public Cliente findById(@PathVariable long id_Cliente) {
        Optional<Cliente> resultado = this.clienteRepository.findById(id_Cliente);
        if (resultado.isEmpty()) {
            throw new RuntimeException("Cliente não encontrado");
        } else {
            return resultado.get();
        }
    }

    @PutMapping("/alterarcliente/{id_Cliente}")
    public Cliente updateCliente(@PathVariable("id_Cliente") long id_Cliente) {
        return clienteRepository.findById(id_Cliente)
                .map(cliente -> {
                    // cliente.setNome("Giulia");
                    return clienteRepository.save(cliente);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado com o ID: " + id_Cliente));
    }
}

