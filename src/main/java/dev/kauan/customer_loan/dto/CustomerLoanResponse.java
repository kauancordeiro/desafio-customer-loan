package dev.kauan.customer_loan.dto;

import java.util.List;

public record CustomerLoanResponse(
        String customer,
        List<LoanResponse> loans
) {
}
