package com.passenger.transactionmanagement.controller;

import com.passenger.transactionmanagement.model.BookingRequest;
import com.passenger.transactionmanagement.model.BookingResponse;
import com.passenger.transactionmanagement.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/booking")
    public BookingResponse bookTicket(@RequestBody BookingRequest bookingRequest) {
        return bookingService.bookTicket(bookingRequest);
    }
}
