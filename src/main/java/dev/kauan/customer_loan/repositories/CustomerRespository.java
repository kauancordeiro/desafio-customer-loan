package dev.kauan.customer_loan.repositories;

import dev.kauan.customer_loan.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRespository extends JpaRepository<Customer, UUID> {
}
