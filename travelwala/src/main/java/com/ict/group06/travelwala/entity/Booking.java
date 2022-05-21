package com.ict.group06.travelwala.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
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

    @Field("booking_items")
    private List<BookingItem> bookingItems;

    @Field("status")
    private String status;

    @Field("created_at")
    private LocalDateTime createdAt;

    public Booking(List<BookingItem> bookingItems, String status, LocalDateTime createdAt) {
        this.bookingItems = bookingItems;
        this.status = status;
        this.createdAt = createdAt;
    }

    public double totalCost() {
        return bookingItems.stream().map(BookingItem::getItemCost).reduce(0.0, Double::sum);
    }
}
