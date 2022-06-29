package com.ict.group06.travelwala.booking.entity;

import com.ict.group06.travelwala.flight.entity.Flight;
import com.ict.group06.travelwala.passenger.Passenger;
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
