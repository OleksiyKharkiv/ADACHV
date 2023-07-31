package com.example.adacversicherungpage.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "claims")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String insuranceCase;
    private String damages;
    private String compensation;

    @ManyToOne
    @JoinColumn(name = "policy_id")
    private Policy policy;

    // Геттеры, сеттеры, конструкторы

    @Override
    public String toString() {
        return "Claim{" +
                "id=" + id +
                ", insuranceCase='" + insuranceCase + '\'' +
                ", damages='" + damages + '\'' +
                ", compensation='" + compensation + '\'' +
                // Остальные атрибуты
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Claim)) return false;
        Claim claim = (Claim) o;
        return Objects.equals(id, claim.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}