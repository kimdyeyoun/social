package com.nagaja.admin.service;//package com.nagaja.admin.service;

import com.nagaja.admin.dto.AdminListDto;
import com.nagaja.admin.dto.PasswordDto;
import com.nagaja.admin.entity.Admin;
import org.springframework.security.core.Authentication;

public interface AdminService {

    //TODO 어드민 검색
    AdminListDto selectAdminList(Admin admin, int pageNum, int limit);

    //TODO 어드민 상세정보 설렉트
    Admin adminDetail(int adminId);

    //TODO 어드민 등록
    int insertAdmin(Admin admin);

    //TODO 어드민 비밀번호 변경
    int changePassWord(PasswordDto password, Authentication auth);

    //TODO 어드민 델리트
    int deleteAdmin(int adminId);

}
