package com.nagaja.admin.dto;

import com.nagaja.admin.entity.CompanyImage;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Getter
@Setter
@ToString
@Alias("CompanyInfoDto")
public class CompanyInfoDto {

    private int companyId;
    private int memId;
    private int boardCategoryId;
    private String companyName;
    private String companyAddress;
    private String companyPhone;
    private String companyLiveTime;
    private String companyBreakTime;
    private String companyReservationTime;
    private String companyReservationPerson;
    private String companyPayType;
    private String companyLicense;
    private String companyLicenseOrigin;
    private String companyText;
    private int companyAuth;
    private int companyDelivery;
    private int companyReservation;
    private int companyPickup;
    private int companyParking;
    private int companyPet;
    private int companyStatus;
    private int companyPublic;
    private int companyManageMax;
    private Double companyLat;
    private Double companyLon;
    private String companyApplicationDate;
    private String companyApprovalDate;

    //TODO 단골 수
    private int regularPeople;
    //TODO 기업 관리자 회원 수
    private int adminPeople;

    private int memStatusId;
    private int nationInfoId;
    private String memStatusContent;
    private String boardCategoryTitle;
    private String nationInfoName;
    private String memLoginId;

    //TODO 기업 관련 이미지
    private List<CompanyImage> images;

}
