package com.projectmanagementsystem.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectmanagementsystem.demo.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
