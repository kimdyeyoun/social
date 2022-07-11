package com.nagaja.admin.controller;

import com.nagaja.admin.util.AWSUploader;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/file")
public class FileController {

    private final AWSUploader AWSUploader;

    @GetMapping("/download")
    public ResponseEntity<byte[]> download(@RequestParam(value = "companyLicense") String companyLicense) throws IOException {
        System.out.println(companyLicense);
        String[] imageName = companyLicense.split("/");
        String path = imageName[0] + "/" + imageName[1];
        return AWSUploader.getObject(path, imageName[2]);
    }

}
