package com.passenger.transactionmanagement.repo;

import com.passenger.transactionmanagement.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentInfoRepo extends JpaRepository<PaymentInfo, String> {
}
