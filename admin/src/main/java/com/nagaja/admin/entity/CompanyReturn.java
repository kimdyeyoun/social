package com.nagaja.admin.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Setter
@Getter
@ToString
@Alias("CompanyReturn")
public class CompanyReturn {

    private int companyReturnId;
    private int companyId;
    private String companyReturnContents;
    private String companyReturnDate;

}
