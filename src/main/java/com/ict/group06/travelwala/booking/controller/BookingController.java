package com.ict.group06.travelwala.booking.controller;

import com.ict.group06.travelwala.booking.service.ICreateBooking;
import com.ict.group06.travelwala.model.request.CreateBookingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final ICreateBooking createBooking;

    @PostMapping()
    public ResponseEntity<?> book(@Valid @RequestBody CreateBookingRequest bookingRequest) {
        return ResponseEntity.ok().body(createBooking.createBooking(bookingRequest));
    }
}
