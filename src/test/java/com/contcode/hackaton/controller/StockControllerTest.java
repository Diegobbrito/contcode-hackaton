package com.contcode.hackaton.controller;

import com.contcode.hackaton.dto.StockDTO;
import com.contcode.hackaton.dto.StockRequest;
import com.contcode.hackaton.dto.StockResponse;
import com.contcode.hackaton.dto.StockResponseDTO;
import com.contcode.hackaton.service.StockService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StockControllerTest {

    private StockService stockService;
    private StockController stockController;

    @BeforeEach
    void setUp() {
        stockService = mock(StockService.class);
        stockController = new StockController(stockService);
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

        StockResponseDTO stockResponseDTO1 = new StockResponseDTO();
        stockResponseDTO1.setCode("AAPL");
        stockResponseDTO1.setDescription("10 ações da empresa Apple Inc., código AAPL");

        StockResponseDTO stockResponseDTO2 = new StockResponseDTO();
        stockResponseDTO2.setCode("MSFT");
        stockResponseDTO2.setDescription("5 ações da empresa Microsoft Corp., código MSFT");

        StockResponse expectedResponse = new StockResponse(List.of(stockResponseDTO1, stockResponseDTO2));
        when(stockService.stock(stockRequest)).thenReturn(expectedResponse);

        ResponseEntity<StockResponse> response = stockController.stock(stockRequest);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
        assertEquals(2, response.getBody().getStocks().size());
        assertEquals("AAPL", response.getBody().getStocks().get(0).getCode());
        assertEquals("MSFT", response.getBody().getStocks().get(1).getCode());
        verify(stockService, times(1)).stock(stockRequest);
    }
}
