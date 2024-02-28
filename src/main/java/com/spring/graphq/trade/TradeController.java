package com.spring.graphq.trade;

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

}
