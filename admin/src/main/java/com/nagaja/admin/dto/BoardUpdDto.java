package com.nagaja.admin.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Setter
@Getter
@ToString
@Alias("BoardUpdDto")
public class BoardUpdDto {

    private int boardStatus;
    private List<Integer> boardId;

}
