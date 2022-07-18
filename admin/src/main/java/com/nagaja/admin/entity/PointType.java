package com.nagaja.admin.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Setter
@Getter
@ToString
@Alias("PointType")
public class PointType {

    private int pointTypeId;
    private String pointTypeContent;
    private int pointTypeAmount;

}
