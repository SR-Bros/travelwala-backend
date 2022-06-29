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

    @Field("flight_ticket_ids")
    @Setter
    private List<String> flightTicketIds;

    @Field("contact_id")
    @Setter
    private String contactId;

    @Field("status")
    @Setter
    private String status;

    @Field("created_at")
    private LocalDateTime createdAt;

    public Booking(List<String> flightTicketIds, String contactId) {
        this.flightTicketIds = flightTicketIds;
        this.contactId = contactId;
        this.createdAt = LocalDateTime.now();
    }
}
