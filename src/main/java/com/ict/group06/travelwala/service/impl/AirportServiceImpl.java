package com.ict.group06.travelwala.service.impl;

import com.ict.group06.travelwala.entity.flight.Airport;
import com.ict.group06.travelwala.exception.RecordNotFoundException;
import com.ict.group06.travelwala.model.response.AirportResponse;
import com.ict.group06.travelwala.repository.AirportRepository;
import com.ict.group06.travelwala.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AirportServiceImpl implements AirportService {
    private final AirportRepository airportRepository;

    @Override
    public List<AirportResponse> findAll() {
        return airportRepository
                .findAll()
                .stream()
                .map(AirportResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public AirportResponse findById(String id) {
        Airport airport = airportRepository
                .findById(id)
                .orElseThrow(() -> new RecordNotFoundException("No airport found for id" + id));
        return new AirportResponse(airport);
    }
}
