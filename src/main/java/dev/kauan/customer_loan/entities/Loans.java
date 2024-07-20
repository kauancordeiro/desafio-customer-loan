package dev.kauan.customer_loan.entities;

import dev.kauan.customer_loan.exceptions.LoanNotAvailableException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Loans {

    private Customer customer;


    public boolean isPersonalLoanAvailable() {
        if (customer.isIncomeEqualOrLowerThan(3000.0)) {
            return true;
        }
         return customer.isIncomeBetween(3000.0, 5000.0)
                && customer.isAgeLowerThan(30)
                && customer.isFromLocation("SP");



    }

    public Double getPersonalLoanInterestRate(){
        if(isPersonalLoanAvailable()){
            return 4.0;
        }
        throw new LoanNotAvailableException();
    }


}
