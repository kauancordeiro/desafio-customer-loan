package dev.kauan.customer_loan.services;

import dev.kauan.customer_loan.dto.CustomerLoanRequest;
import dev.kauan.customer_loan.dto.CustomerLoanResponse;
import dev.kauan.customer_loan.dto.LoanResponse;
import dev.kauan.customer_loan.entities.Customer;
import dev.kauan.customer_loan.entities.Loans;
import dev.kauan.customer_loan.enums.LoansType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoansService {


    public CustomerLoanResponse checkLoanAvailability(CustomerLoanRequest loanRequest){

        Customer customer = loanRequest.toCustomer();
        Loans loans = new Loans(customer);

        List<LoanResponse> responseList = new ArrayList<>();
        if (loans.isPersonalLoanAvailable()){
            responseList.add(new LoanResponse(LoansType.PERSONAL, loans.getPersonalLoanInterestRate()));
        }


        return new CustomerLoanResponse(loanRequest.name(), responseList);
    }

}
