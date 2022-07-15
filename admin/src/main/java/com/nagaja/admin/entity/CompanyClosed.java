package com.nagaja.admin.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Setter
@Getter
@ToString
@Alias("CompanyClosed")
public class CompanyClosed {

    private int companyClosedId;
    private int companyId;
    private int companyClosedMon;
    private int companyClosedTue;
    private int companyClosedWed;
    private int companyClosedThu;
    private int companyClosedFri;
    private int companyClosedSat;
    private int companyClosedSun;

}
