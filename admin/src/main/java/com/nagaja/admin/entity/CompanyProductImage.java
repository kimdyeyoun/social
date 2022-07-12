package com.nagaja.admin.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Setter
@Getter
@ToString
@Alias("CompanyProductImage")
public class CompanyProductImage {

    private int companyProductImageId;
    private int companyProductId;
    private String companyProductImageOrigin;
    private String companyProductImageName;

}
