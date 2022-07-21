package com.nagaja.admin.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Setter
@Getter
@ToString
@Alias("PointInsDto")
public class PointInsDto {

    private int pointAmount;
    private int pointType;
    private List<Integer> balance;
    private List<Integer> pk;
}
