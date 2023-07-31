package com.example.adacversicherungpage.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "policies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String policyType;
    private String conditions;
    private Date createdAt;
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // Геттеры, сеттеры, конструкторы

    @Override
    public String toString() {
        return "Policy{" +
                "id=" + id +
                ", policyType='" + policyType + '\'' +
                ", conditions='" + conditions + '\'' +
                ", registrationDate=" + createdAt +
                ", modificationDate=" + updatedAt +
                // Остальные атрибуты
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Policy)) return false;
        Policy policy = (Policy) o;
        return Objects.equals(id, policy.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
