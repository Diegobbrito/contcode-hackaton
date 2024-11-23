package com.contcode.hackaton.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StockResponse {

    List<StockResponseDTO> stocks;

}
