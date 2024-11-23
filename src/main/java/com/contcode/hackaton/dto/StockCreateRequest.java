package com.contcode.hackaton.dto;

public record StockCreateRequest(
        String code,
        String companyName,
        String companyDocument,
        String type
) {
}
