package com.nagaja.admin.dto;

import com.nagaja.admin.entity.Pagination;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Setter
@Getter
@ToString
@Builder
@Alias("MarketBoardDto")
public class MarketBoardDto {

    private String startDate;//TODO 시작날
    private String endDate;//TODO 종료날
    private int boardCategoryId;//TODO 카테고리 값
    private int usedMarketStatus;// TODO 중고마켓 상태
    private int keywordFilter;//TODO 키워드필터
    private String keyword;//TODO 키워드
    private int marketCount;//TODO 마켓 카운트
    private int pageNum;
    private int limit;

    private Pagination pagination;
    private List<MarketBoardInfoDto> boardInfoList;

}
