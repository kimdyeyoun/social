package com.nagaja.admin.dto;

import com.nagaja.admin.entity.CompanyReviewImage;
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
@Alias("CompanyReviewDto")
public class CompanyReviewDto {

    private int companyId;
    private int pageNum;
    private int limit;

    private Pagination pagination;

    //TODO 기업 리뷰 정보
    private List<CompanyReviewInfoDto> reviews;
}
