package com.ict.group06.travelwala.service.impl;

import com.ict.group06.travelwala.entity.flight.Flight;
import com.ict.group06.travelwala.exception.RecordNotFoundException;
import com.ict.group06.travelwala.model.request.FlightCriteria;
import com.ict.group06.travelwala.model.request.FlightRequest;
import com.ict.group06.travelwala.model.response.FlightResponse;
import com.ict.group06.travelwala.repository.AgencyRepository;
import com.ict.group06.travelwala.repository.AirportRepository;
import com.ict.group06.travelwala.repository.FlightRepository;
import com.ict.group06.travelwala.repository.PlaneRepository;
import com.ict.group06.travelwala.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;
    private final AirportRepository airportRepository;
    private final PlaneRepository planeRepository;
    private final AgencyRepository agencyRepository;

    @Override
    public List<FlightResponse> findAll(FlightCriteria flightCriteria) {
        if(flightCriteria.getAdultCount() >= 1 && flightCriteria.getChildCount() >=0 && flightCriteria.getInfantCount() >=0) {
            if(flightCriteria.getDepartureCity().compareToIgnoreCase(flightCriteria.getArrivalCity()) != 0 &&
                    (flightCriteria.getReturnDate().isAfter(flightCriteria.getDepartureDate())) || flightCriteria.getReturnDate().isEqual(flightCriteria.getDepartureDate())){
                 return this.flightRepository.findWithCriteria(flightCriteria).stream().map(FlightResponse::new).collect(Collectors.toList());
            }
        }
        return null;
    }

    @Override
    public FlightResponse findById(String id) {
        Flight flight = flightRepository.findById(id).orElseThrow(
                () -> new RecordNotFoundException("No flight found for id " + id)
        );
        return new FlightResponse(flight);
    }

    @Override
    public FlightResponse createNewFlight(FlightRequest flightRequest) {
        return null;
    }

    @Override
    public FlightResponse updateFlight(String id, FlightRequest flightRequest) {
        Flight flight = flightRepository.findById(id).orElseThrow(
                () -> new RecordNotFoundException("No flight found for id " + id)
        );
        flight.setCode(flightRequest.getCode());
        flight.setAdultEconomicPrice(flightRequest.getAdultEconomicPrice());
        flight.setAdultBusinessPrice(flightRequest.getAdultBusinessPrice());
        flight.setDiscountRate(flightRequest.getDiscountRate());
        flight.setArrivalAirport(airportRepository.findByName(flightRequest.getArrivalAirport()).orElseThrow(() ->
                new RecordNotFoundException("Arrival airport not found")
        ));
        flight.setDepartureAirport(airportRepository.findByName(flightRequest.getDepartureAirport()).orElseThrow(() ->
                new RecordNotFoundException("Departure airport not found")
        ));
        flight.setAgency(agencyRepository.findById(flightRequest.getAgencyId()).orElseThrow(()->
                new RecordNotFoundException("Agency not found")
        ));
        flight.setPlane(planeRepository.findById(flightRequest.getPlaneId()).orElseThrow(()->
                new RecordNotFoundException("Plane not found")
        ));
        flight.setDepartureTime(flightRequest.getDepartureTime());
        flight.setExpectedArrivalTime(flightRequest.getExpectedArrivalTime());
        return new FlightResponse(flightRepository.save(flight));
    }
}
