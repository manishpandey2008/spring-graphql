package com.spring.graphq.trade;


import com.spring.graphq.filter.SearchCriteria;
import com.spring.graphq.model.Book;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TradeGraphQlController {

    private final TradeService tradeService;

    public TradeGraphQlController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @QueryMapping("getTradeById")
    public PhysicalTrade getAllBook(@Argument String id){
        return tradeService.getTradeListById(id);
    }

    @QueryMapping("getTradeByCriteria")
    public List<PhysicalTrade> getAllBook(@Argument List<SearchCriteria> searchBuilder){
        return tradeService.getInventoryByCriteria(searchBuilder);
    }
}
