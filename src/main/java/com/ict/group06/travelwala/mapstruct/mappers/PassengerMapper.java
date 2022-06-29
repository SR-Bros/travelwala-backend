package com.ict.group06.travelwala.mapstruct.mappers;

import com.ict.group06.travelwala.model.request.PassengerRequest;
import com.ict.group06.travelwala.model.response.PassengerResponse;
import com.ict.group06.travelwala.passenger.entity.Passenger;
import org.mapstruct.Mapper;

@Mapper
public interface PassengerMapper {
    Passenger passengerRequestToPassenger(PassengerRequest passengerRequest);
    PassengerResponse passengerToPassengerResponse(Passenger passenger);
}
