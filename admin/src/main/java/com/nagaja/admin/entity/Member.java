package com.nagaja.admin.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@ToString
@Alias("Member")
public class Member {

    private int memId;
    private int memStatusId;
    private String memLoginId;
    private String memLoginPw;
    private String memName;
    private String memNickname;
    private String memEmail;
    private String memPhone;
    private String memNumber;
    private String memNation;
    private String memAddress;
    private String memAddressDetail;
    private String memAddressZipcode;
    private int mem_agree_event;
    private int memAgreeService;
    private String memEmailDate;
    private String memCreateDate;
    private String memModifyDate;

}
