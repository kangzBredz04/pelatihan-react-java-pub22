package com.coffeshop.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffeshop.demo.model.Sales;

public interface SalesRepository extends JpaRepository<Sales, Long> {

}
