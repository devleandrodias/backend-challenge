package com.challenge.storeservice.business.Impl;

import com.challenge.storeservice.business.StoreBusiness;
import com.challenge.storeservice.exception.StoreNotFoundException;
import com.challenge.storeservice.model.Store;
import com.challenge.storeservice.repository.StoreRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class StoreBusinessImpl implements StoreBusiness {
    @Autowired
    private StoreRepository storeRepository;

    @Override
    public Optional<Store> create(@NonNull Store store) {
        return Optional.of(storeRepository.saveAndFlush(store));
    }

    @Override
    public Optional<List<Store>> read() {
        return Optional.of(storeRepository.findAll());
    }

    @Override
    public Optional<Store> update(@NonNull Store store) {
        storeRepository.findById(store.getId())
                .orElseThrow(StoreNotFoundException::new);

        return Optional.of(storeRepository.saveAndFlush(store));
    }

    @Override
    public void delete(@NonNull Integer id) {
        storeRepository.findById(id)
                .orElseThrow(StoreNotFoundException::new);

        storeRepository.deleteById(id);
    }

    @Override
    public Optional<Store> findById(@NonNull Integer id) {
        return Optional.of(storeRepository.findById(id)
                .orElseThrow(StoreNotFoundException::new));
    }
}
