package dev.kauan.customer_loan.dto;

public record CustomerLoanRequest(Integer age,
                                  String cpf,
                                  String name,
                                  Double income,
                                  String location
) {
}
