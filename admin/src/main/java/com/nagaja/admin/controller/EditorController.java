package com.nagaja.admin.controller;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.nagaja.admin.util.AWSUploader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/editor")
public class EditorController
{
    @Autowired
    private AWSUploader AWSUploader;

    @Value("${aws.s3_url}")
    String AWSURL;

    // 에디터 파일 드래그해서 업로드하기
    @ResponseBody
    @RequestMapping(value="/drag", produces=MediaType.APPLICATION_JSON_VALUE)
    public Object handleFileUpload(@RequestParam("upload") MultipartFile[] uploadfile, @RequestParam("path") String path)
    {
        HashMap<String, Object> map = new HashMap<>();

        try
        {
            for(int i = 0; i < uploadfile.length; i++)
            {
                String awsName = AWSUploader.changeFileName(uploadfile[i]);

                boolean uploadAWS = AWSUploader.uploadToWithNameAwsS3(path, uploadfile[i], awsName);

                map.put("uploaded", 1);
                map.put("url", AWSURL + path + "/" + awsName);
                map.put("fileName", uploadfile[i].getOriginalFilename());
            }

            return map;
        }
        catch (Exception e)
        {
            map.put("uploaded", 0);
            map.put("error", "{'message': '" + e.getMessage() + "'}");

            return map;
        }
    }

    // 에디터 일반 사진 업로드
    @ResponseBody
    @RequestMapping(value="/basic", produces=MediaType.APPLICATION_JSON_VALUE)
    public void handleFileBasicUpload(HttpServletRequest request, HttpServletResponse response, @RequestParam("upload") MultipartFile[] uploadfile, @RequestParam("path") String path)
    {
        OutputStream out = null;

        PrintWriter pw = null;

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        try
        {
            for(int i = 0; i < uploadfile.length; i++)
            {
                String callback = request.getParameter("CKEditorFuncNum");

                String awsName = AWSUploader.changeFileName(uploadfile[i]);

                boolean uploadAWS = AWSUploader.uploadToWithNameAwsS3(path, uploadfile[i], awsName);

                pw = response.getWriter();
                pw.println("<script type='text/javascript'>window.parent.CKEDITOR.tools.callFunction(" + callback + ", '" + AWSURL + path + "/" + awsName + "', '이미지를 업로드 하였습니다.'" + ")</script>");
                pw.flush();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
