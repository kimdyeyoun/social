package com.nagaja.admin.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Setter
@Getter
@ToString
@Alias("CompanyReview")
public class CompanyReview {

    private int companyReviewId;
    private int memId;
    private int companyId;
    private String companyReviewContent;
    private int companyReviewStatus;
    private String companyReviewCreateDate;
    private String companyReviewModifyDate;

}
