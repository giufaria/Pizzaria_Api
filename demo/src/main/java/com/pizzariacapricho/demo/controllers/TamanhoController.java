package com.pizzariacapricho.demo.controllers;

import com.pizzariacapricho.demo.models.Pizza;
import com.pizzariacapricho.demo.models.Tamanho;
import com.pizzariacapricho.demo.repositories.TamanhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class TamanhoController {

    @Autowired
    private TamanhoRepository tamanhoRepository;

    @RequestMapping(value = "/cadtamanho", method = RequestMethod.POST)
    public Tamanho save() {
        Tamanho t = new Tamanho();
        t.setNome("média");
        t.setDesconto(10);

        t = this.tamanhoRepository.save(t);
        return t;
    }

    @RequestMapping(value = "/excluirtamanho/{id_tamanho}", method = RequestMethod.DELETE)
    public String deleteTamanho(@PathVariable("id_tamanho") long id_tamanho) {
        tamanhoRepository.deleteById(id_tamanho);
        return "Tamanho com ID " + id_tamanho + " excluído com sucesso!";
    }

    @RequestMapping(value = "/mostrartamanhos", method = RequestMethod.GET)
    public List<Tamanho> findAll() {
        List<Tamanho> tamanhos = this.tamanhoRepository.findAll();
        return tamanhos;
    }

    @RequestMapping(value = "/mostrartamanhos/{id_tamanho}", method = RequestMethod.GET)
    public Tamanho findById(@PathVariable long id_tamanho) {
        Optional<Tamanho> resultado = this.tamanhoRepository.findById(id_tamanho);
        if (resultado.isEmpty()) {
            throw new RuntimeException("Tamanho não encontrada");
        } else {
            return resultado.get();
        }
    }

    @PutMapping("/alterartamanho/{id_tamanho}")
    public Tamanho updateTamanho(@PathVariable("id_tamanho") long id_tamanho) {
        return tamanhoRepository.findById(id_tamanho)
                .map(tamanho -> {
                    //tamanho.setNome("Grande");

                    return tamanhoRepository.save(tamanho);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tamanho não encontrado com o ID: " + id_tamanho));
    }
}
