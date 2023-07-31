package com.example.adachv.repository;
import com.example.adachv.entity.Coverage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoverageRepository extends JpaRepository<Coverage, Long> {
    // Дополнительные методы для работы с покрытием, если необходимо
}