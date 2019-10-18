package com.challenge.saleservice.business.Impl;

import com.challenge.saleservice.business.SaleBusiness;
import com.challenge.saleservice.exception.SaleNotFoundException;
import com.challenge.saleservice.model.Sale;
import com.challenge.saleservice.repository.SaleRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleBusinessImpl implements SaleBusiness {
    @Autowired
    private SaleRepository saleRepository;

    @Override
    public Optional<Sale> create(@NonNull Sale sale) {
        return Optional.of(saleRepository.saveAndFlush(sale));
    }

    @Override
    public Optional<List<Sale>> read() {
        return Optional.of(saleRepository.findAll());
    }

    @Override
    public Optional<Sale> update(@NonNull Sale sale) {
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
}
