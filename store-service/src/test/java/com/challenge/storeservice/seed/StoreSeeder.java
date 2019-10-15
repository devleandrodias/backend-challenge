package com.challenge.storeservice.seed;

import com.challenge.storeservice.model.Store;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.Date;

public class StoreSeeder extends SeederGeneric {
    public static Store store(@NonNull final Integer id) {
        return Store.builder()
                .id(id)
                .name(faker().bothify("##########"))
                .createdAt(new Date())
                .build();
    }

    public static Store store() {
        return store(faker().number().randomDigit());
    }
}
