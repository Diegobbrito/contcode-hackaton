package com.contcode.hackaton.adapter;

import com.contcode.hackaton.domain.Stock;
import com.contcode.hackaton.dto.StockDTO;
import com.contcode.hackaton.dto.StockResponse;
import com.contcode.hackaton.dto.StockResponseDTO;
import com.contcode.hackaton.repository.stock.StockEntity;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@AllArgsConstructor
public class StockAdapter {

    private static final String TEMPLATE = "%d ações da empresa %s, %s com CNPJ %s, com valor total de %s";

    public static List<Stock> toStocks(List<StockEntity> stocks) {
        return stocks.stream().map(s -> new Stock(s.getCode(), s.getCompanyName(), s.getCompanyDocument(), s.getType())).toList();
    }

    private static String calculateTotalValue(int quantity, BigDecimal value) {
        BigDecimal totalValue = value.multiply(new BigDecimal(quantity));
        return "R$ " + new DecimalFormat(
                "#,###,##0.00",
                new DecimalFormatSymbols(new Locale("pt", "BR")))
                .format(totalValue);
    }

    public static StockResponse toResponse(List<Stock> stocks, List<StockDTO> stockRequest) {

        var stockResponse = stocks.stream().map(s -> {
            Optional<StockDTO> optional = stockRequest.stream().filter(stockDTO -> stockDTO.getCode().equals(s.getCode())).findFirst();
            if (optional.isPresent()) {
                StockResponseDTO response = new StockResponseDTO();
                response.setCode(s.getCode());
                response.setCompanyDocument(s.getCompanyDocument());
                String value = calculateTotalValue(optional.get().getQuantity(), optional.get().getValue());
                response.setDescription(String.format(TEMPLATE, optional.get().getQuantity(), s.getCompanyName(), s.getCode(), s.getCompanyDocument(), value));
                return response;
            }
            return null;
        }).toList();
        return new StockResponse(stockResponse);

    }
}
