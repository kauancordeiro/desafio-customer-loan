package dev.kauan.customer_loan.controller;

import dev.kauan.customer_loan.dto.CustomerLoanRequest;
import dev.kauan.customer_loan.dto.CustomerLoanResponse;
import dev.kauan.customer_loan.entities.Loans;
import dev.kauan.customer_loan.services.LoansService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class LoansController {

    @Autowired
    private LoansService loansService;

    @PostMapping("/customer-loans")
    public ResponseEntity<CustomerLoanResponse> insertLoan(@RequestBody @Valid CustomerLoanRequest loanRequest){
        var loanResponse = loansService.checkLoanAvailability(loanRequest);
        return ResponseEntity.ok(loanResponse);
    }

}
