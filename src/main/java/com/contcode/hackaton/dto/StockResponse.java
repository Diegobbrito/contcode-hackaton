package com.contcode.hackaton.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class StockResponse {

    List<StockResponseDTO> stocks;

}
