package dev.kauan.customer_loan.dto;

import dev.kauan.customer_loan.entities.Customer;

public record CustomerLoanRequest(Integer age,
                                  String cpf,
                                  String name,
                                  Double income,
                                  String location
) {

    public Customer toCustomer(){
        return new Customer(
                age,
                cpf,
                name,
                income,
                location
        );
    }

}
