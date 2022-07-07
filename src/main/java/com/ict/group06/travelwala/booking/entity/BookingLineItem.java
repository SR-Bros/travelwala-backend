package com.ict.group06.travelwala.booking.entity;

import org.springframework.data.mongodb.core.mapping.Field;

public abstract class BookingLineItem {
    @Field("unit_price")
    protected double unitPrice;

    @Field("quantity")
    protected int quantity;
}
