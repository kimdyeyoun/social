package com.nagaja.admin.util;

import com.nagaja.admin.dto.MemberInfoDto;
import com.nagaja.admin.entity.Pagination;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;


import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

public class MyUtils {


    public static Pagination Paging(int count, int pageNum, int limit)
    {

        int offset = (pageNum - 1) * limit;
        int start_page = ((pageNum - 1) / 10) * 10 + 1;
        int max_page = (count + limit - 1) / limit;

        Pagination page = new Pagination();
        page.setCount(count);
        page.setPageNum(pageNum);
        page.setStartPage(start_page);
        page.setEndPage(start_page + 9);
        page.setMaxPage(max_page);
        page.setOffset(offset);
        page.setLimit(limit);

        return page;
    }

    //TODO 엑셀 다운로드
    public static void letExcelDownLoad(HttpServletResponse response, List<MemberInfoDto> list) {

        FileOutputStream fos = null;
        SXSSFWorkbook workbook = null;
        SXSSFRow row = null;				// 행
        //SXSSFCell cell = null;			// 셀
        CellStyle headStyleFormat = null;	// 샐 스타일


        try {

            // 워크북 생성(엑셀 파일)
            workbook = new SXSSFWorkbook();
            workbook.setCompressTempFiles(true);

            // Sheet 생성
            SXSSFSheet sheet = (SXSSFSheet) workbook.createSheet("유저통계");
            sheet.setRandomAccessWindowSize(100); // 메모리 행 100개로 제한, 초과 시 Disk로 flush


            // 헤더 스타일 지정
            headStyleFormat = workbook.createCellStyle();
            headStyleFormat.setFillForegroundColor(HSSFColor.HSSFColorPredefined.GREY_25_PERCENT.getIndex());
            headStyleFormat.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            headStyleFormat.setAlignment(HorizontalAlignment.CENTER);  // 가운데 정렬

            // 헤더 폰트 지정
            Font font = workbook.createFont();
            font.setFontHeightInPoints((short) 11);
            font.setBold(true); // 굵기

            headStyleFormat.setFont(font);

            //... 엑셀 내용 작성 ...
            int rowNo = 0;	// row number 카운팅 변수
            final int cellRange = 9;	// 헤더 셀 크기

            // se.shin 테이블 헤더부분
            Row headerRow = sheet.createRow(rowNo++);
            headerRow.createCell(0).setCellValue("번호");
            headerRow.createCell(1).setCellValue("회원상태");
            headerRow.createCell(2).setCellValue("회원번호");
            headerRow.createCell(3).setCellValue("아이디");
            headerRow.createCell(4).setCellValue("이메일");
            headerRow.createCell(5).setCellValue("이름/닉네임");
            headerRow.createCell(6).setCellValue("전화번호");
            headerRow.createCell(7).setCellValue("주소 국가");
            headerRow.createCell(8).setCellValue("주소");
            headerRow.createCell(9).setCellValue("가입일자");


            // 헤드 스타일 적용
            for(int i=0; i<=cellRange; i++){
                headerRow.getCell(i).setCellStyle(headStyleFormat);
            }

            // dto 호출하여 데이터 가져오는 소스

            // 각각의 row 생성
            for (MemberInfoDto data : list) {
                row = sheet.createRow(rowNo++);
                row.createCell(0).setCellValue(data.getMemId());
                if (data.getMemStatusId() == 1)
                {
                    row.createCell(1).setCellValue("일반");
                }
                else if (data.getMemStatusId() == 2)
                {
                    row.createCell(1).setCellValue("탈퇴");
                }
                else if (data.getMemStatusId() == 3)
                {
                    row.createCell(1).setCellValue("블랙");
                }
                row.createCell(2).setCellValue(data.getMemNumber());
                row.createCell(3).setCellValue(data.getMemLoginId());
                row.createCell(4).setCellValue(data.getMemEmail());
                row.createCell(5).setCellValue(data.getMemName() + "/" + data.getMemNickname());
                row.createCell(6).setCellValue(data.getMemPhone());
                row.createCell(7).setCellValue(data.getNationInfoName());
                row.createCell(8).setCellValue(data.getMemAddress() + " "  + data.getMemAddressDetail());
                row.createCell(9).setCellValue(data.getMemCreateDate());
            }

            // se.shin 엑세파일명
            String filename = "유저통계";

            response.reset();

            response.setContentType( "application/vnd.ms-excel" );
            //response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.addHeader("Content-Disposition","attachment;filename=\"" + URLEncoder.encode(filename, "UTF-8") + ".xlsx\"");

            workbook.write(response.getOutputStream());
            response.getOutputStream().flush();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //response.getOutputStream().close();
                workbook.close();
                workbook.dispose();
                if(fos != null) try { fos.close(); } catch(Exception ignore) {}
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
