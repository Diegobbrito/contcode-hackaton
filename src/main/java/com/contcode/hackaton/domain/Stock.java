package com.contcode.hackaton.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Stock {

    private String code;
    private String companyName;
    private String companyDocument;
    private String type;

    public Stock(String code, String companyName, String companyDocument, String type) {
        this.code = code;
        this.companyName = companyName;
        this.companyDocument = companyDocument;
        this.type = type;
    }
}
