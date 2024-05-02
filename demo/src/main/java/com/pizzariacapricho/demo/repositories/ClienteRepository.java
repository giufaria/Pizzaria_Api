package com.pizzariacapricho.demo.repositories;

import com.pizzariacapricho.demo.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
