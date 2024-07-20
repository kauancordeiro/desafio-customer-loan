package dev.kauan.customer_loan.repositories;

import dev.kauan.customer_loan.entities.Loans;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LoansRepository extends JpaRepository<Loans, UUID> {
}
