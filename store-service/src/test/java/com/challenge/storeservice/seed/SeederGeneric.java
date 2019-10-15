package com.challenge.storeservice.seed;

import com.github.javafaker.Faker;

public class SeederGeneric {
    private static final Faker faker = new Faker();

    protected static Faker faker(){
        return faker;
    }
}
