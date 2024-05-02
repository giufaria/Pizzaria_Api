package com.pizzariacapricho.demo.repositories;

import com.pizzariacapricho.demo.models.Bebidas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BebidasRepository extends JpaRepository<Bebidas, Long> {
}
