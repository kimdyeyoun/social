package com.nagaja.admin.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Setter
@Getter
@ToString
@Alias("CategorySequenceDto")
public class CategorySequenceDto {

    private int thisListId; //TODO 선택한 리스트 PK
    private int thisListNum;//TODO 선택한 리스트 순서 값

    private int siblingListId; //TODO 선택당한 리스트 PK
    private int siblingListNum; //TODO 선택당한 리스트 순서 값

}
