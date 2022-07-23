package com.nagaja.admin.serviceImpl;

import com.nagaja.admin.mapper.NewsMapper;
import com.nagaja.admin.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final NewsMapper newsMapper;
}
