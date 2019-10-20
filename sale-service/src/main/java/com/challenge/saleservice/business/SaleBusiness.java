package com.challenge.saleservice.business;

import com.challenge.saleservice.model.Sale;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;

public interface SaleBusiness {
    Optional<Sale> create(@NonNull final Sale sale);
    Optional<List<Sale>> read();
    Optional<Sale> update(@NonNull final Sale sale);
    void delete(@NonNull final Integer id);
    Optional<Sale> findById(@NonNull final Integer id);
    Optional<List<Sale>> findByParameters(@NonNull final String status);
}
