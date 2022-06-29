package com.ict.group06.travelwala.booking.entity;

import com.ict.group06.travelwala.flight.entity.Flight;
import com.ict.group06.travelwala.passenger.Passenger;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
public abstract class Ticket {
    @Id
    protected String id;

    @Field("seat_class")
    @Setter
    protected String seatClass;

    @Setter
    protected Flight flight;

    @Setter
    protected Passenger passenger;

    public double getPrice() {
        if(this.seatClass.equals("")) {
            return this.flight.getAdultBusinessPrice();
        }
        else {
            return this.flight.getAdultEconomicPrice();
        }
    }
}
