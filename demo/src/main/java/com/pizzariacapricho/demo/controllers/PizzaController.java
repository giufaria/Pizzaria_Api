package com.pizzariacapricho.demo.controllers;

import com.pizzariacapricho.demo.models.Pizza;
import com.pizzariacapricho.demo.repositories.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class PizzaController {

    @Autowired
    private PizzaRepository pizzaRepository;

    @RequestMapping(value = "/cadpizza", method = RequestMethod.POST)
    public Pizza save() {
        Pizza p = new Pizza();
        p.setNome("Frango Catupiry");
        p.setPrecoBase(42);
        p = this.pizzaRepository.save(p);
        return p;
    }


    @RequestMapping(value = "/excluirpizza/{id_pizza}", method = RequestMethod.DELETE)
    public String deletePizza(@PathVariable("id_pizza") long id_pizza) {
        pizzaRepository.deleteById(id_pizza);
        return "Pizza com ID " + id_pizza + " excluída com sucesso!";
    }


    @RequestMapping(value = "/mostrarpizzas", method = RequestMethod.GET)
    public List<Pizza> findAll() {
        List<Pizza> pizzas = this.pizzaRepository.findAll();
        return pizzas;
    }

    @RequestMapping(value = "/mostrarpizzas/{id_Pizza}", method = RequestMethod.GET)
    public Pizza findById(@PathVariable long id_Pizza) {
        Optional<Pizza> resultado = this.pizzaRepository.findById(id_Pizza);
        if (resultado.isEmpty()) {
            throw new RuntimeException("Pizza não encontrada");
        } else {
            return resultado.get();
        }
    }

    @PutMapping("/alterarpizza/{id_pizza}")
    public Pizza updatePizza(@PathVariable("id_pizza") long id_pizza) {
        return pizzaRepository.findById(id_pizza)
                .map(pizza -> {
                    /*pizza.setNome("Frango com milho");
                    pizza.setPrecoBase(52);*/
                    return pizzaRepository.save(pizza);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pizza não encontrada com o ID: " + id_pizza));
    }
}

