package com.ict.group06.travelwala.service.impl;

import com.ict.group06.travelwala.entity.flight.Airport;
import com.ict.group06.travelwala.exception.RecordNotFoundException;
import com.ict.group06.travelwala.model.request.AirportRequest;
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

    @Override
    public AirportResponse createNewAirport(AirportRequest airportRequest) {
        Airport newAirport = new Airport(airportRequest.getName(), airportRequest.getCity(), airportRequest.getCountry());
        return new AirportResponse(airportRepository.save(newAirport));
    }

    @Override
    public AirportResponse updateAirport(String id, AirportRequest airportRequest) {
        Airport oldAirport = airportRepository
                .findById(id)
                .orElseThrow(() -> new RecordNotFoundException("No airport found for id" + id));

        oldAirport.setName(airportRequest.getName());
        oldAirport.setCity(airportRequest.getCity());
        oldAirport.setCountry(airportRequest.getCountry());

        return new AirportResponse(airportRepository.save(oldAirport));
    }
}
