package com.spring.graphq.trade;

import com.spring.graphq.filter.DoFilter;
import com.spring.graphq.filter.SearchCriteria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

@Service
public class TradeService {

    private final TradeRepo tradeRepo;

    private final Logger logger= LoggerFactory.getLogger(TradeService.class);
    private final EntityManager entityManager;

    public TradeService(TradeRepo tradeRepo, EntityManager entityManager) {
        this.tradeRepo = tradeRepo;
        this.entityManager = entityManager;
    }

    public List<PhysicalTrade> getTradeList(){
        return tradeRepo.findAll();
    }

    public PhysicalTrade getTradeListById(String tradeId){
        return tradeRepo.findByTradeId(tradeId);
    }

    public List<Object> getInventoryByCriteria(List<SearchCriteria> searchBuilder,String fieldName) {
        try {
            List<PhysicalTrade> physicalTrades = tradeRepo.findAll(DoFilter.getSpecificationWithOperation(searchBuilder,null), Sort.by(Sort.Direction.DESC,"createdTimestamp"));
            List<Object> finalList=new ArrayList<>();
            physicalTrades.forEach(e->{
                try {
                    var val=new PropertyDescriptor(fieldName, PhysicalTrade.class).getReadMethod().invoke(e);
                    if(val!=null)finalList.add(val);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            });
            System.out.println(finalList);
            return finalList;
        }
        catch (Exception ex) {
            logger.error("Error is: ", ex);
        }
        return new ArrayList<>();
    }


    public List<PhysicalTrade> getInventoryByCriteriaGraphQl(List<SearchCriteria> searchBuilder) {
        try {
            List<PhysicalTrade> physicalTrades = tradeRepo.findAll(DoFilter.getSpecificationWithOperation(searchBuilder,null), Sort.by(Sort.Direction.DESC,"createdTimestamp"));
            return physicalTrades;
        }
        catch (Exception ex) {
            logger.error("Error is: ", ex);
        }
        return new ArrayList<>();
    }


    public List<Object> getListByFieldName(List<SearchCriteria> searchBuilder, String fieldName) {
        List<Object> list=new ArrayList<>();
        try {
            var cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Object> cr = cb.createQuery(Object.class);
            Root<PhysicalTrade> root = cr.from(PhysicalTrade.class);
            searchBuilder.forEach(e->{
                if(e.getOperation().equals("equals")){
                    cr.where(cb.equal(root.get(e.getFieldName()), e.getValue()));
                }else{
                    cr.select(root).where(cb.like(root.get(e.getFieldName()), "%"+e.getValue()+"%"));
                }
            }); 
            cr.select(root).where(cb.isNotNull(root.get(fieldName)));
//            cr.select(root.get(fieldName));
            var result = entityManager.createQuery(cr).getResultList();
            System.out.println(result);
        }
        catch (Exception ex) {
            logger.error("Error is: ", ex);
        }
        return new ArrayList<>();
    }
}
