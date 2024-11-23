package com.contcode.hackaton.repository.stock;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAStockRepository extends JpaRepository<StockEntity, Integer> {

}
