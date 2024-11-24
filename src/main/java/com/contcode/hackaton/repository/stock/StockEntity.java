package com.contcode.hackaton.repository.stock;

import com.contcode.hackaton.domain.Stock;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Stock")
@NoArgsConstructor
public class StockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String companyName;
    private String companyDocument;
    private String type;

    public StockEntity(Stock stock) {
        this.code = stock.getCode();
        this.companyName = stock.getCompanyName();
        this.companyDocument = stock.getCompanyDocument();
        this.type = stock.getType();
    }
}
