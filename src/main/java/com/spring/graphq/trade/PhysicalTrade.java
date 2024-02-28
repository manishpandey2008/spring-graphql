package com.spring.graphq.trade;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;
import com.fasterxml.jackson.databind.ser.std.UUIDSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.spring.graphq.trade.TradeTransactionType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "xceler_physicaltradeservice_physicaltrade")
@Data
public class PhysicalTrade implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "uuid", updatable = false, nullable = false, columnDefinition = "BINARY(16)")
    @JsonSerialize(using= UUIDSerializer.class)
    @JsonDeserialize(using= UUIDDeserializer.class)
    public UUID uuid;


    @CreatedBy
    private String createdBy;

    @CreatedBy
    private String updatedBy;

    @CreationTimestamp
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime createdTimestamp;

    @CreationTimestamp
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime updatedTimestamp;

    private String tenantId;

    @Column
    private String tradeId;
    @Column
    private LocalDateTime tradeDateTime;
    @Column
    private TradeTransactionType tradeTransactionType;
    @Column
    private Boolean isInternalTrade;
    @Column
    private String company;
    @Column
    private String counterparty;
    @Column
    private String profitcenter;
    @Column
    private String internalProfitCenter;
    @Column
    private String companyCode;
    @Column
    private String counterpartyCode;
    @Column
    private String profitcenterCode;
    @Column
    private String internalProfitcenterCode;
    @Column
    private String traderName;
    @Column
    private String broker;
    @Column
    private String brokerReference;
    @Column
    private String externalReference;
    @Column
    private Boolean paperTrade;
    @Column
    private String commodity;
    @Column
    private String commodityCode;
    @Column
    private String origin;
    @Column
    private String brand;
    @Column
    private String grade;
    @Column
    private String season;
    @Column
    private String quantityTermsClause;
    @Column
    private String qualityTermsClause;
    @Column
    private String quantityToleranceType;
    @Column
    private String toleranceValue;
    @Column
    private String incoterm;
    @Column
    private String location;
    @Column
    private String loadLocation;
    @Column
    private String dischargeLocation;
    @Column
    private String factory;
    @Column
    private Double quantity;
    @Column
    private String quantityUom;
    @Column
    private String quantityPeriodicity;
    @Column
    private LocalDateTime deliveryStartDate;
    @Column
    private LocalDateTime deliveryEndDate;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @Column
    private LocalDateTime periodStartDate;
    @Column
    private LocalDateTime periodEndDate;
    @Column
    private String priceType;
    @Column
    private Double tradePrice;
    @Column
    private String tradePriceCurrency;
    @Column
    private String tradePriceUom;
    @Column
    private String quotationPeriodClause;
    @Column
    private String pricingTermsClause;
    @Column
    private String paymentTermsClause;
    @Column
    private String futureIndex;
    @Column
    private String futureContractMonth;
    @Column
    private Boolean isProvisionalPricing;
    @Column
    private String provisionalPriceType;
    @Column
    private Double provisionalPrice;
    @Column
    private String provisionalPriceCurrency;
    @Column
    private String provisionalPriceUom;
    @Column
    private Double percentage;
    @Column
    private String tradeSettlementCurrency;
    @Column
    private Double settlementTolerancePercentage;
    @Column
    private Double fxrate;
    @Column
    private Double provisionalFxRate;
    @Column
    private String paymentterm;
    @Column
    private String comments;
    @Column
    private String specialInstructions;
    @Column
    private String contractConfirmation;
    @Column
    private String longContract;

    @Column
    private String packageType;

    @Column
    private String externalPackage;

    @Column
    private Double externalPackageUnit;

    @Column
    private String internalPackage;

    @Column
    private Double internalPackageUnit;

    @Column
    private String locationType;

    @Column
    private  String modeOfTransport;

    @Column
    private String loadLocationType;

    @Column
    private String unloadLocationType;

    @Column
    private Double totalTradeQty;

    @Column
    private Double totalUnits;

    @Column
    private String deliveryTermsClause;

    @Column
    private String weightBasis;

    @Column
    private String manualTradeId;

    @Column
    private String tradeType;

    @Column
    private Double totalTradeValue;

    @Column
    private String contractTerm;


}
