package com.challenge.saleservice.seed;

import com.challenge.saleservice.model.Sale;
import lombok.NonNull;

import java.util.Date;

public class SaleSeeder extends SeederGeneric {
    public static Sale store(@NonNull final Integer id) {
        return Sale.builder()
                .id(id)
                .confirmationDate(new Date())
                .createdAt(new Date())
                .build();
    }

    public static Sale store() {
        return store(faker().number().randomDigit());
    }
}
