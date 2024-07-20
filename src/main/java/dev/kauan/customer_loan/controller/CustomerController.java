package dev.kauan.customer_loan.controller;

import dev.kauan.customer_loan.entities.Customer;
import dev.kauan.customer_loan.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<UUID> insertCustomer(@RequestBody Customer customer){
        UUID id = customerService.insertCustomer(customer);
        if(id != null){
            return ResponseEntity.ok(id);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomer(){
        List<Customer> customerList = customerService.getAllCustomers();
        if(customerList != null){
            return ResponseEntity.ok(customerList);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeCustomer(@PathVariable UUID id){
        customerService.remove(id);
        return ResponseEntity.ok("Removed");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable UUID id, @RequestBody Customer customer){
        boolean update = customerService.updateCustomer(id,customer);
        if(update){
            Customer updatedCustomer = customerService.getCustomerById(id);
            return ResponseEntity.ok(updatedCustomer);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }


}
