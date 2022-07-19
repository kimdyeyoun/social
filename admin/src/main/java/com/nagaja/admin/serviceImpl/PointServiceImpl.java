package com.nagaja.admin.serviceImpl;

import com.nagaja.admin.entity.PointType;
import com.nagaja.admin.mapper.PointMapper;
import com.nagaja.admin.service.PointService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
