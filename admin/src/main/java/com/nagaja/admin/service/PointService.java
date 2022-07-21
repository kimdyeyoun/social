package com.nagaja.admin.service;

import com.nagaja.admin.dto.PointDto;
import com.nagaja.admin.dto.PointInsDto;
import com.nagaja.admin.entity.PointType;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface PointService {

    //TODO 포인트 타입 리스트
    List<PointType> pointTypeList();

    //TODO 포인트 검색
    PointDto selectPoint(PointDto dto);

    //TODO 포인트 엑셀 다운로드
    void pointExcelDownload(HttpServletResponse response, List<Integer> pointId, int whole);

    //TODO 포인트 지급
    int insertPoint(PointInsDto pointInsDto);

    //TODO 포인트 체인지
    int changePointAmount(List<Integer> point);

}
