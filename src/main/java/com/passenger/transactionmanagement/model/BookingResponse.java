package com.passenger.transactionmanagement.model;

import com.passenger.transactionmanagement.entity.PassengerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {
    private String status;
    private double totalFare;
    private String pnr;
    private PassengerInfo passengerInfo;
}
