package com.nagaja.admin.serviceImpl;//package com.nagaja.admin.serviceImpl;

import com.nagaja.admin.dto.AdminListDto;
import com.nagaja.admin.dto.PasswordDto;
import com.nagaja.admin.entity.Admin;
import com.nagaja.admin.entity.Pagination;
import com.nagaja.admin.mapper.AdminMapper;
import com.nagaja.admin.service.AdminService;
import com.nagaja.admin.util.MyUtils;
import com.nagaja.admin.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
    @Override
    public AdminListDto selectAdminList(Admin admin, int pageNum, int limit)
    {
        //TODO 어드민 카운트
        int count = mapper.selectAdminCount(admin);

        Pagination paging = MyUtils.Paging(count, pageNum, limit);

        //TODO 어드민 리스트
        List<Admin> adminList = mapper.selectAdminList(admin, paging.getOffset(), paging.getLimit());

        return AdminListDto.builder().admin(adminList).pagination(paging).build();
    }

    //TODO 어드민 상세정보 설렉트
    @Override
    public Admin adminDetail(int adminId)
    {
        return mapper.adminDetail(adminId);
    }

    //TODO 어드민 등록
    @Override
    public int insertAdmin(Admin admin)
    {
        int count = mapper.selectAdminCount(admin);

        String pw = passwordEncoder.encode(admin.getAdminLoginPw());
        admin.setAdminLoginPw(pw);

        if (admin.getAdminLoginId().trim().equals("") || admin.getAdminLoginPw().equals(""))
        {
            return Status.THIRD;
        }

        if (count != 0)
        {
            return Status.SECOND;
        }

        return mapper.insertAdmin(admin);
    }

    //TODO 어드민 비밀번호 변경
    @Override
    public int changePassWord(PasswordDto password, Authentication auth)
    {
        Admin admin = (Admin) auth.getPrincipal();

        Admin dbPassword = mapper.adminDetail(admin.getAdminId());

        //TODO 공백 체크
        if (password != null && !password.getCurrentPassword().trim().equals("") && !password.getVerificationPassword().trim().equals("") && !password.getChangePassword().trim().equals(""))
        {
            //TODO 현재 비밀번호 비교
            if (passwordEncoder.matches(password.getCurrentPassword(), dbPassword.getAdminLoginPw()))
            {
                //TODO 변경 비밀번호 확인비밀번호 비교
                if (password.getChangePassword().equals(password.getVerificationPassword()))
                {
                    System.out.println(password.getCurrentPassword());
                    System.out.println(password.getChangePassword());
                    System.out.println(password.getVerificationPassword());
                    Admin vo = new Admin();
                    vo.setAdminId(password.getAdminId());
                    vo.setAdminLoginPw(passwordEncoder.encode(password.getChangePassword()));

                    mapper.changePassword(vo);
                    return Status.FIRST;
                }
                else
                {
                    return Status.SECOND;
                }
            }
            else
            {
                //TODO 현재비밀번호 체크 실패
                return Status.THIRD;
            }
        }
        //TODO 비밀번호 변경 실패
        return Status.ZERO;
    }

    //TODO 어드민 델리트
    @Override
    public int deleteAdmin(int adminId)
    {
        return mapper.deleteAdmin(adminId);
    }

}
