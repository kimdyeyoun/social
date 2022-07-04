package com.nagaja.admin.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@ToString
@Alias("Pagination")
public class Pagination
{
    private int count;
    private int pageNum;
    private int startPage;
    private int endPage;
    private int maxPage;
    private int offset;
    private int limit;
}