package com.nagaja.admin.dto;

import com.nagaja.admin.entity.BoardImage;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Setter
@Getter
@ToString
@Alias("MarketBoardInfoDto")
public class MarketBoardInfoDto {

    private int boardId;
    private int memId;
    private int boardCategoryId;
    private int boardCategoryParent;
    private String boardTitle;
    private String boardContent;
    private int boardViewCount;
    private int boardStatus;
    private String boardCreateDate;
    private String boardModifyDate;

    private int usedMarketId;
    private String usedMarketPrice;
    private int usedMarketPriceType;
    private int usedMarketStatus;
    private String usedMarketComplete;
    private int liftCount;
    private String liftDate;
    private int areaId;

    private String boardCategoryTitle;
    private String memName;
    private String memLoginId;
    private String memAddress;
    //TODO 대표이미지
    private String boardImageName;

    private List<BoardImage> images;
}
