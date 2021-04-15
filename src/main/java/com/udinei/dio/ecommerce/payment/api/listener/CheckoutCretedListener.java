package com.udinei.dio.ecommerce.payment.api.listener;


import com.udinei.dio.ecommerce.checkout.event.CheckoutCreatedEvent;
import com.udinei.dio.ecommerce.payment.api.entity.PaymentEntity;
import com.udinei.dio.ecommerce.payment.event.PaymentCreatedEvent;
import com.udinei.dio.ecommerce.payment.api.service.PaymentService;
import com.udinei.dio.ecommerce.payment.api.streaming.CheckoutProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * Essa classe fica escutando a lista de mensagem do brocker, um Checkout foi criado verifica a entrada
 */

@Component
@RequiredArgsConstructor
public class CheckoutCretedListener {

    private final CheckoutProcessor checkoutProcessor;
    private final PaymentService paymentService;


    @StreamListener(CheckoutProcessor.INPUT)
    public void handler(CheckoutCreatedEvent checkoutCreatedEvent){
        // processa pagamento gateway
        // salvar os dados do pagamento
        // enviar o evento do pagamento processado
        
        // cria pagamento com dados vindo do CheckoutProcessor.INPUT
        final PaymentEntity paymentEntity = paymentService.create(checkoutCreatedEvent).orElseThrow();

        // cria o evento de pagamento processado
        final PaymentCreatedEvent paymentCreatedEvent = PaymentCreatedEvent.newBuilder()
                .setCheckoutCode(paymentEntity.getCheckoutCode())
                .setPaymentCode(paymentEntity.getCode())
                .build();

        // envia msg de pagamento processado para o brocker
        checkoutProcessor.output().send(MessageBuilder.withPayload(paymentCreatedEvent).build());

    }
}
