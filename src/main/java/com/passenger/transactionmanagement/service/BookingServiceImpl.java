package com.passenger.transactionmanagement.service;

import com.passenger.transactionmanagement.entity.PassengerInfo;
import com.passenger.transactionmanagement.entity.PaymentInfo;
import com.passenger.transactionmanagement.exception.InsufficientBalanceException;
import com.passenger.transactionmanagement.model.BookingRequest;
import com.passenger.transactionmanagement.model.BookingResponse;
import com.passenger.transactionmanagement.repo.PassengerInfoRepo;
import com.passenger.transactionmanagement.repo.PaymentInfoRepo;
import com.passenger.transactionmanagement.util.PaymentGatewaySimulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private PaymentInfoRepo paymentInfoRepo;
    @Autowired
    private PassengerInfoRepo passengerInfoRepo;

    @Override
    @Transactional(rollbackFor = {InsufficientBalanceException.class}, readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public BookingResponse bookTicket(BookingRequest bookingRequest) {

        BookingResponse bookingResponse = null;
        PassengerInfo passengerInfo = passengerInfoRepo.save(bookingRequest.getPassengerInfo());

        PaymentInfo paymentInfo = bookingRequest.getPaymentInfo();

        PaymentGatewaySimulator.validateFareBalanceCriteria(paymentInfo.getAccountNo(), passengerInfo.getFare());

        paymentInfo.setPassengerId(passengerInfo.getPassengerId());
        paymentInfo.setTotalFare(passengerInfo.getFare());
        paymentInfoRepo.save(paymentInfo);

        bookingResponse = new BookingResponse();
        bookingResponse.setStatus("SUCCESS");
        bookingResponse.setPassengerInfo(passengerInfo);
        bookingResponse.setPnr(UUID.randomUUID().toString().split("-")[0]);
        bookingResponse.setTotalFare(passengerInfo.getFare());

        return bookingResponse;
    }
}
