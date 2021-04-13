package com.udinei.dio.ecommerce.payment.api.service;

import com.udinei.dio.ecommerce.payment.api.entity.PaymentEntity;
import com.udinei.dio.ecommerce.checkout.api.event.CheckoutCreatedEvent;
import java.util.Optional;

public interface PaymentService {

    Optional<PaymentEntity> create(CheckoutCreatedEvent checkoutCreatedEvent);
}
