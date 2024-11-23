package com.contcode.hackaton.repository.stock;

import com.contcode.hackaton.domain.Stock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StockRepositoryTest {

    @Mock
    private JPAStockRepository jpaStockRepository;

    private StockRepository stockRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        stockRepository = new StockRepository(jpaStockRepository);
    }

    @Test
    void testFindAllByCode() {
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

        when(jpaStockRepository.findAllByCode(List.of("AAPL", "MSFT"))).thenReturn(stockEntities);

        List<Stock> stocks = stockRepository.findAllByCode(List.of("AAPL", "MSFT"));

        assertNotNull(stocks);
        assertEquals(2, stocks.size());
        assertEquals("AAPL", stocks.get(0).getCode());
        assertEquals("MSFT", stocks.get(1).getCode());

        verify(jpaStockRepository, times(1)).findAllByCode(List.of("AAPL", "MSFT"));
    }
}
