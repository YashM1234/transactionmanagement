package com.passenger.transactionmanagement.service;

import com.passenger.transactionmanagement.model.BookingRequest;
import com.passenger.transactionmanagement.model.BookingResponse;

public interface BookingService {
    BookingResponse bookTicket(BookingRequest bookingRequest);
}
