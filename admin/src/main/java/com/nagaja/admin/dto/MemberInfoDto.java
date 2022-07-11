package com.nagaja.admin.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@ToString
@Alias("MemberInfoDto")
public class MemberInfoDto {

    private int memId;
    private int memStatusId;
    private int nationInfoId;
    private String memReferral;
    private int memNationNum;
    private String memLoginId;
    private String memLoginPw;
    private String memName;
    private String memNickname;
    private String memEmail;
    private String memPhone;
    private String memNumber;
    private String memAddress;
    private String memAddressDetail;
    private int memAgreeEvent;
    private int memAgreeService;
    private int memMailAuth;
    private String memEmailDate;
    private String memCreateDate;
    private String memModifyDate;
    private Double memLat;
    private Double memLng;

    //TODO 추천인
    private String referral;

    private String memStatusContent;
    private String nationInfoName;
    private int nationInfoNum;
}
