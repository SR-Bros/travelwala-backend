package com.ict.group06.travelwala.entity.flight;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("infant_tickets")
public class InfantTicket extends Ticket {
    public InfantTicket(String seatClass, Flight flight, Passenger passenger) {
        this.seatClass = seatClass;
        this.flight = flight;
        this.passenger = passenger;
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
