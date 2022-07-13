package com.nagaja.admin.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Setter
@Getter
@ToString
@Alias("CompanyName")
public class CompanyName {

    private int companyNameId;
    private int companyId;
    private String companyNameEng;
    private String companyNameKor;
    private String companyNamePhp;
    private String companyNameChn;
    private String companyNameJpn;

}
