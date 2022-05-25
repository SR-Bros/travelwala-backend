package com.ict.group06.travelwala.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
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

    @DBRef
    @Setter
    private Booking booking;

    public Invoice(String code, LocalDateTime createdAt, Booking booking) {
        this.code = code;
        this.totalCost = booking.totalCost();
        this.booking = booking;
        this.createdAt = createdAt;
    }
}
