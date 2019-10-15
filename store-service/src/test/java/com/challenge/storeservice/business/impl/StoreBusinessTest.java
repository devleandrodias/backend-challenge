package com.challenge.storeservice.business.impl;

import com.challenge.storeservice.business.StoreBusiness;
import com.challenge.storeservice.config.SpringTestConfiguration;
import com.challenge.storeservice.exception.StoreNotFoundException;
import com.challenge.storeservice.model.Store;
import com.challenge.storeservice.repository.StoreRepository;
import com.challenge.storeservice.seed.StoreSeeder;
import com.github.javafaker.Faker;
import lombok.var;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Optional;

@TestPropertySource(properties = {"spring.config.location=classpath:application-test.properties"})
@ActiveProfiles(profiles = "storeBusiness")
@ContextConfiguration(classes = SpringTestConfiguration.class)
@RunWith(SpringRunner.class)
public class StoreBusinessTest {
    @MockBean
    private StoreRepository storeRepository;

    @Autowired
    private StoreBusiness storeBusiness;

    private static final Faker faker = new Faker();

    @Test
    public void createStore() {
        var store = StoreSeeder.store(1);

        Mockito.when(this.storeRepository.saveAndFlush(ArgumentMatchers.any(Store.class)))
                .thenReturn(store);

        var storeCreated = storeBusiness.create(store);

        Assert.assertTrue(storeCreated.isPresent());
        Assert.assertNotNull(storeCreated.get().getId());
        Assert.assertNotNull(storeCreated.get().getName());
    }

    @Test
    public void read() {
        Mockito.when(this.storeRepository.findAll())
                .thenReturn(Arrays.asList(StoreSeeder.store(1), StoreSeeder.store(2)));

        var stores = storeBusiness.read();

        Assert.assertTrue(stores.isPresent());
        Assert.assertTrue(stores.get().size() > 0);
    }

    @Test
    public void updateStore() {
        var store = StoreSeeder.store(1);

        Mockito.when(this.storeRepository.findById(1))
                .thenReturn(Optional.of(StoreSeeder.store(1)));

        Mockito.when(this.storeRepository.saveAndFlush(ArgumentMatchers.any(Store.class)))
                .thenReturn(store);

        var storeUpdated = storeBusiness.update(store);

        Assert.assertTrue(storeUpdated.isPresent());
        Assert.assertNotNull(storeUpdated.get().getId());
        Assert.assertNotNull(storeUpdated.get().getName());
    }

    @Test(expected = StoreNotFoundException.class)
    public void updateStoreIdNotExist() {
        Mockito.when(this.storeRepository.findById(ArgumentMatchers.anyInt()))
                .thenThrow(new StoreNotFoundException());

        this.storeBusiness.findById(1);
    }

    @Test
    public void findByIdExist() {
        Mockito.when(this.storeRepository.findById(1))
                .thenReturn(Optional.of(StoreSeeder.store(1)));

        var store = this.storeBusiness.findById(1);

        Assert.assertTrue(store.isPresent());
        Assert.assertNotNull(store.get().getId());
        Assert.assertEquals(Integer.valueOf(1), store.get().getId());
    }

    @Test(expected = StoreNotFoundException.class)
    public void findByIdNotExist() {
        Mockito.when(this.storeRepository.findById(ArgumentMatchers.anyInt()))
                .thenThrow(new StoreNotFoundException());

        this.storeBusiness.findById(1);
    }
}
