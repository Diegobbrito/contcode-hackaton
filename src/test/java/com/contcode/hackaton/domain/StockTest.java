package com.contcode.hackaton.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockTest {

    @Test
    void testStockConstructorAndGetters() {
        String expectedCode = "AAPL";
        String expectedCompanyName = "Apple Inc.";
        String expectedCompanyDocument = "123456789";
        String expectedType = "TECH";

        Stock stock = new Stock(expectedCode, expectedCompanyName, expectedCompanyDocument, expectedType);

        assertEquals(expectedCode, stock.getCode());
        assertEquals(expectedCompanyName, stock.getCompanyName());
        assertEquals(expectedCompanyDocument, stock.getCompanyDocument());
        assertEquals(expectedType, stock.getType());
    }

    @Test
    void testSetters() {
        Stock stock = new Stock("MSFT", "Microsoft Corporation", "987654321", "TECH");

        stock.setCode("GOOGL");
        stock.setCompanyName("Google LLC");
        stock.setCompanyDocument("1122334455");
        stock.setType("IT");

        assertEquals("GOOGL", stock.getCode());
        assertEquals("Google LLC", stock.getCompanyName());
        assertEquals("1122334455", stock.getCompanyDocument());
        assertEquals("IT", stock.getType());
    }

    @Test
    void testStockEqualsAndHashCode() {
        Stock stock1 = new Stock("AAPL", "Apple Inc.", "123456789", "TECH");
        Stock stock2 = new Stock("AAPL", "Apple Inc.", "123456789", "TECH");
        Stock stock3 = new Stock("MSFT", "Microsoft Corporation", "987654321", "TECH");

        assertEquals(stock1, stock2);
        assertNotEquals(stock1, stock3);
        assertEquals(stock1.hashCode(), stock2.hashCode());
        assertNotEquals(stock1.hashCode(), stock3.hashCode());
    }
}
