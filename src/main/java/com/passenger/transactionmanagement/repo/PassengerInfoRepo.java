package com.passenger.transactionmanagement.repo;

import com.passenger.transactionmanagement.entity.PassengerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerInfoRepo extends JpaRepository<PassengerInfo, Long> {
}
