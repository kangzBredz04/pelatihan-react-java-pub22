package com.example.demo.controller;

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

import com.example.demo.model.Mahasiswa;
import com.example.demo.repository.MahasiswaRepository;

@RestController
@RequestMapping("/mahasiswa")
public class MahasiswaController {
    @Autowired
    private MahasiswaRepository mahasiswaRepository;

    // @GetMapping("")
    // public List<Mahasiswa> findMahasiswasList() {
    // return mahasiswaRepository.findAll();
    // }

    // @GetMapping("/{nim}")
    // public List<Mahasiswa> findMahasiswasByNim(@PathVariable String nim) {
    // return mahasiswaRepository.findMahasiswasByNim(nim);
    // }

    // @PostMapping("")
    // public Mahasiswa saveMahasiswa(@RequestBody Mahasiswa mahasiswa) {
    // return mahasiswaRepository.save(mahasiswa);
    // }

    @GetMapping("")
    public Map<String, Object> findMahasiswasList() {
        List<Mahasiswa> mahasiswas = mahasiswaRepository.findAll();
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "Berhasil mengambil semua data mahasiswa");
        response.put("data", mahasiswas);
        return response;
    }

    @GetMapping("/{nim}")
    public Map<String, Object> findMahasiswasByNim(@PathVariable String nim) {
        List<Mahasiswa> mahasiswas = mahasiswaRepository.findMahasiswasByNim(nim);
        Map<String, Object> response = new LinkedHashMap<>();
        if (mahasiswas.isEmpty()) {
            response.put("message", "Mahasiswa dengan NIM update " + nim + " tidak ditemukan");
            response.put("data", null);
        } else {
            response.put("message", "Data mahasiswa dengan NIM " + nim + " berhasil ditemukan");
            response.put("data", mahasiswas);
        }
        return response;
    }

    @PostMapping("")
    public Map<String, Object> saveMahasiswa(@RequestBody Mahasiswa mahasiswa) {
        Mahasiswa savedMahasiswa = mahasiswaRepository.save(mahasiswa);
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "Berhasil menyimpan data mahasiswa");
        response.put("data", savedMahasiswa);
        return response;
    }

    @PutMapping("/{nim}")
    public Map<String, Object> updateMahasiswa(@PathVariable String nim,
            @RequestBody Mahasiswa newMahasiswa) {
        List<Mahasiswa> mahasiswas = mahasiswaRepository.findMahasiswasByNim(nim);
        Map<String, Object> response = new LinkedHashMap<>();
        if (mahasiswas == null) {
            response.put("message", "Mahasiswa dengan NIM " + nim + " tidak ditemukan");
            response.put("data", null);
        } else {
            Mahasiswa exsiting = mahasiswas.get(0);
            exsiting.setNama(newMahasiswa.getNama());
            Mahasiswa updatedMahasiswa = mahasiswaRepository.save(exsiting);
            response.put("message", "Data mahasiswa dengan NIM " + nim + " berhasil diperbarui");
            response.put("data", updatedMahasiswa);
        }
        return response;
    }

    @DeleteMapping("/{nim}")
    public Map<String, Object> deleteMahasiswa(@PathVariable String nim) {
        List<Mahasiswa> mahasiswas = mahasiswaRepository.findMahasiswasByNim(nim);
        Map<String, Object> response = new LinkedHashMap<>();
        if (mahasiswas == null) {
            response.put("message", "Mahasiswa dengan NIM " + nim + " tidak ditemukan");
            response.put("data", null);
        } else {
            Mahasiswa toDelete = mahasiswas.get(0);
            mahasiswaRepository.delete(toDelete);
            response.put("message", "Data mahasiswa dengan NIM " + nim + " berhasil dihapus");
            response.put("data", toDelete);
        }
        return response;
    }
}
