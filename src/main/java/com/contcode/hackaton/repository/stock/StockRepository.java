package com.contcode.hackaton.repository.stock;

import com.contcode.hackaton.adapter.StockAdapter;
import com.contcode.hackaton.domain.Stock;
import com.contcode.hackaton.repository.IStockRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StockRepository implements IStockRepository {

    public StockRepository(JPAStockRepository repository) {
        this.repository = repository;
    }

    private final JPAStockRepository repository;

    @Override
    public List<Stock> findAllByCode(List<String> code) {
        var stocks = repository.findAllByCode(code);
        return StockAdapter.toStocks(stocks);
    }
}
