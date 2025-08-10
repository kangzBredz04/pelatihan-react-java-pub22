package com.projectmanagementsystem.backend.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.projectmanagementsystem.backend.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    List<Company> findByNameContainingIgnoreCase(String name);

    List<Company> findByAddressContainingIgnoreCase(String address);

    List<Company> findByNameContainingIgnoreCaseOrAddressContainingIgnoreCase(String name, String address);

    List<Company> findAllByOrderByNameAsc();

    List<Company> findAllByOrderByNameDesc();

    // Tambahan method untuk pagination
    Page<Company> findAll(Pageable pageable);

    Page<Company> findByNameContainingIgnoreCase(String name, Pageable pageable);

    Page<Company> findByAddressContainingIgnoreCase(String address, Pageable pageable);

    Page<Company> findByNameContainingIgnoreCaseOrAddressContainingIgnoreCase(String name, String address,
            Pageable pageable);

    Page<Company> findAllByOrderByNameAsc(Pageable pageable);

    Page<Company> findAllByOrderByNameDesc(Pageable pageable);
}