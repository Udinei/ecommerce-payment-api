package com.udinei.dio.ecommerce.payment.api.streaming;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * Processor - vai Receber a msg, processar e jogor em outro topico no brocker
 * */
public interface CheckoutProcessor {

    String  OUTPUT = "payment-paid-output";
    String  INPUT = "checkout-created-input";

    @Output(OUTPUT)
    MessageChannel output();

    @Input(INPUT)
    SubscribableChannel input();



}
