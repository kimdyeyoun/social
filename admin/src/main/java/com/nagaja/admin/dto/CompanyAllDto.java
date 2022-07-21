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
@Builder
@ToString
@Alias("CompanyAllDto")
public class CompanyAllDto {

    private int keywordFilter;//TODO 키워드필터
    private String keyword;//TODO 키워드
    private int pageNum;
    private int limit;

    private Pagination pagination;
    private List<CompanyInfoDto> companyInfoList;

}
