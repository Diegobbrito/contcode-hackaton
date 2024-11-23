package com.contcode.hackaton.service;

import com.contcode.hackaton.dto.StockRequest;
import com.contcode.hackaton.dto.StockResponse;
import com.contcode.hackaton.repository.stock.StockRepository;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public StockResponse stock(StockRequest stockRequest) {

        return null;
    }
}
