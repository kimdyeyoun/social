package com.nagaja.admin.dto;

import com.nagaja.admin.entity.Admin;
import com.nagaja.admin.entity.Pagination;
import lombok.*;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Builder
@Getter
@Setter
@ToString
@Alias("AdminListDto")
public class AdminListDto {

    private List<Admin> admin;
    private Pagination pagination;
}
