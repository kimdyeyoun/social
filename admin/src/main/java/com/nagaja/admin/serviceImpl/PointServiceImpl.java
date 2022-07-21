package com.nagaja.admin.serviceImpl;

import com.nagaja.admin.dto.CompanyInfoDto;
import com.nagaja.admin.dto.PointDto;
import com.nagaja.admin.dto.PointInfoDto;
import com.nagaja.admin.dto.PointInsDto;
import com.nagaja.admin.entity.Pagination;
import com.nagaja.admin.entity.Point;
import com.nagaja.admin.entity.PointType;
import com.nagaja.admin.mapper.PointMapper;
import com.nagaja.admin.service.PointService;
import com.nagaja.admin.util.MyUtils;
import com.nagaja.admin.util.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PointServiceImpl implements PointService {

    private final PointMapper pointMapper;

    //TODO 포인트 타입 리스트
    @Override
    public List<PointType> pointTypeList()
    {
        return pointMapper.pointTypeList();
    }

    //TODO 포인트 검색
    @Override
    public PointDto selectPoint(PointDto dto)
    {
        int count = pointMapper.pointCount(dto);

        Pagination pagination = MyUtils.Paging(count, dto.getPageNum(), dto.getLimit());

        List<PointInfoDto> pointInfoList = pointMapper.pointInfoList(dto, pagination.getOffset(), pagination.getLimit());

        return PointDto.builder().pagination(pagination).pointInfoList(pointInfoList).build();
    }

    //TODO 포인트 엑셀 다운로드
    @Override
    public void pointExcelDownload(HttpServletResponse response, List<Integer> pointId, int whole)
    {
        if (whole == 1)
        {
            MyUtils.pointExcelDownLoad(response, pointMapper.selectPointExcelAll());
        }
        //TODO 선택 엑셀 다운로드
        else
        {
            List<PointInfoDto> pointInfoList = new ArrayList<>();

            for (Integer i : pointId)
            {
                pointInfoList.add(pointMapper.selectPointExcel(i));
            }

            MyUtils.pointExcelDownLoad(response, pointInfoList);
        }
    }

    //TODO 포인트 지급
    public int insertPoint(PointInsDto pointInsDto)
    {
        int limit = pointInsDto.getPk().size();
        List<PointInfoDto> list = pointMapper.selectPointMember(pointInsDto.getPk(), limit);
        int result = 0;
        for (PointInfoDto data : list)
        {

            result = pointMapper.insertPoint(data.getMemId(), data.getPointBalance()+pointInsDto.getPointAmount(), pointInsDto.getPointAmount());
        }


        if (result == 0)
        {
            return Status.ZERO;
        }
        return  Status.FIRST;
    }

    //TODO 포인트 체인지
    @Override
    public int changePointAmount(List<Integer> point)
    {
        int result = pointMapper.changePointAmount(point);

        if (result == 0)
        {
            return Status.ZERO;
        }
        return  Status.FIRST;
    }
}
