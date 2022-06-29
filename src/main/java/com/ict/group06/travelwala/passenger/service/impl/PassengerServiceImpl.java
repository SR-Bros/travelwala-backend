package com.ict.group06.travelwala.passenger.service.impl;

import com.ict.group06.travelwala.model.request.PassengerRequest;
import com.ict.group06.travelwala.model.response.PassengerResponse;
import com.ict.group06.travelwala.passenger.repository.PassengerRepository;
import com.ict.group06.travelwala.passenger.service.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PassengerServiceImpl implements PassengerService {
    private final PassengerRepository passengerRepository;

    @Override
    public PassengerResponse savePassenger(PassengerRequest passengerRequest) {
        return null;
    }
}
