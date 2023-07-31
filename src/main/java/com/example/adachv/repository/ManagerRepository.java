package com.example.adachv.repository;

import com.example.adachv.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
    // Дополнительные методы для работы с менеджерами, если необходимо
}

