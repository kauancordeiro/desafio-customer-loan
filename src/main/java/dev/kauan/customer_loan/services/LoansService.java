package dev.kauan.customer_loan.services;

import dev.kauan.customer_loan.entities.Loans;
import dev.kauan.customer_loan.repositories.LoansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoansService {

    @Autowired
    private LoansRepository loansRepository;

    public Loans insertLoans(Loans loans) {
        loansRepository.save(loans);
        return loans;
    }
}
