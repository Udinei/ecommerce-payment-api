package com.udinei.dio.ecommerce.payment.api.service;

import com.udinei.dio.ecommerce.checkout.event.CheckoutCreatedEvent;
import com.udinei.dio.ecommerce.payment.api.entity.PaymentEntity;

import java.util.Optional;

public interface PaymentService {

    Optional<PaymentEntity> create(CheckoutCreatedEvent checkoutCreatedEvent);
}
