package com.coffeshop.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffeshop.demo.model.Barista;

public interface BaristaRepository extends JpaRepository<Barista, Long> {

}
