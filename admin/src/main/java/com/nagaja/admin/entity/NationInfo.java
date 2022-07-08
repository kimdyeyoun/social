package com.nagaja.admin.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Setter
@Getter
@ToString
@Alias("NationInfo")
public class NationInfo {

    private int nationInfoId;
    private String nationInfoName;
    private int nationInfoNum;
}
