package com.nagaja.admin.serviceImpl;//package com.nagaja.admin.serviceImpl;

import com.nagaja.admin.dto.AdminListDto;
import com.nagaja.admin.entity.Admin;
import com.nagaja.admin.entity.Pagination;
import com.nagaja.admin.mapper.AdminMapper;
import com.nagaja.admin.service.AdminService;
import com.nagaja.admin.util.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdminServiceImpl implements AdminService
{
    @Autowired
    private AdminMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //TODO 어드민 검색
    public AdminListDto selectAdminList(int pageNum, int limit)
    {

        int count = mapper.selectAdminCount();

        Pagination paging = MyUtils.Paging(count, pageNum, limit);

        List<Admin> adminList = mapper.selectAdminList();

        AdminListDto adminListDto = new AdminListDto();

        adminListDto.setAdmin(adminList);
        adminListDto.setPagination(paging);

        return adminListDto;
    }


}
