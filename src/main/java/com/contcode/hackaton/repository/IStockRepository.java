package com.contcode.hackaton.repository;

import com.contcode.hackaton.domain.Stock;

import java.util.List;

public interface IStockRepository {
    List<Stock> findAllByCode(List<String> code);
}
