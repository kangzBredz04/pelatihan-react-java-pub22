package com.coffeshop.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffeshop.demo.model.Sales;
import com.coffeshop.demo.repository.SalesRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/sales")
public class SalesController {

    @Autowired
    private SalesRepository salesRepository;

    @GetMapping("/all")
    public List<Sales> getSales() {
        return salesRepository.findAll();
    }

    @PostMapping("/add")
    public Sales addSales(@RequestBody Sales sales) {
        return salesRepository.save(sales);
    }
}
