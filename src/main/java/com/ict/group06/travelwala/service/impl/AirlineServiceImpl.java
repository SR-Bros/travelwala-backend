package com.ict.group06.travelwala.service.impl;

import com.ict.group06.travelwala.entity.flight.Airline;
import com.ict.group06.travelwala.exception.RecordNotFoundException;
import com.ict.group06.travelwala.model.request.AirlineRequest;
import com.ict.group06.travelwala.model.response.AirlineResponse;
import com.ict.group06.travelwala.repository.AirlineRepository;
import com.ict.group06.travelwala.service.AirlineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AirlineServiceImpl implements AirlineService {
    private final AirlineRepository airlineRepository;

    @Override
    public List<AirlineResponse> findAll() {
        return airlineRepository
                .findAll()
                .stream()
                .map(AirlineResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public AirlineResponse findById(String id) {
        Airline airline = airlineRepository
                .findById(id)
                .orElseThrow(() -> new RecordNotFoundException("No agency found for id" + id));
        return new AirlineResponse(airline);
    }

    @Override
    public AirlineResponse createNewAirline(AirlineRequest airlineRequest) {
        Airline newAirline = new Airline(
                airlineRequest.getName(), airlineRequest.getAlias(),
                airlineRequest.getIata(), airlineRequest.getIcao(),
                airlineRequest.getCallSign(), airlineRequest.getCountry(),
                airlineRequest.getActive(), airlineRequest.getChildPriceRate()
        );
        return new AirlineResponse(airlineRepository.save(newAirline));
    }
}
