package com.example.adachv.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "coverages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Coverage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String coverageDescription;
    private String insuranceConditions;

    @ManyToOne
    @JoinColumn(name = "policy_id")
    private Policy policy;

    // Геттеры, сеттеры, конструкторы

    @Override
    public String toString() {
        return "Coverage{" +
                "id=" + id +
                ", coverageDescription='" + coverageDescription + '\'' +
                ", insuranceConditions='" + insuranceConditions + '\'' +
                // Остальные атрибуты
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coverage)) return false;
        Coverage coverage = (Coverage) o;
        return Objects.equals(id, coverage.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}