package com.contcode.hackaton.repository.stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface JPAStockRepository extends JpaRepository<StockEntity, Integer> {
    @Query(""" 
            SELECT s FROM StockEntity s
            WHERE s.code IN :codes
            """)
    List<StockEntity> findAllByCode(List<String> codes);

    Optional<StockEntity> findByCode(String code);
}
