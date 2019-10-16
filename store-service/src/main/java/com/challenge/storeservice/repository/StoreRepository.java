package com.challenge.storeservice.repository;

import com.challenge.storeservice.model.Store;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Integer>, JpaSpecificationExecutor<Store> {
    default List<Store> findByParameters(String name) {
        return findAll(Specification.where(nameLike(name)));
    }

    static Specification<Store> nameLike(String name) {
        return (name == null || name.isEmpty()) ? null : (Specification<Store>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("name"),
                ("%"+name+"%"));
    }
}
