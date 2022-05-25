package com.ict.group06.travelwala.entity.flight;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document("flights")
@Getter
@NoArgsConstructor
public class Flight {
    @Id
    private String id;

    @Field("code")
    @Setter
    @Indexed(unique = true, name = "flight_code_generator")
    private String code;

    @Field("adult_economic_price")
    private Double adultEconomicPrice;

    @Field("adult_business_price")
    private Double adultBusinessPrice;

    @Field("discount_rate")
    private Double discountRate;

    @DBRef(db = "airports")
    @Field("departure_airports")
    private Airport departureAirport;

    @DBRef(db = "airports")
    @Field("arrival_airports")
    private Airport arrivalAirport;

    @Field("departure_time")
    private LocalDateTime departureTime;

    @Field("expected_arrival_time")
    private LocalDateTime expectedArrivalTime;

    @Field("occupied_economic_seats")
    private Integer occupiedEconomicSeats;

    @Field("occupied_business_seats")
    private Integer occupiedBusinessSeats;

    @DBRef(db = "agencies")
    @Field("agency")
    private Agency agency;

    @DBRef(db = "planes")
    @Field("plane")
    private Plane plane;

    public Flight(Double adultEconomicPrice, Double adultBusinessPrice, Double discountRate,
                  Airport departureAirport, Airport arrivalAirport, LocalDateTime departureTime,
                  LocalDateTime expectedArrivalTime, Agency agency, Plane plane) {
        this.adultEconomicPrice = adultEconomicPrice;
        this.adultBusinessPrice = adultBusinessPrice;
        this.discountRate = discountRate;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureTime = departureTime;
        this.expectedArrivalTime = expectedArrivalTime;
        this.occupiedEconomicSeats = 0;
        this.occupiedBusinessSeats = 0;
        this.agency = agency;
        this.plane = plane;
    }

    public Flight(Double adultEconomicPrice, Double adultBusinessPrice, Double discountRate,
                  Airport departureAirport, Airport arrivalAirport, LocalDateTime departureTime,
                  LocalDateTime expectedArrivalTime, Integer occupiedEconomicSeats, Integer occupiedBusinessSeats,
                  Agency agency, Plane plane) {
        this.adultEconomicPrice = adultEconomicPrice;
        this.adultBusinessPrice = adultBusinessPrice;
        this.discountRate = discountRate;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureTime = departureTime;
        this.expectedArrivalTime = expectedArrivalTime;
        this.occupiedEconomicSeats = occupiedEconomicSeats;
        this.occupiedBusinessSeats = occupiedBusinessSeats;
        this.agency = agency;
        this.plane = plane;
    }
}
