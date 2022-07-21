package com.nagaja.admin.mapper;

import com.nagaja.admin.dto.PointDto;
import com.nagaja.admin.entity.PointType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PointMapper {

    //TODO 포인트 타입 리스트
    List<PointType> pointTypeList();

    //TODO 포인트 값 체인지
    int changePointAmount(@Param("point") List<Integer> point);

    //TODO 포인트 카운트
    int pointCount(@Param("point") PointDto dto);
}
