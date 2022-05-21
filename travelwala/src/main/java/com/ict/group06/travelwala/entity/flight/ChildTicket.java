package com.ict.group06.travelwala.entity.flight;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("child_tickets")
public class ChildTicket extends Ticket {
    private ChildTicket(String seatClass, Flight flight, Passenger passenger) {
        this.seatClass = seatClass;
        this.flight = flight;
        this.passenger = passenger;
    }

    @Override
    public double getPrice() {
        return super.getPrice() * this.flight.getAgency().getChildPriceRate();
    }
}
