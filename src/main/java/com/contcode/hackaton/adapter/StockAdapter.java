package com.contcode.hackaton.adapter;

import com.contcode.hackaton.domain.Stock;
import com.contcode.hackaton.dto.StockResponse;
import com.contcode.hackaton.repository.stock.StockEntity;
import lombok.AllArgsConstructor;

import java.util.List;


@AllArgsConstructor
public class StockAdapter {

    public static List<Stock> toStocks(List<StockEntity> stocks) {
       return stocks.stream().map(s -> new Stock(s.getCode(), s.getCompanyName(), s.getCompanyDocument(), s.getType())).toList();
    }

    public static StockResponse toResponse(List<Stock> stocks){
        return new StockResponse();
    }
}
