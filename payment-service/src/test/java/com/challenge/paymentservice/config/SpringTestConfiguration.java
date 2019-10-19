package com.challenge.paymentservice.config;

import com.challenge.paymentservice.business.Impl.PaymentBusinessImpl;
import com.challenge.paymentservice.business.PaymentBusiness;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

public class SpringTestConfiguration {
    @Bean
    @Profile("paymentBusiness")
    public PaymentBusiness paymentBusiness() { return new PaymentBusinessImpl(); }
}
