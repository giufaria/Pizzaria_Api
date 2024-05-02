package com.pizzariacapricho.demo.repositories;

import com.pizzariacapricho.demo.models.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}
