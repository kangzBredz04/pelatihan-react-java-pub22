package com.projectmanagementsystem.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectmanagementsystem.backend.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    List<Company> findByNameContainingIgnoreCase(String name);

    List<Company> findByAddressContainingIgnoreCase(String address);

    List<Company> findByNameContainingIgnoreCaseOrAddressContainingIgnoreCase(String name, String address);

    List<Company> findAllByOrderByNameAsc();

    List<Company> findAllByOrderByNameDesc();
}
