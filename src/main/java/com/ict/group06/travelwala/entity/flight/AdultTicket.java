package com.ict.group06.travelwala.entity.flight;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("adult_tickets")
public class AdultTicket extends Ticket {
    public AdultTicket(String seatClass, Flight flight, Passenger passenger) {
        this.seatClass = seatClass;
        this.flight = flight;
        this.passenger = passenger;
    }
}
