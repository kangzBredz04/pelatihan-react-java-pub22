package com.pubmanagement.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pubmanagement.demo.model.Mahasiswa;
import com.pubmanagement.demo.service.MahasiswaService;

@RestController
@RequestMapping("/mahasiswa")
public class MahasiswaController {

    @Autowired
    private MahasiswaService mahasiswaService;

    // method to get all mahasiswa
    @GetMapping("/all")
    public List<Mahasiswa> getAllMahasiswa() {
        return mahasiswaService.getAllMahasiswa();
    }

    // method to get mahasiswa by id
    @GetMapping("/{id}")
    public Mahasiswa getMahasiswaById(@PathVariable int id) {
        return mahasiswaService.getMahasiswaById(id);
    }

    // method to add mahasiswa
    @PostMapping("/add")
    public void addMahasiswa(@RequestBody Mahasiswa mahasiswa) {
        mahasiswaService.addMahasiswa(mahasiswa);
    }

    // method to update mahasiswa
    @PutMapping("/update")
    public void updateMahasiswa(@RequestBody Mahasiswa mahasiswa) {
        mahasiswaService.updateMahasiswa(mahasiswa);
    }

    // method to delete mahasiswa
    @DeleteMapping("/delete/{id}")
    public void deleteMahasiswa(@PathVariable int id) {
        mahasiswaService.deleteMahasiswa(id);
    }
}
