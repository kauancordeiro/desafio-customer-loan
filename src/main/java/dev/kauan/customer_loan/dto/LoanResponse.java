package dev.kauan.customer_loan.dto;

import dev.kauan.customer_loan.enums.LoansType;

public record LoanResponse(LoansType loansType, Double interestRate) {
}
