package com.papu.contoller;

import com.papu.model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private static Map<String, Customer> customerDatabase = new HashMap<>();

    // Create a new customer
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        if (customerDatabase.containsKey(customer.getCustomerId())) {
            return ResponseEntity.status(409).body(null); // Conflict
        }
        customerDatabase.put(customer.getCustomerId(), customer);
        return ResponseEntity.ok(customer);
    }

    // Retrieve customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable String id) {
        Customer customer = customerDatabase.get(id);
        if (customer == null) {
            return ResponseEntity.notFound().build(); // Not found
        }
        return ResponseEntity.ok(customer);
    }
}
