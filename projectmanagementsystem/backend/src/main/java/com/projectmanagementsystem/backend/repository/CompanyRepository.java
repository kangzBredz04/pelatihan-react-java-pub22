package com.projectmanagementsystem.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectmanagementsystem.backend.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
