package com.challenge.paymentservice.business.impl;

import com.challenge.paymentservice.business.PaymentBusiness;
import com.challenge.paymentservice.config.SpringTestConfiguration;
import com.challenge.paymentservice.exception.PaymentNotFoundException;
import com.challenge.paymentservice.model.Payment;
import com.challenge.paymentservice.repository.PaymentRepository;
import com.challenge.paymentservice.seed.PaymentSeeder;
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
@ActiveProfiles(profiles = "paymentBusiness")
@ContextConfiguration(classes = SpringTestConfiguration.class)
@RunWith(SpringRunner.class)
public class PaymentBusinessTest {
    @MockBean
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentBusiness paymentBusiness;

    @Test
    public void createPayment() {
        var payment = PaymentSeeder.payment(1);

        Mockito.when(this.paymentRepository.saveAndFlush(ArgumentMatchers.any(Payment.class)))
                .thenReturn(payment);

        var paymentCreated = paymentBusiness.create(payment);

        Assert.assertTrue(paymentCreated.isPresent());
        Assert.assertNotNull(paymentCreated.get().getId());
        Assert.assertNotNull(paymentCreated.get().getCreditCardNumber());
    }

    @Test
    public void read() {
        Mockito.when(this.paymentRepository.findAll())
                .thenReturn(Arrays.asList(PaymentSeeder.payment(1), PaymentSeeder.payment(2)));

        var payments = paymentBusiness.read();

        Assert.assertTrue(payments.isPresent());
        Assert.assertTrue(payments.get().size() > 0);
    }

    @Test
    public void updatePayment() {
        var payment = PaymentSeeder.payment(1);

        Mockito.when(this.paymentRepository.findById(1))
                .thenReturn(Optional.of(PaymentSeeder.payment(1)));

        Mockito.when(this.paymentRepository.saveAndFlush(ArgumentMatchers.any(Payment.class)))
                .thenReturn(payment);

        var paymentUpdated = paymentBusiness.update(payment);

        Assert.assertTrue(paymentUpdated.isPresent());
        Assert.assertNotNull(paymentUpdated.get().getId());
        Assert.assertNotNull(paymentUpdated.get().getCreditCardNumber());
    }

    @Test(expected = PaymentNotFoundException.class)
    public void updatePaymentIdNotExist() {
        Mockito.when(this.paymentRepository.findById(ArgumentMatchers.anyInt()))
                .thenThrow(new PaymentNotFoundException());

        this.paymentBusiness.findById(1);
    }

    @Test(expected = PaymentNotFoundException.class)
    public void updatePaymentIdZero() {
        Mockito.when(this.paymentRepository.findById(0))
                .thenThrow(new PaymentNotFoundException());

        this.paymentBusiness.findById(1);
    }

    @Test(expected = PaymentNotFoundException.class)
    public void updatePaymentIdNegative() {
        Mockito.when(this.paymentRepository.findById(-1))
                .thenThrow(new PaymentNotFoundException());

        this.paymentBusiness.findById(1);
    }

    @Test
    public void findByIdExist() {
        Mockito.when(this.paymentRepository.findById(1))
                .thenReturn(Optional.of(PaymentSeeder.payment(1)));

        var payment = this.paymentBusiness.findById(1);

        Assert.assertTrue(payment.isPresent());
        Assert.assertNotNull(payment.get().getId());
        Assert.assertEquals(Integer.valueOf(1), payment.get().getId());
    }

    @Test(expected = PaymentNotFoundException.class)
    public void findByIdNotExist() {
        Mockito.when(this.paymentRepository.findById(ArgumentMatchers.anyInt()))
                .thenThrow(new PaymentNotFoundException());

        this.paymentBusiness.findById(1);
    }

    @Test(expected = PaymentNotFoundException.class)
    public void findByIdZero() {
        Mockito.when(this.paymentRepository.findById(0))
                .thenThrow(new PaymentNotFoundException());

        this.paymentBusiness.findById(1);
    }

    @Test(expected = PaymentNotFoundException.class)
    public void findByIdNegative() {
        Mockito.when(this.paymentRepository.findById(-1))
                .thenThrow(new PaymentNotFoundException());

        this.paymentBusiness.findById(1);
    }
}
