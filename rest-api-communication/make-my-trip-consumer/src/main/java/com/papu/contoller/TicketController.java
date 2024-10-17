package com.papu.contoller;

import com.papu.model.Ticket;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    private static Map<String, Ticket> ticketDatabase = new HashMap<>();

    // Create a new ticket
    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        if (ticketDatabase.containsKey(ticket.getTicketId())) {
            return ResponseEntity.status(409).body(null);
        }
        ticket.setEventDate(LocalDateTime.now()); // Set the event date to now for demo purposes
        ticketDatabase.put(ticket.getTicketId(), ticket);
        return ResponseEntity.ok(ticket);
    }

    // Retrieve ticket by ID
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable String id) {
        Ticket ticket = ticketDatabase.get(id);
        if (ticket == null) {
            return ResponseEntity.notFound().build(); // Not found
        }
        return ResponseEntity.ok(ticket);
    }

}
