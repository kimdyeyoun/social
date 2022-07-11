package com.nagaja.admin.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@ToString
@Alias("Company")
public class Company {

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

}
