package com.ict.group06.travelwala.accounting.service;

import com.ict.group06.travelwala.model.request.CreateBookingFlightSpecs;
import com.ict.group06.travelwala.model.response.CreateInvoiceResponse;

public interface ICreateInvoice {
    CreateInvoiceResponse createInvoice(String bookingId, CreateBookingFlightSpecs productSpecs);
}
