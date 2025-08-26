package com.api.apiProduct.repository;


import com.api.apiProduct.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
