package com.papu.controller;

import com.papu.model.Customer;
import com.papu.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/make-my-trip")
public class MakeMyTripController {

    private final String CUSTOMER_SERVICE_URL = "http://localhost:8015/customers"; // Adjust port as necessary
    private final String TICKET_SERVICE_URL = "http://localhost:8015/tickets"; // Adjust port as necessary

    @Autowired
    private RestTemplate restTemplate;

    // Create a customer
    @PostMapping("/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        ResponseEntity<Customer> response = restTemplate.postForEntity(CUSTOMER_SERVICE_URL, customer, Customer.class);
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }

    // Retrieve a customer by ID
    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable String id) {
        Customer customer = restTemplate.getForObject(CUSTOMER_SERVICE_URL + "/" + id, Customer.class);
        return customer != null ? ResponseEntity.ok(customer) : ResponseEntity.notFound().build();
    }

    // Create a ticket
    @PostMapping("/tickets")
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        ResponseEntity<Ticket> response = restTemplate.postForEntity(TICKET_SERVICE_URL, ticket, Ticket.class);
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }

    // Retrieve a ticket by ID
    @GetMapping("/tickets/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable String id) {
        Ticket ticket = restTemplate.getForObject(TICKET_SERVICE_URL + "/" + id, Ticket.class);
        return ticket != null ? ResponseEntity.ok(ticket) : ResponseEntity.notFound().build();
    }
}
