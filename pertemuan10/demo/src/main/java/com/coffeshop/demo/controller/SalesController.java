package com.coffeshop.demo.controller;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffeshop.demo.model.Barista;
import com.coffeshop.demo.model.Coffee;
import com.coffeshop.demo.model.Sales;
import com.coffeshop.demo.repository.BaristaRepository;
import com.coffeshop.demo.repository.CoffeeRepository;
import com.coffeshop.demo.repository.SalesRepository;

@RestController
@RequestMapping("/sales")
public class SalesController {
    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private CoffeeRepository coffeeRepository;

    @Autowired
    private BaristaRepository baristaRepository;

    @PostMapping("/add-sales")
    public Map<String, Object> addSales(@RequestBody Sales sales, @PathVariable Long codeCoffee,
            @PathVariable Long idBarista) {
        Map<String, Object> response = new LinkedHashMap<>();

        try {
            List<Coffee> coffee = coffeeRepository.findByCode(sales.getCodeCoffee().getCode());
            Optional<Barista> barista = baristaRepository.findById(sales.getIdBarista().getId());

            if (coffee.isEmpty() && barista.isEmpty()) {
                response.put("message", "Coffee atau Barista tidak ditemukan");
            } else {
                sales.setDate(LocalDateTime.now());
                sales.setCodeCoffee(coffee.get(0));
                sales.setIdBarista(barista.get());

                Sales updated = salesRepository.save(sales);
                response.put("message", "Berhasil memperbarui data penjualan");
                response.put("data", updated);
            }
        } catch (Exception e) {
            response.put("message", "Gagal menyimpan data: " + e.getMessage());
        }

        return response;
    }
}
