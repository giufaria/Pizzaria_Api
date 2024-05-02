package com.pizzariacapricho.demo.repositories;

import com.pizzariacapricho.demo.models.Tamanho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TamanhoRepository extends JpaRepository<Tamanho, Long> {
}
