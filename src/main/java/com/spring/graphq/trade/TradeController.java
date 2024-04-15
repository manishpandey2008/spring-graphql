package com.spring.graphq.trade;

import com.spring.graphq.filter.SearchCriteria;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trade")
public class TradeController {

    private final TradeService tradeService;

    public TradeController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @GetMapping("/update")
    public String getUpdate(){
        return "Trade Service is working Fine !!";
    }


    @GetMapping
    public List<PhysicalTrade> getTrade(){
        return tradeService.getTradeList();
    }

    @GetMapping("/by-id")
    public PhysicalTrade getTradeById(@RequestParam String id){
        return tradeService.getTradeListById(id);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/get-trade-by-criteria")
    public List<Object> getAllBook(@RequestBody List<SearchCriteria> searchBuilder,@RequestParam("fieldName") String fieldName){
        return tradeService.getInventoryByCriteria(searchBuilder,fieldName);
    }

}
