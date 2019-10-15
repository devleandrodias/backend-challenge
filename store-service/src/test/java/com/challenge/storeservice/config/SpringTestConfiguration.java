package com.challenge.storeservice.config;

import com.challenge.storeservice.business.Impl.StoreBusinessImpl;
import com.challenge.storeservice.business.StoreBusiness;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

public class SpringTestConfiguration {
    @Bean
    @Profile("storeBusiness")
    public StoreBusiness storeBusiness() { return new StoreBusinessImpl(); }
}
