package com.projectmanagementsystem.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectmanagementsystem.backend.model.Company;
import com.projectmanagementsystem.backend.repository.CompanyRepository;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("/all")
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @GetMapping("/by-id/{id}")
    public Company getCompanyById(@PathVariable Long id) {
        return companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Company not found"));
    }

    @PostMapping("/create")
    public Company createCompany(@RequestBody Company company) {
        return companyRepository.save(company);
    }

    @PutMapping("/update/{id}")
    public Company updateCompany(@PathVariable Long id, @RequestBody Company company) {
        Company existingCompany = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found"));

        existingCompany.setName(company.getName());
        existingCompany.setAddress(company.getAddress());
        return companyRepository.save(existingCompany);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCompany(@PathVariable Long id) {
        companyRepository.deleteById(id);
    }

    @GetMapping("/by-name/{name}")
    public List<Company> getCompanyByName(@PathVariable String name) {
        return companyRepository.findByNameContainingIgnoreCase(name);
    }

    @GetMapping("/by-address/{address}")
    public List<Company> getCompanyByAddress(@PathVariable String address) {
        return companyRepository.findByAddressContainingIgnoreCase(address);
    }

    @GetMapping("/by-name-or-address/{name}/{address}")
    public List<Company> getCompanyByNameAndAddress(@PathVariable String name, @PathVariable String address) {
        return companyRepository.findByNameContainingIgnoreCaseOrAddressContainingIgnoreCase(name, address);
    }

    @GetMapping("/by-name-asc")
    public List<Company> getCompanyByNameAsc() {
        return companyRepository.findAllByOrderByNameAsc();
    }

    @GetMapping("/by-name-desc")
    public List<Company> getCompanyByNameDesc() {
        return companyRepository.findAllByOrderByNameDesc();
    }
}
