package com.nagaja.admin.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Setter
@Getter
@ToString
@Alias("Point")
public class Point {

    private int pointId;
    private int memId;
    private int pointTypeId;
    private int pointService;
    private int pointBalance;
    private String PointCreateDate;
}
