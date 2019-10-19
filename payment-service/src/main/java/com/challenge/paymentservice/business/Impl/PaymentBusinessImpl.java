package com.challenge.paymentservice.business.Impl;

import com.challenge.paymentservice.business.PaymentBusiness;
import com.challenge.paymentservice.exception.PaymentNotFoundException;
import com.challenge.paymentservice.model.Payment;
import com.challenge.paymentservice.repository.PaymentRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentBusinessImpl implements PaymentBusiness {
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Optional<Payment> create(@NonNull Payment payment) {
        return Optional.of(paymentRepository.saveAndFlush(payment));
    }

    @Override
    public Optional<List<Payment>> read() {
        return Optional.of(paymentRepository.findAll());
    }

    @Override
    public Optional<Payment> update(@NonNull Payment payment) {
        paymentRepository.findById(payment.getId())
                .orElseThrow(PaymentNotFoundException::new);

        return Optional.of(paymentRepository.saveAndFlush(payment));
    }

    @Override
    public void delete(@NonNull Integer id) {
        paymentRepository.findById(id)
                .orElseThrow(PaymentNotFoundException::new);

        paymentRepository.deleteById(id);
    }

    @Override
    public Optional<Payment> findById(@NonNull Integer id) {
        return Optional.of(paymentRepository.findById(id)
                .orElseThrow(PaymentNotFoundException::new));
    }
}
