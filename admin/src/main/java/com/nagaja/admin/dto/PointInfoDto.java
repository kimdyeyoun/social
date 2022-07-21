package com.nagaja.admin.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Setter
@Getter
@ToString
@Alias("PointInfoDto")
public class PointInfoDto {

    private int pointId;
    private int memId;
    private int pointTypeId;
    private int pointAmount;
    private int pointService;
    private int pointBalance;
    private String pointCreateDate;

    private String pointTypeContent;
    private int pointTypeAmount;

    private int memStatusId;
    private String memLoginId;
    private String memName;

    private int companyNameId;
    private int companyId;
    private String companyNameEng;
    private String companyNameKor;
    private String companyNamePhp;
    private String companyNameChn;
    private String companyNameJpn;

    private String companyPhone;
    private String memPhone;
    private String memCreateDate;
}
