package com.contcode.hackaton.repository;

import com.contcode.hackaton.domain.Stock;
import com.contcode.hackaton.repository.stock.StockEntity;

import java.util.List;
import java.util.Optional;

public interface IStockRepository {
    List<Stock> findAllByCode(List<String> code);

    void add(Stock stock);

    void update(Stock stock);

    Optional<StockEntity> findByCode(String stock);

    void deleteById(Integer id);
}
