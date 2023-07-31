package com.example.adachv.repository;
import com.example.adachv.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {
    // Дополнительные методы для работы с полисами, если необходимо
}
