package com.contcode.hackaton.adapter;

import com.contcode.hackaton.domain.Stock;
import com.contcode.hackaton.dto.StockDTO;
import com.contcode.hackaton.dto.StockResponse;
import com.contcode.hackaton.dto.StockResponseDTO;
import com.contcode.hackaton.repository.stock.StockEntity;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StockAdapterTest {

    @Test
    void testToStocks() {
        StockEntity stockEntity1 = new StockEntity();
        stockEntity1.setCode("AAPL");
        stockEntity1.setCompanyName("Apple Inc.");
        stockEntity1.setCompanyDocument("123456789");
        stockEntity1.setType("TECH");

        StockEntity stockEntity2 = new StockEntity();
        stockEntity2.setCode("MSFT");
        stockEntity2.setCompanyName("Microsoft Corp.");
        stockEntity2.setCompanyDocument("987654321");
        stockEntity2.setType("TECH");

        List<StockEntity> stockEntities = List.of(stockEntity1, stockEntity2);
        List<Stock> stocks = StockAdapter.toStocks(stockEntities);

        assertEquals(2, stocks.size());
        assertEquals("AAPL", stocks.get(0).getCode());
        assertEquals("Apple Inc.", stocks.get(0).getCompanyName());
        assertEquals("MSFT", stocks.get(1).getCode());
    }

    @Test
    void testToResponse() {
        Stock stock1 = new Stock("AAPL", "Apple Inc.", "123456789", "TECH");
        Stock stock2 = new Stock("MSFT", "Microsoft Corp.", "987654321", "TECH");
        List<Stock> stocks = List.of(stock1, stock2);

        StockDTO stockDTO1 = new StockDTO();
        stockDTO1.setCode("AAPL");
        stockDTO1.setQuantity(10);
        stockDTO1.setValue(new BigDecimal("150.00"));

        StockDTO stockDTO2 = new StockDTO();
        stockDTO2.setCode("MSFT");
        stockDTO2.setQuantity(5);
        stockDTO2.setValue(new BigDecimal("300.00"));
        List<StockDTO> stockRequest = List.of(stockDTO1, stockDTO2);

        StockResponse stockResponse = StockAdapter.toResponse(stocks, stockRequest);

        assertNotNull(stockResponse);
        assertEquals(2, stockResponse.getStocks().size());

        StockResponseDTO response1 = stockResponse.getStocks().get(0);
        assertNotNull(response1);
        assertEquals("AAPL", response1.getCode());
        assertTrue(response1.getDescription().contains("10 ações da empresa Apple Inc."));

        StockResponseDTO response2 = stockResponse.getStocks().get(1);
        assertNotNull(response2);
        assertEquals("MSFT", response2.getCode());
        assertTrue(response2.getDescription().contains("5 ações da empresa Microsoft Corp."));
    }

    @Test
    void testCalculateTotalValue() {
        try {
            var method = StockAdapter.class.getDeclaredMethod("calculateTotalValue", int.class, BigDecimal.class);
            method.setAccessible(true);
            String totalValue = (String) method.invoke(null, 10, new BigDecimal("150.00"));

            assertEquals("R$ 1.500,00", totalValue);
        } catch (Exception e) {
            fail("Reflection failed: " + e.getMessage());
        }
    }
}
