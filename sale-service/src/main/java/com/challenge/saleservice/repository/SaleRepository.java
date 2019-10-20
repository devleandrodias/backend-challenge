package com.challenge.saleservice.repository;

import com.challenge.saleservice.model.Sale;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Integer>, JpaSpecificationExecutor<Sale> {
    default List<Sale> findByParameters(String status) {
        return findAll(Specification.where(statusLike(status)));
    }

    static Specification<Sale> statusLike(String status) {
        return (status == null || status.isEmpty()) ? null : (Specification<Sale>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("status"),
                ("%"+status+"%"));
    }
}
