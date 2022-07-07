package com.ict.group06.travelwala.accounting.service.impl;

import com.ict.group06.travelwala.accounting.entity.Invoice;
import com.ict.group06.travelwala.accounting.repository.InvoiceRepository;
import com.ict.group06.travelwala.accounting.service.ICreateInvoice;
import com.ict.group06.travelwala.common.enumeration.seatclass.SeatClassEnum;
import com.ict.group06.travelwala.flight.service.ICalculateFlightFare;
import com.ict.group06.travelwala.mapstruct.mappers.InvoiceMapper;
import com.ict.group06.travelwala.model.request.CreateBookingFlightSpecs;
import com.ict.group06.travelwala.model.response.CreateInvoiceResponse;
import com.ict.group06.travelwala.ticket.enumeration.TicketEnum;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements ICreateInvoice {
    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper mapper = Mappers.getMapper(InvoiceMapper.class);

    @Override
    public CreateInvoiceResponse createInvoice(String bookingId, double totalAmount) {
        Invoice invoice = invoiceRepository.save(new Invoice(totalAmount, bookingId));

        return mapper.invoiceToInvoiceResponse(invoice);
    }
}
