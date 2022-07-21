package com.nagaja.admin.dto;

import com.nagaja.admin.entity.Pagination;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
@Alias("PointDto")
public class PointDto {

    private String startDate;//TODO 시작날
    private String endDate;//TODO 종료날
    private int status;//TODO 충전 사용
    private int memStatusId;//TODO 유저타입
    private int pointTypeId;//TODO 포인트 타입
    private int keywordFilter;//TODO 키워드필터
    private String keyword;//TODO 키워드
    private int pageNum;
    private int limit;

    private Pagination pagination;
    private List<PointInfoDto> pointInfoList;
}
