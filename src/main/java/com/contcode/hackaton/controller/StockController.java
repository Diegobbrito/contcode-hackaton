package com.contcode.hackaton.controller;

import com.contcode.hackaton.dto.StockCreateRequest;
import com.contcode.hackaton.dto.StockRequest;
import com.contcode.hackaton.dto.StockResponse;
import com.contcode.hackaton.service.StockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/stock")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping
    public ResponseEntity<StockResponse> stock(@RequestBody StockRequest stockRequest) {
        return ResponseEntity.ok(stockService.stock(stockRequest));
    }

    @PostMapping("/add")
    public ResponseEntity<Void> add(@RequestBody StockCreateRequest stockRequest) {
        stockService.add(stockRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> update(@RequestBody StockCreateRequest stockRequest) {
        stockService.update(stockRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("delete/{code}")
    public ResponseEntity<Void> delete(@RequestParam String stock) {
        stockService.delete(stock);
        return ResponseEntity.noContent().build();
    }

}
