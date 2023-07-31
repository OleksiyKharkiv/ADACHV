package com.example.adachv.repository;
import com.example.adachv.entity.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {
    // Дополнительные методы для работы с заявками, если необходимо
}