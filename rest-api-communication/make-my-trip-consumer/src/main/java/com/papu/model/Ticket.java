package com.papu.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class Ticket {
    private String ticketId;
    private String eventName;
    private LocalDateTime eventDate;
    private String seatNumber;
    private double price;
    private Customer customer;
}
