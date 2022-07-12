package com.nagaja.admin.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Setter
@Getter
@ToString
@Alias("CompanyProduct")
public class CompanyProduct {

    private int companyProductId;
    private int companyId;
    private String companyProductTitle;
    private String companyProductPeso;
    private String companyProductUsd;
    private String companyProductKrw;

}
