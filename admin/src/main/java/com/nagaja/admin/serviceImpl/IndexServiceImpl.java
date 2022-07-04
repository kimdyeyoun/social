package com.nagaja.admin.serviceImpl;


import com.nagaja.admin.mapper.IndexMapper;
import com.nagaja.admin.service.IndexService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IndexServiceImpl implements IndexService {

    private final IndexMapper indexMapper;

}
