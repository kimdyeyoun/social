package com.nagaja.admin.dto;

import com.nagaja.admin.entity.Pagination;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
@Alias("CompanyAdminDto")
public class CompanyAdminDto {

    private int companyId;
    private int pageNum;
    private int limit;

    private Pagination pagination;
    private List<CompanyAdminInfoDto> adminList;
}
