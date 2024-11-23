package com.contcode.hackaton.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class StockDTO {

    private String code;
    private int quantity;
    private BigDecimal value;

}
