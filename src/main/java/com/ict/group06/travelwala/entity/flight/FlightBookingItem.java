package com.ict.group06.travelwala.entity.flight;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document("flight_bookings")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FlightBookingItem {
    @DBRef
    @Field("tickets")
    private List<Ticket> tickets;

    public double getItemCost() {
        return tickets.stream().map(Ticket::getPrice).reduce(0.0, Double::sum);
    }

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    public void removeTicket(String ticketId) {
        this.tickets.removeIf(ticket -> ticket.id.equals(ticketId));
    }
}
