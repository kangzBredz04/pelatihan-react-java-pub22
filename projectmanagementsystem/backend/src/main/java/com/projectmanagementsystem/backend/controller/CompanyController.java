package com.projectmanagementsystem.backend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.projectmanagementsystem.backend.model.Company;
import com.projectmanagementsystem.backend.repository.CompanyRepository;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;

    // Endpoint dengan pagination default
    @GetMapping("/all")
    public Page<Company> getAllCompany(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return companyRepository.findAll(pageable);
    }

    // Endpoint dengan pagination dan sorting
    @GetMapping("/all/sorted")
    public Page<Company> getAllCompanySorted(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection) {

        Sort sort = sortDirection.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return companyRepository.findAll(pageable);
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

    // Endpoint dengan pagination
    @GetMapping("/by-name/{name}")
    public Page<Company> getCompanyByName(
            @PathVariable String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return companyRepository.findByNameContainingIgnoreCase(name, pageable);
    }

    // Endpoint dengan pagination
    @GetMapping("/by-address/{address}")
    public Page<Company> getCompanyByAddress(
            @PathVariable String address,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return companyRepository.findByAddressContainingIgnoreCase(address, pageable);
    }

    // Endpoint dengan pagination
    @GetMapping("/by-name-or-address/{name}/{address}")
    public Page<Company> getCompanyByNameAndAddress(
            @PathVariable String name,
            @PathVariable String address,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return companyRepository.findByNameContainingIgnoreCaseOrAddressContainingIgnoreCase(name, address, pageable);
    }

    // Endpoint dengan pagination
    @GetMapping("/by-name-asc")
    public Page<Company> getCompanyByNameAsc(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return companyRepository.findAllByOrderByNameAsc(pageable);
    }

    // Endpoint dengan pagination
    @GetMapping("/by-name-desc")
    public Page<Company> getCompanyByNameDesc(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return companyRepository.findAllByOrderByNameDesc(pageable);
    }
}