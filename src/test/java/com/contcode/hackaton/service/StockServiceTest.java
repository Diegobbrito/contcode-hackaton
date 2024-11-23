package com.contcode.hackaton.service;

import com.contcode.hackaton.adapter.StockAdapter;
import com.contcode.hackaton.domain.Stock;
import com.contcode.hackaton.dto.StockDTO;
import com.contcode.hackaton.dto.StockRequest;
import com.contcode.hackaton.dto.StockResponse;
import com.contcode.hackaton.repository.stock.StockRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class StockServiceTest {

    private StockRepository stockRepository;
    private StockService stockService;

    @BeforeEach
    void setUp() {
        stockRepository = mock(StockRepository.class);
        stockService = new StockService(stockRepository);
    }

    @Test
    void testStock() {
        StockDTO stockDTO1 = new StockDTO();
        stockDTO1.setCode("AAPL");
        stockDTO1.setQuantity(10);
        stockDTO1.setValue(new BigDecimal("150.00"));

        StockDTO stockDTO2 = new StockDTO();
        stockDTO2.setCode("MSFT");
        stockDTO2.setQuantity(5);
        stockDTO2.setValue(new BigDecimal("300.00"));

        StockRequest stockRequest = new StockRequest();
        stockRequest.setStocks(List.of(stockDTO1, stockDTO2));

        Stock stock1 = new Stock("AAPL", "Apple Inc.", "123456789", "TECH");
        Stock stock2 = new Stock("MSFT", "Microsoft Corp.", "987654321", "TECH");

        List<Stock> stockList = List.of(stock1, stock2);
        when(stockRepository.findAllByCode(List.of("AAPL", "MSFT"))).thenReturn(stockList);

        StockResponse expectedResponse = new StockResponse(List.of());

        try (MockedStatic<StockAdapter> mockedAdapter = Mockito.mockStatic(StockAdapter.class)) {
            mockedAdapter.when(() -> StockAdapter.toResponse(stockList, stockRequest.getStocks()))
                    .thenReturn(expectedResponse);

            StockResponse response = stockService.stock(stockRequest);

            assertNotNull(response);
            assertEquals(expectedResponse, response);

            verify(stockRepository, times(1)).findAllByCode(List.of("AAPL", "MSFT"));
            mockedAdapter.verify(() -> StockAdapter.toResponse(stockList, stockRequest.getStocks()), times(1));
        }
    }
}
