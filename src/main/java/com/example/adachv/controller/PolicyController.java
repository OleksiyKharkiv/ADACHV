package com.example.adachv.controller;

import com.example.adachv.entity.Policy;
import com.example.adachv.repository.PolicyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/policies")
public class PolicyController {

    @Autowired
    private PolicyRepository policyRepository;

    @GetMapping
    public List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }

    @GetMapping("/{id}")
    public Policy getPolicyById(@PathVariable Long id) {
        return policyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Policy with id " + id + " not found."));
    }

    @PostMapping
    public Policy createPolicy(@RequestBody Policy policy) {
        return policyRepository.save(policy);
    }

    @PutMapping("/{id}")
    public Policy updatePolicy(@PathVariable Long id, @RequestBody Policy updatedPolicy) {
        Policy existingPolicy = policyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Policy with id " + id + " not found."));
        existingPolicy.setPolicyType(updatedPolicy.getPolicyType());
        // Дополнительные поля, если есть, для обновления

        return policyRepository.save(existingPolicy);
    }

    @DeleteMapping("/{id}")
    public void deletePolicy(@PathVariable Long id) {
        policyRepository.deleteById(id);
    }
}