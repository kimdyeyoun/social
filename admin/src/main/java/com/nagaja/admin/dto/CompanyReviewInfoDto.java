package com.nagaja.admin.dto;

import com.nagaja.admin.entity.CompanyReviewImage;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Setter
@Getter
@ToString
@Alias("CompanyReviewInfoDto")
public class CompanyReviewInfoDto {

    private int companyReviewId;
    private int memId;
    private int companyId;
    private String companyReviewContent;
    private int companyReviewStatus;
    private String companyReviewCreateDate;
    private String companyReviewModifyDate;

    private String memNickname;

    private List<CompanyReviewImage> images;

}
