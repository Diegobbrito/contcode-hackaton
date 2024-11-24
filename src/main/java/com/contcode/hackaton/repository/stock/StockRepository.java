package com.contcode.hackaton.repository.stock;

import com.contcode.hackaton.adapter.StockAdapter;
import com.contcode.hackaton.domain.Stock;
import com.contcode.hackaton.repository.IStockRepository;
import com.contcode.hackaton.repository.exception.StockExistsException;
import com.contcode.hackaton.repository.exception.StockNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StockRepository implements IStockRepository {

    public StockRepository(JPAStockRepository repository) {
        this.repository = repository;
    }

    private final JPAStockRepository repository;

    @Override
    public List<Stock> findAllByCode(List<String> code) {
        var stocks = repository.findAllByCode(code);
        return StockAdapter.toStocks(stocks);
    }

    @Override
    public void add(Stock stock) {
        var optional = repository.findByCode(stock.getCode());
        if(optional.isPresent()){
            throw new StockExistsException();
        }
        var stockEntity = new StockEntity(stock);
        repository.save(stockEntity);
    }

    @Override
    public void update(Stock stock) {
        var optional = repository.findByCode(stock.getCode());
        if(optional.isEmpty()){
            throw new StockNotFoundException();
        }
        StockEntity entity = optional.get();

        if(stock.getCode() != null)
            entity.setCode(stock.getCode());
        if(stock.getType() != null)
            entity.setType(stock.getType());
        if(stock.getCompanyDocument() != null)
            entity.setCompanyDocument(stock.getCompanyDocument());
        if(stock.getCompanyName() != null)
            entity.setCompanyName(stock.getCompanyName());

        repository.save(entity);
    }

    @Override
    public Optional<StockEntity> findByCode(String stock) {
        return repository.findByCode(stock);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
