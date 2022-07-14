package com.nagaja.admin.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Setter
@Getter
@ToString
@Alias("CompanyReturnDto")
public class CompanyReturnDto {

    private int companyReturnId;
    private int companyId;
    private String companyReturnContents;
    private String companyReturnDate;

}
