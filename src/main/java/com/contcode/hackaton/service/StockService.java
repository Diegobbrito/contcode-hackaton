package com.contcode.hackaton.service;

import com.contcode.hackaton.adapter.StockAdapter;
import com.contcode.hackaton.dto.StockDTO;
import com.contcode.hackaton.dto.StockRequest;
import com.contcode.hackaton.dto.StockResponse;
import com.contcode.hackaton.repository.stock.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public StockResponse stock(StockRequest stockRequest) {
        List<String> stocksCode = stockRequest.getStocks().stream().map(StockDTO::getCode).toList();
        var result = stockRepository.findAllByCode(stocksCode);
        return StockAdapter.toResponse(result);
    }
}
