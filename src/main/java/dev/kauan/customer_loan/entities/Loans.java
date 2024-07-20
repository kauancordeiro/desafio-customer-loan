package dev.kauan.customer_loan.entities;

import dev.kauan.customer_loan.exceptions.LoanNotAvailableException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Loans {

    private Customer customer;


    // PERSONAL
    public boolean isPersonalLoanAvailable() {
        return isbasicAvailableLoan();
    }

    public double getPersonalLoanInterestRate(){
        if(isPersonalLoanAvailable()){
            return 4.0;
        }
        throw new LoanNotAvailableException();
    }

    // CONSIGMENT
    public boolean isConsignmentLoanAvailable(){
        if(customer.isIncomeEqualOrGreaterThan(5000.0)){
            return true;
        }
        return false;
    }

    public double getConsignmentLoanInterestRate(){
        if(isConsignmentLoanAvailable()){
            return 2.0;
        }
        throw new LoanNotAvailableException();
    }

    //GUARANTEED

    public boolean isGuaranteedLoanAvailable(){
        return isbasicAvailableLoan();
    }


    public double getGuaranteedLoanAvailable(){
        if (isGuaranteedLoanAvailable()){
            return 3.0;
        }
        throw new LoanNotAvailableException();
    }

    // Basic available loan
    // using in personal and guaranteed
    private boolean isbasicAvailableLoan() {
        if(customer.isIncomeEqualOrLowerThan(3000.0)){
            return true;
        }
        return customer.isIncomeBetween(3000.0, 5000.0)
                && customer.isAgeLowerThan(30)
                && customer.isFromLocation("SP");
    }


}
