package com.udinei.dio.ecommerce.payment.api.repository;

import com.udinei.dio.ecommerce.payment.api.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
}
