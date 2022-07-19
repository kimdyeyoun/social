package com.nagaja.admin.mapper;

import com.nagaja.admin.entity.PointType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PointMapper {

    //TODO 포인트 타입 리스트
    List<PointType> pointTypeList();
}
