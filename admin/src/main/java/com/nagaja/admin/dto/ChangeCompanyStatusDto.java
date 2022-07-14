package com.nagaja.admin.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Getter
@Setter
@ToString
@Alias("ChangeCompanyStatusDto")
public class ChangeCompanyStatusDto {

    private List<Integer> memId;

}
