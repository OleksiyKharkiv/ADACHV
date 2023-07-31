package com.example.adachv.controller;

import com.example.adachv.entity.Manager;
import com.example.adachv.repository.ManagerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/managers")
public class ManagerController {

    @Autowired
    private ManagerRepository managerRepository;

    @GetMapping
    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Manager getManagerById(@PathVariable Long id) {
        return managerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Manager with id " + id + " not found."));
    }

    @PostMapping
    public Manager createManager(@RequestBody Manager manager) {
        return managerRepository.save(manager);
    }

    @PutMapping("/{id}")
    public Manager updateManager(@PathVariable Long id, @RequestBody Manager updatedManager) {
        Manager existingManager = managerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Manager with id " + id + " not found."));
        existingManager.setFullName(updatedManager.getFullName());
        existingManager.setAccessLevel(updatedManager.getAccessLevel());
        // Дополнительные поля, если есть, для обновления

        return managerRepository.save(existingManager);
    }

    @DeleteMapping("/{id}")
    public void deleteManager(@PathVariable Long id) {
        managerRepository.deleteById(id);
    }
}