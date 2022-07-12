package com.nagaja.admin.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Setter
@Getter
@ToString
@Alias("RegularInfoDto")
public class RegularInfoDto {

    private int memId;
    private int companyId;
    private int nationInfoId;//TODO 유저 국가
    private int keywordFilter;//TODO 키워드필터
    private String keyword;//TODO 키워드
    private int pageNum;
    private int limit;
}
