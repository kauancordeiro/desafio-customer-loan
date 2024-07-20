package dev.kauan.customer_loan.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private String cpf;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private double income;
    @Column(nullable = false)
    private String location;

}
