package com.coffeshop.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffeshop.demo.model.Coffee;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
    List<Coffee> findByCode(Long code);
}
