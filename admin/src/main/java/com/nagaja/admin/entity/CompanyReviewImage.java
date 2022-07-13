package com.nagaja.admin.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Setter
@Getter
@ToString
@Alias("CompanyReviewImage")
public class CompanyReviewImage {

    private int companyReviewImageId;
    private int companyReviewId;
    private String companyReviewImageOrigin;
    private String companyReviewImageName;

}
