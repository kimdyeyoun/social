package com.nagaja.admin.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Setter
@Getter
@ToString
@Alias("UsedMarket")
public class UsedMarket {

    private int usedMarketId;
    private int boardId;
    private String usedMarketPrice;
    private int usedMarketPriceType;
    private int usedMarketStatus;
    private int usedMarketComplete;
    private int liftCount;
    private int liftDate;
    private int areaId;

}
