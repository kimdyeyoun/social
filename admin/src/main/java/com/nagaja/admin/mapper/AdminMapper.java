package com.nagaja.admin.mapper;//package com.nagaja.admin.mapper;

import com.nagaja.admin.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface AdminMapper
{

    //TODO 어드민 카운트
    int selectAdminCount();

    //TODO 어드민 리스트 설렉트
    List<Admin> selectAdminList();
}
