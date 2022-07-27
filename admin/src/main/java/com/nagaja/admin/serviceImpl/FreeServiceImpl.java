package com.nagaja.admin.serviceImpl;

import com.nagaja.admin.mapper.FreeMapper;
import com.nagaja.admin.service.FreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@RequiredArgsConstructor
public class FreeServiceImpl implements FreeService {

    private final FreeMapper freeMapper;

}
