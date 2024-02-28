package com.spring.graphq.trade;

import com.spring.graphq.filter.DoFilter;
import com.spring.graphq.filter.SearchCriteria;
import com.spring.graphq.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TradeService {

    private final TradeRepo tradeRepo;

    private final Logger logger= LoggerFactory.getLogger(TradeService.class);

    public TradeService(TradeRepo tradeRepo) {
        this.tradeRepo = tradeRepo;
    }

    public List<PhysicalTrade> getTradeList(){
        return tradeRepo.findAll();
    }

    public PhysicalTrade getTradeListById(String tradeId){
        return tradeRepo.findByTradeId(tradeId);
    }

    public List<PhysicalTrade> getInventoryByCriteria(List<SearchCriteria> searchBuilder) {
        try {
            List<PhysicalTrade> physicalTrades = tradeRepo.findAll(DoFilter.getSpecificationWithOperation(searchBuilder,null), Sort.by(Sort.Direction.DESC,"createdTimestamp"));
            return physicalTrades;
        }
        catch (Exception ex) {
            logger.error("Error is: ", ex);
        }
        return new ArrayList<>();
    }
}
