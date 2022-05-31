package com.ict.group06.travelwala.entity.flight;

import com.ict.group06.travelwala.entity.flight.Flight;
import com.ict.group06.travelwala.entity.flight.Passenger;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
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
