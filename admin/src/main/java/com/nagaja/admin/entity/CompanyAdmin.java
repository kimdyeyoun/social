package com.nagaja.admin.entity;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Setter
@Getter
@Alias("CompanyAdmin")
public class CompanyAdmin {

    private int companyAdminId;
    private int memId;
    private int companyId;

}
