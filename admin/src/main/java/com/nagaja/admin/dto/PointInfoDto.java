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
    private int pointService;
    private int pointBalance;
    private String PointCreateDate;

    private String pointTypeContent;
    private int pointTypeAmount;
}
