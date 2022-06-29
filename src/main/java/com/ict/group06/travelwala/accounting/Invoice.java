package com.ict.group06.travelwala.accounting;

import com.ict.group06.travelwala.booking.entity.Booking;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document("invoices")
@Getter
@NoArgsConstructor
public class Invoice {
    @Id
    private String id;

    @Field("code")
    @Indexed(unique = true, name = "invoice_code_unique")
    @Setter
    private String code;

    @Field("total_cost")
    @Setter
    private double totalCost;

    @Field("created_at")
    @Setter
    private LocalDateTime createdAt;

    @Field("booking_id")
    @Setter
    private String bookingId;

    public Invoice(double totalCost, LocalDateTime createdAt, String bookingId) {
        this.totalCost = totalCost;
        this.createdAt = createdAt;
        this.bookingId = bookingId;
    }
}
