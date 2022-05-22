package com.ict.group06.travelwala.repository;

import com.ict.group06.travelwala.entity.flight.FlightBooking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightBookingRepository extends MongoRepository<FlightBooking, String> {
}
