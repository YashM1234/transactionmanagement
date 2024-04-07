package com.passenger.transactionmanagement.model;

import com.passenger.transactionmanagement.entity.PassengerInfo;
import com.passenger.transactionmanagement.entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequest {
    public PaymentInfo paymentInfo;
    public PassengerInfo passengerInfo;
}
