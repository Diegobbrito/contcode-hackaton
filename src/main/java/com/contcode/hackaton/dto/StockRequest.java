package com.contcode.hackaton.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class StockRequest {

    private List<StockDTO> stocks;

}
