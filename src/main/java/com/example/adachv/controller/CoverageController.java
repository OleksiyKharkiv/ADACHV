package com.example.adachv.controller;

import com.example.adachv.entity.Coverage;
import com.example.adachv.repository.CoverageRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coverages")
public class CoverageController {

    @Autowired
    private CoverageRepository coverageRepository;

    @GetMapping
    public List<Coverage> getAllCoverages() {
        return coverageRepository.findAll();
    }

    @GetMapping("/{id}")
    public Coverage getCoverageById(@PathVariable Long id) {
        return coverageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Coverage with id " + id + " not found."));
    }

    @PostMapping
    public Coverage createCoverage(@RequestBody Coverage coverage) {
        return coverageRepository.save(coverage);
    }

    @PutMapping("/{id}")
    public Coverage updateCoverage(@PathVariable Long id, @RequestBody Coverage updatedCoverage) {
        Coverage existingCoverage = coverageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Coverage with id " + id + " not found."));
        existingCoverage.setCoverageDescription(updatedCoverage.getCoverageDescription());
        // Дополнительные поля, если есть, для обновления

        return coverageRepository.save(existingCoverage);
    }

    @DeleteMapping("/{id}")
    public void deleteCoverage(@PathVariable Long id) {
        coverageRepository.deleteById(id);
    }
}