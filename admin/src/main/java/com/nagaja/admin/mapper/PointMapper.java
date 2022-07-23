package com.nagaja.admin.mapper;

import com.nagaja.admin.dto.PointDto;
import com.nagaja.admin.dto.PointInfoDto;
import com.nagaja.admin.entity.PointType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PointMapper {

    //TODO 포인트 타입 리스트
    List<PointType> pointTypeList();

    //TODO 포인트 카운트
    int pointCount(@Param("point") PointDto dto);

    //TODO 포인트 리스트 설렉트
    List<PointInfoDto> pointInfoList(@Param("point") PointDto dto, @Param("offset") int offset, @Param("limit") int limit);

    //TODO 포인트 엑셀 다운로드 정보 설렉트
    PointInfoDto selectPointExcel(@Param("pointId") Integer pointId);

    //TODO 포인트 엑셀 다운로드 정보 All 설렉트
    List<PointInfoDto> selectPointExcelAll();

    //TODO 포인트 지급 기존 금액 설렉트
    List<PointInfoDto> selectPointMember(@Param("memId") List<Integer> pk);

    //TODO 포인트 지급
    int insertPoint(@Param("memId") int memId, @Param("pointBalance") int pointBalance, @Param("pointAmount") int pointAmount);

    //TODO 서비스 포인트 지급
    int insertServicePoint(@Param("memId") int memId, @Param("pointBalance") int pointBalance, @Param("pointService") int pointService, @Param("pointAmount") int pointAmount);

    //TODO 포인트 값 체인지
    int changePointAmount(@Param("point") List<Integer> point);

}
