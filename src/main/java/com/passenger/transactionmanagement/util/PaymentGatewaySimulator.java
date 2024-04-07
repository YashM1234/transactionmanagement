package com.passenger.transactionmanagement.util;

import com.passenger.transactionmanagement.exception.InsufficientBalanceException;

import java.util.HashMap;
import java.util.Map;

public class PaymentGatewaySimulator {
    private static Map<String, Double> accountBalanceMap = new HashMap<>();

    static{
        accountBalanceMap.put("acnt-1212", 2000.00);
        accountBalanceMap.put("acnt-1313", 4000.00);
        accountBalanceMap.put("acnt-1414", 3000.00);
    }

    public static boolean validateFareBalanceCriteria(String accountNo, Double fare) throws InsufficientBalanceException {

        if (fare > accountBalanceMap.get(accountNo)) {
            throw new InsufficientBalanceException("you do not have sufficient balance in your account");
        }
        return true;
    }
}
