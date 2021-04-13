package com.udinei.dio.ecommerce.payment.api.config;

import com.udinei.dio.ecommerce.payment.api.streaming.CheckoutProcessor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(CheckoutProcessor.class)
public class StreamingConfig {

}
