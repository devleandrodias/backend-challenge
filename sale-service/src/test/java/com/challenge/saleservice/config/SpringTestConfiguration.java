package com.challenge.saleservice.config;

import com.challenge.saleservice.business.Impl.SaleBusinessImpl;
import com.challenge.saleservice.business.SaleBusiness;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

public class SpringTestConfiguration {
    @Bean
    @Profile("saleBusiness")
    public SaleBusiness storeBusiness() { return new SaleBusinessImpl(); }
}
