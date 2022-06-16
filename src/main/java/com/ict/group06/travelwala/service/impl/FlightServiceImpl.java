package com.ict.group06.travelwala.service.impl;

import com.ict.group06.travelwala.entity.flight.Flight;
import com.ict.group06.travelwala.exception.FlightLocationException;
import com.ict.group06.travelwala.exception.FlightTimeException;
import com.ict.group06.travelwala.exception.PassengerException;
import com.ict.group06.travelwala.exception.RecordNotFoundException;
import com.ict.group06.travelwala.model.request.FlightCriteria;
import com.ict.group06.travelwala.model.request.FlightRequest;
import com.ict.group06.travelwala.model.response.FlightResponse;
import com.ict.group06.travelwala.model.response.SearchFlightResponse;
import com.ict.group06.travelwala.repository.AirlineRepository;
import com.ict.group06.travelwala.repository.AirportRepository;
import com.ict.group06.travelwala.repository.FlightRepository;
import com.ict.group06.travelwala.repository.PlaneRepository;
import com.ict.group06.travelwala.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;
    private final AirportRepository airportRepository;
    private final PlaneRepository planeRepository;
    private final AirlineRepository airlineRepository;

    @Override
    public SearchFlightResponse findAll(FlightCriteria flightCriteria) {
        if(flightCriteria.getAdultCount() < 1 || flightCriteria.getChildCount() < 0 || flightCriteria.getInfantCount() < 0) {
            throw new PassengerException("Invalid seats count");
        }

        if(flightCriteria.getDepartureCity().equalsIgnoreCase(flightCriteria.getArrivalCity())) {
            throw new FlightLocationException("Departure city must differ from arrival city");
        }

        if(flightCriteria.getReturnDate() != null &&
            flightCriteria.getReturnDate().isBefore(flightCriteria.getDepartureDate()) &&
            !flightCriteria.getReturnDate().isEqual(flightCriteria.getDepartureDate())) {
            throw new FlightTimeException("Invalid return date or departure date");
        }

        List<FlightResponse> departureFlights = new ArrayList<>();
        List<FlightResponse> arrivalFlights = new ArrayList<>();

        this.flightRepository.findWithCriteria(flightCriteria).forEach(flight -> {
            // build departure flights
            if(flight.getDepartureTime().isAfter(LocalDateTime.now()) &&
                flight.getDepartureTime().toLocalDate().isEqual(flightCriteria.getDepartureDate())
            ) {
                departureFlights.add(new FlightResponse(flight));
            }

            // build return flights
            if(flightCriteria.getReturnDate() != null &&
                flight.getDepartureTime().toLocalDate().isEqual(flightCriteria.getReturnDate())) {
                arrivalFlights.add(new FlightResponse(flight));
            }
        });

        return new SearchFlightResponse(departureFlights, arrivalFlights);
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
        Flight flight = new Flight();

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
        flight.setAirline(airlineRepository.findById(flightRequest.getAgencyId()).orElseThrow(()->
                new RecordNotFoundException("Agency not found")
        ));
        flight.setPlane(planeRepository.findById(flightRequest.getPlaneId()).orElseThrow(()->
                new RecordNotFoundException("Plane not found")
        ));
        flight.setDepartureTime(flightRequest.getDepartureTime());
        flight.setExpectedArrivalTime(flightRequest.getExpectedArrivalTime());

        return new FlightResponse(flightRepository.save(flight));
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
        flight.setAirline(airlineRepository.findById(flightRequest.getAgencyId()).orElseThrow(()->
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
