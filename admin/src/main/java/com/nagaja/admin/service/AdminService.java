package com.nagaja.admin.service;//package com.nagaja.admin.service;

import com.nagaja.admin.dto.AdminListDto;

public interface AdminService {

    //TODO 어드민 검색
    AdminListDto selectAdminList(int pageNum, int limit);
}
