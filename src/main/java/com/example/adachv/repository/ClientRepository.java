package com.example.adachv.repository;
import com.example.adachv.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    // Дополнительные методы для работы с клиентами, если необходимо
}
