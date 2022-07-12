package com.nagaja.admin.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@ToString
@Alias("CompanyMaster")
public class CompanyMaster {

    private int companyMasterId;
    private int companyId;
    private String companyMasterName;
    private String companyMasterPhone;
    private String companyMasterEmail;
    private String companyMasterFacebook;
    private String companyMasterKakao;
    private String companyMasterLine;

}
