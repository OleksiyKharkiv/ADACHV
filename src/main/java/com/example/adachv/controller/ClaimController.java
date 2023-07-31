package com.example.adachv.controller;

import com.example.adachv.entity.Claim;
import com.example.adachv.repository.ClaimRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/claims")
public class ClaimController {

    @Autowired
    private ClaimRepository claimRepository;

    @GetMapping
    public List<Claim> getAllClaims() {
        return claimRepository.findAll();
    }

    @GetMapping("/{id}")
    public Claim getClaimById(@PathVariable Long id) {
        return claimRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Claim with id " + id + " not found."));
    }

    @PostMapping
    public Claim createClaim(@RequestBody Claim claim) {
        return claimRepository.save(claim);
    }

    @PutMapping("/{id}")
    public Claim updateClaim(@PathVariable Long id, @RequestBody Claim updatedClaim) {
        Claim existingClaim = claimRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Claim with id " + id + " not found."));
        existingClaim.setInsuranceCase(updatedClaim.getInsuranceCase());
        existingClaim.setDamages(updatedClaim.getDamages());
        existingClaim.setCompensation(updatedClaim.getCompensation());

        return claimRepository.save(existingClaim);
    }

    @DeleteMapping("/{id}")
    public void deleteClaim(@PathVariable Long id) {
        claimRepository.deleteById(id);
    }
}