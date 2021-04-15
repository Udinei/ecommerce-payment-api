package com.udinei.dio.ecommerce.payment.api.service;

import com.udinei.dio.ecommerce.checkout.event.CheckoutCreatedEvent;
import com.udinei.dio.ecommerce.payment.api.entity.PaymentEntity;
import com.udinei.dio.ecommerce.payment.api.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public Optional<PaymentEntity> create(CheckoutCreatedEvent checkoutCreatedEvent) {
        final PaymentEntity paymentEntity = PaymentEntity.builder()
                .checkoutCode(checkoutCreatedEvent.getCheckoutCode().toString())
                .code(UUID.randomUUID().toString())
                .build();

        paymentRepository.save(paymentEntity);
        return Optional.of(paymentEntity);
    }
}