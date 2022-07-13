package com.nagaja.admin.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@ToString
@Alias("CompanyAdminInfoDto")
public class CompanyAdminInfoDto {

    private int companyAdminId;
    private int memId;
    private int companyId;

    private String memNumber;
    private String memLoginId;
    private String memNickname;
    private String memPhone;

}
