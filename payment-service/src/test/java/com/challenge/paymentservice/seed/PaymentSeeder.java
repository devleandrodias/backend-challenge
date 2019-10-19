package com.challenge.paymentservice.seed;

import com.challenge.paymentservice.model.Payment;
import lombok.NonNull;

import java.util.Date;

public class PaymentSeeder extends SeederGeneric {
    public static Payment payment(@NonNull final Integer id) {
        return Payment.builder()
                .id(id)
                .creditCardNumber(faker().bothify("##########"))
                .createdAt(new Date())
                .build();
    }

    public static Payment payment() {
        return payment(faker().number().randomDigit());
    }
}
