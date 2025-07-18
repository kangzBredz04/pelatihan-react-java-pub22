package com.coffeshop.demo.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffeshop.demo.model.Coffee;
import com.coffeshop.demo.repository.CoffeeRepository;

@RestController
@RequestMapping("coffee")
public class CoffeeController {
    @Autowired
    private CoffeeRepository coffeeRepository;

    @GetMapping("/all")
    public Map<String, Object> getAllCoffee() {
        List<Coffee> coffees = coffeeRepository.findAll();
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "Berhasil mengambil semua data kopi");
        response.put("data", coffees);
        return response;
    }

    @GetMapping("/get-by-code/{code}")
    public Map<String, Object> getCoffeeById(@PathVariable Long code) {
        List<Coffee> coffees = coffeeRepository.findByCode(code);
        Map<String, Object> response = new LinkedHashMap<>();
        if (coffees.isEmpty()) {
            response.put("message", "Coffee dengan code " + code + " tidak ditemukan");
            response.put("data", coffees);
        } else {
            response.put("message", "Berhasil mengambil data kopi");
            response.put("data", coffees);
        }
        return response;
    }

    @PostMapping("/add-coffee")
    public Map<String, Object> addCoffee(@RequestBody Coffee coffee) {
        Coffee savedCoffee = coffeeRepository.save(coffee);
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "Berhasil menyimpan data kopi");
        response.put("data", savedCoffee);
        return response;
    }

    @PutMapping("/update-by-code/{code}")
    public Map<String, Object> updateCoffee(@PathVariable Long code, @RequestBody Coffee newCoffee) {
        List<Coffee> coffees = coffeeRepository.findByCode(code);
        Map<String, Object> response = new LinkedHashMap<>();
        if (coffees == null) {
            response.put("message", "Kopi dengan code " + code + " tidak ditemukan");
        } else {
            Coffee exsiting = coffees.get(0);
            exsiting.setMerk(newCoffee.getMerk());
            exsiting.setType(newCoffee.getType());
            exsiting.setPrice(newCoffee.getPrice());
            Coffee updateCoffee = coffeeRepository.save(exsiting);
            response.put("message", "Data kopi dengan kode " + code + " berhasil diperbarui");
            response.put("data", updateCoffee);
        }
        return response;
    }

    @DeleteMapping("/delete-by-code/{code}")
    public Map<String, Object> deleteCofffe(@PathVariable Long code) {
        List<Coffee> coffees = coffeeRepository.findByCode(code);
        Map<String, Object> response = new LinkedHashMap<>();
        if (coffees == null) {
            response.put("message", "Kopi dengan code " + code + " tidak ditemukan");
        } else {
            Coffee toDelete = coffees.get(0);
            coffeeRepository.delete(toDelete);
            response.put("message", "Data kopi dengan code " + code + " berhasil dihapus");
            response.put("data", toDelete);
        }
        return response;
    }

}
