package com.nagaja.admin.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@ToString
@Alias("CompanyImage")
public class CompanyImage {

    private int companyImageId;
    private int companyId;
    private String companyImageOrigin;
    private String companyImageName;

}
