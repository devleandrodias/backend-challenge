package com.challenge.storeservice.repository;

import com.challenge.storeservice.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Integer> {
}
