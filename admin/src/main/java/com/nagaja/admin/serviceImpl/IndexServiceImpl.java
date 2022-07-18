package com.nagaja.admin.serviceImpl;


import com.nagaja.admin.mapper.IndexMapper;
import com.nagaja.admin.service.IndexService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Service
@RequiredArgsConstructor
public class IndexServiceImpl implements IndexService {

    private final IndexMapper indexMapper;

}
