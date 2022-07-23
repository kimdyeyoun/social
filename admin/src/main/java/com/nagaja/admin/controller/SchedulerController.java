package com.nagaja.admin.controller;

import com.nagaja.admin.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Slf4j
@Controller
@EnableScheduling
@RequiredArgsConstructor
public class SchedulerController {

    private final AuthService authService;

    @Scheduled(cron = "0 0 */1 * * *")
    public void runMethod()
    {
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        int result = authService.updateAuthCompany(now);

        log.info("만료 갯수 : " + result);
        log.info("예약 발송 확인 : " + now);

    }
}
