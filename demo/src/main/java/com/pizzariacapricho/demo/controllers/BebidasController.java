package com.pizzariacapricho.demo.controllers;

import com.pizzariacapricho.demo.models.Bebidas;
import com.pizzariacapricho.demo.models.Pizza;
import com.pizzariacapricho.demo.repositories.BebidasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class BebidasController {

    @Autowired
    private BebidasRepository bebidasRepository;

    @RequestMapping(value = "/cadbebidas", method = RequestMethod.POST)
    public Bebidas save() {
        Bebidas b = new Bebidas();
        b.setNome("Coca-cola zero (lata)");
        b.setPreco(8);
        b = this.bebidasRepository.save(b);
        return b;
    }
    @RequestMapping(value = "/excluirbebida/{id_bebida}", method = RequestMethod.DELETE)
    public String deleteBebida(@PathVariable("id_bebida") long id_bebida) {
        bebidasRepository.deleteById(id_bebida);
        return "Bebida com ID " + id_bebida + " excluída com sucesso!";
    }

    @RequestMapping(value = "/mostrarbebidas", method = RequestMethod.GET)
    public List<Bebidas> findAll() {
        List<Bebidas> bebidas = this.bebidasRepository.findAll();
        return bebidas;
    }

    @RequestMapping(value = "/mostrarbebidas/{id_bebida}", method = RequestMethod.GET)
    public Bebidas findById(@PathVariable long id_bebida) {
        Optional<Bebidas> resultado = this.bebidasRepository.findById(id_bebida);
        if (resultado.isEmpty()) {
            throw new RuntimeException("Bebida não encontrada");
        } else {
            return resultado.get();
        }
    }

    @PutMapping("/alterarbebida/{id_bebida}")
    public Bebidas updatebebida(@PathVariable("id_bebida") long id_bebida) {
        return bebidasRepository.findById(id_bebida)
                .map(bebidas -> {
                    //bebida.setNome("guarana");
                    return bebidasRepository.save(bebidas);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Bebida não encontrada com o ID: " + id_bebida));
    }
}
