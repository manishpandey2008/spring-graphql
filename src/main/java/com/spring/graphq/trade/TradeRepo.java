package com.spring.graphq.trade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TradeRepo extends JpaRepository<PhysicalTrade, UUID>, JpaSpecificationExecutor<PhysicalTrade> {

    PhysicalTrade findByTradeId(String tradeId);
}
