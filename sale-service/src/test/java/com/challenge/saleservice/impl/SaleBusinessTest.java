package com.challenge.saleservice.impl;

import com.challenge.saleservice.business.SaleBusiness;
import com.challenge.saleservice.config.SpringTestConfiguration;
import com.challenge.saleservice.exception.SaleNotFoundException;
import com.challenge.saleservice.model.Sale;
import com.challenge.saleservice.repository.SaleRepository;
import com.challenge.saleservice.seed.SaleSeeder;
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
@ActiveProfiles(profiles = "saleBusiness")
@ContextConfiguration(classes = SpringTestConfiguration.class)
@RunWith(SpringRunner.class)
public class SaleBusinessTest {
    @MockBean
    private SaleRepository saleRepository;

    @Autowired
    private SaleBusiness saleBusiness;

    @Test
    public void createSale() {
        var sale = SaleSeeder.store(1);

        Mockito.when(this.saleRepository.saveAndFlush(ArgumentMatchers.any(Sale.class)))
                .thenReturn(sale);

        var saleCreated = saleBusiness.create(sale);

        Assert.assertTrue(saleCreated.isPresent());
        Assert.assertNotNull(saleCreated.get().getId());
        Assert.assertNotNull(saleCreated.get().getConfirmationDate());
    }

    @Test
    public void read() {
        Mockito.when(this.saleRepository.findAll())
                .thenReturn(Arrays.asList(SaleSeeder.store(1), SaleSeeder.store(2)));

        var sales = saleBusiness.read();

        Assert.assertTrue(sales.isPresent());
        Assert.assertTrue(sales.get().size() > 0);
    }

    @Test
    public void updateSale() {
        var sale = SaleSeeder.store(1);

        Mockito.when(this.saleRepository.findById(1))
                .thenReturn(Optional.of(SaleSeeder.store(1)));

        Mockito.when(this.saleRepository.saveAndFlush(ArgumentMatchers.any(Sale.class)))
                .thenReturn(sale);

        var saleUpdated = saleBusiness.update(sale);

        Assert.assertTrue(saleUpdated.isPresent());
        Assert.assertNotNull(saleUpdated.get().getId());
        Assert.assertNotNull(saleUpdated.get().getConfirmationDate());
    }

    @Test(expected = SaleNotFoundException.class)
    public void updateSaleIdNotExist() {
        Mockito.when(this.saleRepository.findById(ArgumentMatchers.anyInt()))
                .thenThrow(new SaleNotFoundException());

        this.saleBusiness.findById(1);
    }

    @Test(expected = SaleNotFoundException.class)
    public void updateSaleIdZero() {
        Mockito.when(this.saleRepository.findById(0))
                .thenThrow(new SaleNotFoundException());

        this.saleBusiness.findById(1);
    }

    @Test(expected = SaleNotFoundException.class)
    public void updateSaleIdNegative() {
        Mockito.when(this.saleRepository.findById(-1))
                .thenThrow(new SaleNotFoundException());

        this.saleBusiness.findById(1);
    }

    @Test
    public void findByIdExist() {
        Mockito.when(this.saleRepository.findById(1))
                .thenReturn(Optional.of(SaleSeeder.store(1)));

        var sale = this.saleBusiness.findById(1);

        Assert.assertTrue(sale.isPresent());
        Assert.assertNotNull(sale.get().getId());
        Assert.assertEquals(Integer.valueOf(1), sale.get().getId());
    }

    @Test(expected = SaleNotFoundException.class)
    public void findByIdNotExist() {
        Mockito.when(this.saleRepository.findById(ArgumentMatchers.anyInt()))
                .thenThrow(new SaleNotFoundException());

        this.saleBusiness.findById(1);
    }

    @Test(expected = SaleNotFoundException.class)
    public void findByIdZero() {
        Mockito.when(this.saleRepository.findById(0))
                .thenThrow(new SaleNotFoundException());

        this.saleBusiness.findById(1);
    }

    @Test(expected = SaleNotFoundException.class)
    public void findByIdNegative() {
        Mockito.when(this.saleRepository.findById(-1))
                .thenThrow(new SaleNotFoundException());

        this.saleBusiness.findById(1);
    }
}
