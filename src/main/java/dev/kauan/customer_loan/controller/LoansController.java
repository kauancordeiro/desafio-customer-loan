package dev.kauan.customer_loan.controller;

import dev.kauan.customer_loan.entities.Loans;
import dev.kauan.customer_loan.services.LoansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/loans")
public class LoansController {

    @Autowired
    private LoansService loansService;

    @PostMapping
    public ResponseEntity<Loans> insertLoan(@RequestBody Loans loans){
        Loans finalLoan = loansService.insertLoans(loans);
        if(finalLoan != null){
            return ResponseEntity.ok(finalLoan);
        }
        return ResponseEntity.badRequest().build();
    }

}
