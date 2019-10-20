package com.challenge.saleservice.business.Impl;

import com.challenge.saleservice.business.SaleBusiness;
import com.challenge.saleservice.exception.SaleUpdateException;
import com.challenge.saleservice.exception.SaleNotFoundException;
import com.challenge.saleservice.model.Sale;
import com.challenge.saleservice.model.enums.Status;
import com.challenge.saleservice.repository.SaleRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SaleBusinessImpl implements SaleBusiness {
    @Autowired
    private SaleRepository saleRepository;

    @Override
    public Optional<Sale> create(@NonNull Sale sale) {
        sale.setConfirmationDate(null);
        sale.setStatus(Status.OPEN);
        return Optional.of(saleRepository.saveAndFlush(sale));
    }

    @Override
    public Optional<List<Sale>> read() {
        return Optional.of(saleRepository.findAll());
    }

    @Override
    public Optional<Sale> update(@NonNull Sale sale) {
        valideUpdateSale(sale.getStatus(), sale.getConfirmationDate());

        saleRepository.findById(sale.getId())
                .orElseThrow(SaleNotFoundException::new);

        return Optional.of(saleRepository.saveAndFlush(sale));
    }

    @Override
    public void delete(@NonNull Integer id) {
        saleRepository.findById(id)
                .orElseThrow(SaleNotFoundException::new);

        saleRepository.deleteById(id);
    }

    @Override
    public Optional<Sale> findById(@NonNull Integer id) {
        return Optional.of(saleRepository.findById(id)
                .orElseThrow(SaleNotFoundException::new));
    }

    @Override
    public Optional<List<Sale>> findByParameters(@NonNull String status) {
        return Optional.of(saleRepository.findByParameters(status));
    }

    protected void valideUpdateSale(@NonNull final Status status, Date confirmationDate) {
        if (status == Status.CONCLUDED && confirmationDate == null)
            throw new SaleUpdateException();
    }
}
