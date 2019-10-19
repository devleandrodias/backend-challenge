package com.challenge.paymentservice.resources.mapper;

import com.challenge.paymentservice.model.Payment;
import com.challenge.paymentservice.resources.v1.dtos.PaymentRequestDto;
import com.challenge.paymentservice.resources.v1.dtos.PaymentResponseDto;
import lombok.NonNull;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PaymentMapper {
    public Optional<List<PaymentResponseDto>> serializeListToDto(@NonNull final Optional<List<Payment>> payments) {

        final var serializers = new ArrayList<PaymentResponseDto>();

        payments.ifPresent(t -> t.forEach(payment -> {
            serializers.add(serializeToDto(Optional.of(payment)).get());
        }));

        return Optional.of(serializers);
    }

    public Optional<PaymentResponseDto> serializeToDto(@NonNull final Optional<Payment> payment) {
        final var dto = payment.get();

        return Optional.of(PaymentResponseDto.builder()
                .id(dto.getId())
                .creditCardNumber(dto.getCreditCardNumber())
                .status(dto.getStatus())
                .createdAt(dto.getCreatedAt())
                .build());
    }

    public Optional<Payment> serializeToModel(@NonNull final Optional<PaymentRequestDto> paymentRequest) {
        final var model = paymentRequest.get();

        return Optional.of(Payment.builder()
                .id(model.getId())
                .creditCardNumber(model.getCreditCardNumber())
                .status(model.getStatus())
                .createdAt(model.getCreatedAt())
                .build());
    }
}
