package com.challenge.storeservice.business;

import com.challenge.storeservice.model.Store;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;

public interface StoreBusiness {
    Optional<Store> create(@NonNull final Store store);
    Optional<List<Store>> read();
    Optional<Store> update(@NonNull final Store store);
    void delete(@NonNull final Integer id);
    Optional<Store> findById(@NonNull final Integer id);
}
