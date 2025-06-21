package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Mahasiswa;

public interface MahasiswaRepository extends JpaRepository<Mahasiswa, Integer> {

    List<Mahasiswa> findMahasiswasByNim(String nim);
}
