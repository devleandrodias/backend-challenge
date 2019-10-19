package com.challenge.paymentservice.business;

import com.challenge.paymentservice.model.Payment;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;

public interface PaymentBusiness {
    Optional<Payment> create(@NonNull final Payment payment);
    Optional<List<Payment>> read();
    Optional<Payment> update(@NonNull final Payment payment);
    void delete(@NonNull final Integer id);
    Optional<Payment> findById(@NonNull final Integer id);
}
