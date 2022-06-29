package com.ict.group06.travelwala.booking.entity;

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

    @Field("flight_tickets")
    @Setter
    private List<String> flightTicketIds;

    @Field("status")
    @Setter
    private String status;

    @Field("created_at")
    private LocalDateTime createdAt;

    public Booking(List<String> flightTicketIds) {
        this.flightTicketIds = flightTicketIds;
        this.createdAt = LocalDateTime.now();
    }
}
