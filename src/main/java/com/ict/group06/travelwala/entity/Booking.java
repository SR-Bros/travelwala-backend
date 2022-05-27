package com.ict.group06.travelwala.entity;

import com.ict.group06.travelwala.entity.flight.FlightBookingItem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Document("bookings")
@Getter
@NoArgsConstructor
public class Booking {
    @Id
    private String id;

    @Field("flight_booking_items")
    @Setter
    private FlightBookingItem flightBookingItem;

    @Field("status")
    @Setter
    private String status;

    @Field("created_at")
    private LocalDateTime createdAt;

    public Booking(FlightBookingItem flightBookingItem) {
        this.flightBookingItem = flightBookingItem;
        this.createdAt = LocalDateTime.now();
    }

    public double totalCost() {
        return this.flightBookingItem.getItemCost();
    }
}