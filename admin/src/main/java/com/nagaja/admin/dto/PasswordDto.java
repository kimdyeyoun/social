package com.nagaja.admin.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@ToString
@Alias("PasswordDto")
public class PasswordDto {

    private int AdminId;

    //TODO 현재 ADMIN 패스워드와 비교할 수 있는 패스워드
    private String currentPassword;
    //TODO 변경될 패스워드
    private String changePassword;
    //TODO 변경될 패스워드와 비교 할 수 있는 패스워드
    private String verificationPassword;
}
