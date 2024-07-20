package dev.kauan.customer_loan.services;

import dev.kauan.customer_loan.entities.Customer;
import dev.kauan.customer_loan.repositories.CustomerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    private CustomerRespository customerRespository;

    public UUID insertCustomer(Customer customer){
        customerRespository.save(customer);
        return customer.getId();
    }


    public List<Customer> getAllCustomers() {
        return customerRespository.findAll();
    }

    public void remove(UUID id) {
        customerRespository.deleteById(id);
    }

    public boolean updateCustomer(UUID id, Customer customer) {
        Optional<Customer> optionalCustomer = customerRespository.findById(id);
        if(optionalCustomer.isPresent()){
            Customer finalCustomer = optionalCustomer.get();
            finalCustomer.setCpf(customer.getCpf());
            finalCustomer.setAge(customer.getAge());
            finalCustomer.setLocation(customer.getLocation());
            finalCustomer.setIncome(customer.getIncome());
            finalCustomer.setName(customer.getName());

            insertCustomer(finalCustomer);
            return true;
        }

        return false;



    }

    public Customer getCustomerById(UUID id) {
        Optional<Customer> optionalCustomer = customerRespository.findById(id);
        if(optionalCustomer.isPresent()){
            Customer finalCustomer = optionalCustomer.get();
            return finalCustomer;
        }
        return null;
    }
}
