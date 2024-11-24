package com.contcode.hackaton.service;

import com.contcode.hackaton.adapter.StockAdapter;
import com.contcode.hackaton.domain.Stock;
import com.contcode.hackaton.dto.StockCreateRequest;
import com.contcode.hackaton.dto.StockDTO;
import com.contcode.hackaton.dto.StockRequest;
import com.contcode.hackaton.dto.StockResponse;
import com.contcode.hackaton.repository.exception.StockNotFoundException;
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
        return StockAdapter.toResponse(result, stockRequest.getStocks());
    }

    public void add(StockCreateRequest request) {
        Stock stock = new Stock(
                request.code(),
                request.companyName(),
                request.companyDocument(),
                request.type());
        stockRepository.add(stock);
    }

    public void update(StockCreateRequest request) {
        Stock stock = new Stock(
                request.code(),
                request.companyName(),
                request.companyDocument(),
                request.type());
        stockRepository.update(stock);
    }

    public void delete(String stock) {
        var optional = stockRepository.findByCode(stock);
        if(optional.isEmpty())
            throw new StockNotFoundException();
        stockRepository.deleteById(optional.get().getId());
    }
}
