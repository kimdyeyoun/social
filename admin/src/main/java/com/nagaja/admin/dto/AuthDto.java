package com.nagaja.admin.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Getter
@Setter
@ToString
@Alias("AuthDto")
public class AuthDto {

    private String startDate;
    private String endDate;
    private List<Integer> pk;
}
