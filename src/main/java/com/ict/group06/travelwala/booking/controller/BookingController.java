package com.ict.group06.travelwala.booking.controller;

import com.ict.group06.travelwala.model.request.CreateBookingRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @PostMapping()
    public ResponseEntity<?> book(@Valid @RequestBody CreateBookingRequest bookingRequest) {
        return null;
    }
}
