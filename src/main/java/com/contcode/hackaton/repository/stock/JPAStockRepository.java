package com.contcode.hackaton.repository.stock;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JPAStockRepository extends JpaRepository<StockEntity, Integer> {
    List<StockEntity> findAllByCode(List<String> code);

}
