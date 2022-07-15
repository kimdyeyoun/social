package com.nagaja.admin.util;

import com.nagaja.admin.dto.CompanyInfoDto;
import com.nagaja.admin.dto.MemberInfoDto;
import com.nagaja.admin.entity.Company;
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
    public static void memberExcelDownLoad(HttpServletResponse response, List<MemberInfoDto> list) {

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
            final int cellRange = 19;	// 헤더 셀 크기

            // se.shin 테이블 헤더부분
            Row headerRow = sheet.createRow(rowNo++);
            headerRow.createCell(0).setCellValue("회원상태");
            headerRow.createCell(1).setCellValue("회원번호");
            headerRow.createCell(2).setCellValue("아이디");
            headerRow.createCell(3).setCellValue("이름/닉네임");
            headerRow.createCell(4).setCellValue("이메일");
            headerRow.createCell(5).setCellValue("전화번호");
            headerRow.createCell(6).setCellValue("주소 국가");
            headerRow.createCell(7).setCellValue("주소");
            headerRow.createCell(8).setCellValue("추천인");
            headerRow.createCell(9).setCellValue("가입일자");
            headerRow.createCell(10).setCellValue("이벤트 및 혜택 알림 수신 동의");
            headerRow.createCell(11).setCellValue("예약 및 서비스 알림 수신 동의");
            headerRow.createCell(12).setCellValue("회원 정보 사용 여부");
            headerRow.createCell(13).setCellValue("이용 내역");
            headerRow.createCell(14).setCellValue("중고 판매 글 등록 수");
            headerRow.createCell(15).setCellValue("예약 현황 ");
            headerRow.createCell(16).setCellValue("구직 글 등록");
            headerRow.createCell(17).setCellValue("신고/실종 글 등록 수");
            headerRow.createCell(18).setCellValue("단골 기업 수");
            headerRow.createCell(19).setCellValue("기업 관리자 회원");



            // 헤드 스타일 적용
            for(int i=0; i<=cellRange; i++){
                headerRow.getCell(i).setCellStyle(headStyleFormat);
            }

            // dto 호출하여 데이터 가져오는 소스

            // 각각의 row 생성
            for (MemberInfoDto data : list) {
                row = sheet.createRow(rowNo++);
                if (data.getMemStatusId() == 1)
                {
                    row.createCell(0).setCellValue("일반");
                }
                else if (data.getMemStatusId() == 2)
                {
                    row.createCell(0).setCellValue("탈퇴");
                }
                else if (data.getMemStatusId() == 3)
                {
                    row.createCell(0).setCellValue("블랙");
                }
                else if (data.getMemStatusId() == 7)
                {
                    row.createCell(0).setCellValue("기업관리자");
                }
                row.createCell(1).setCellValue(data.getMemNumber());
                row.createCell(2).setCellValue(data.getMemLoginId());
                row.createCell(3).setCellValue(data.getMemName() + "/" + data.getMemNickname());
                row.createCell(4).setCellValue(data.getMemEmail());
                row.createCell(5).setCellValue(data.getMemPhone());
                row.createCell(6).setCellValue(data.getNationInfoName());
                row.createCell(7).setCellValue(data.getMemAddress() + " "  + data.getMemAddressDetail());
                row.createCell(8).setCellValue(data.getMemReferral());
                row.createCell(9).setCellValue(data.getMemCreateDate());
                if (data.getMemAgreeEvent() == 0)
                {
                    row.createCell(10).setCellValue("N");
                }
                else
                {
                    row.createCell(10).setCellValue("Y");
                }

                if (data.getMemAgreeService() == 0)
                {
                    row.createCell(11).setCellValue("N");
                }
                else
                {
                    row.createCell(11).setCellValue("Y");
                }

                if (data.getMemStatusId() == 1 || data.getMemStatusId() == 4 || data.getMemStatusId() == 8)
                {
                    row.createCell(12).setCellValue("Y");
                }
                else
                {
                    row.createCell(12).setCellValue("N");
                }

                row.createCell(13).setCellValue("10건");
                row.createCell(14).setCellValue("1건");
                row.createCell(15).setCellValue("1건");
                row.createCell(16).setCellValue("1건");
                row.createCell(17).setCellValue("22건");
                row.createCell(18).setCellValue("1건");


                if (data.getMemStatusId() == 7)
                {
                    row.createCell(19).setCellValue("Y");
                }
                else
                {
                    row.createCell(19).setCellValue("N");
                }
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

    //TODO 엑셀 다운로드
    public static void companyExcelDownLoad(HttpServletResponse response, List<CompanyInfoDto> list) {

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
            final int cellRange = 29;	// 헤더 셀 크기

            // se.shin 테이블 헤더부분
            Row headerRow = sheet.createRow(rowNo++);
            headerRow.createCell(0).setCellValue("공공기관 등록 여부");
            headerRow.createCell(1).setCellValue("신청상태");
            headerRow.createCell(2).setCellValue("카테고리");
            headerRow.createCell(3).setCellValue("업체명");
            headerRow.createCell(4).setCellValue("주소 국가");
            headerRow.createCell(5).setCellValue("주소");
            headerRow.createCell(6).setCellValue("휴무일");
            headerRow.createCell(7).setCellValue("위도/경도");
            headerRow.createCell(8).setCellValue("전화번호");
            headerRow.createCell(9).setCellValue("기업 회원 등록 일자");
            headerRow.createCell(10).setCellValue("인증마크");
            headerRow.createCell(11).setCellValue("단골 수");
            headerRow.createCell(12).setCellValue("기업 설명");
            headerRow.createCell(13).setCellValue("영업시간");
            headerRow.createCell(14).setCellValue("브레이크 타임");
            headerRow.createCell(15).setCellValue("배달 가능 여부");
            headerRow.createCell(16).setCellValue("예약 가능 여부");
            headerRow.createCell(17).setCellValue("픽업/드랍 여부");
            headerRow.createCell(18).setCellValue("결제수단");
            headerRow.createCell(19).setCellValue("주차가능 여부");
            headerRow.createCell(20).setCellValue("반려동물 동반 가능 여부");
            headerRow.createCell(21).setCellValue("구인 글 등록");
            headerRow.createCell(22).setCellValue("기업 관리자 회원");
            headerRow.createCell(23).setCellValue("신고 수");
            headerRow.createCell(24).setCellValue("기업 담당자 이름");
            headerRow.createCell(25).setCellValue("기업 담당자 전화번호");
            headerRow.createCell(26).setCellValue("기업 담당자 메일주소");
            headerRow.createCell(27).setCellValue("기업 담당자 페이스북");
            headerRow.createCell(28).setCellValue("기업 담당자 카카오");
            headerRow.createCell(29).setCellValue("기업 담당자 라인");


            // 헤드 스타일 적용
            for(int i=0; i<=cellRange; i++){
                headerRow.getCell(i).setCellStyle(headStyleFormat);
            }

            // dto 호출하여 데이터 가져오는 소스

            // 각각의 row 생성
            for (CompanyInfoDto data : list) {
                row = sheet.createRow(rowNo++);
                if (data.getCompanyPublic() == 1)
                {
                    row.createCell(0).setCellValue("Y");
                }
                else
                {
                    row.createCell(0).setCellValue("N");
                }

                if (data.getCompanyStatus() == 1)
                {
                    row.createCell(1).setCellValue("신청완료");
                }
                else if (data.getCompanyStatus() == 2)
                {
                    row.createCell(1).setCellValue("등록완료");
                }
                else if (data.getCompanyStatus() == 3)
                {
                    row.createCell(1).setCellValue("반려");
                }

                row.createCell(2).setCellValue(data.getBoardCategoryTitle());
                row.createCell(3).setCellValue(data.getCompanyNameEng() + "/" + data.getCompanyNameKor() + "/" + data.getCompanyNamePhp() + "/" + data.getCompanyNameChn() + "/" + data.getCompanyNameJpn());
                row.createCell(4).setCellValue(data.getNationInfoName());
                row.createCell(5).setCellValue("주소");
                StringBuilder stringBuilder = new StringBuilder();

                if (data.getCompanyClosedMon() == 1)
                {
                    stringBuilder.append("월,");
                }
                if (data.getCompanyClosedThu() == 1)
                {
                    stringBuilder.append("화,");
                }
                if (data.getCompanyClosedWed() == 1)
                {
                    stringBuilder.append("수,");
                }
                if (data.getCompanyClosedThu() == 1)
                {
                    stringBuilder.append("목,");
                }
                if (data.getCompanyClosedFri() == 1)
                {
                    stringBuilder.append("금,");
                }
                if (data.getCompanyClosedSat() == 1)
                {
                    stringBuilder.append("토,");
                }
                if (data.getCompanyClosedSun() == 1)
                {
                    stringBuilder.append("일,");
                }

                if (stringBuilder.length() != 0)
                {
                    row.createCell(6).setCellValue(stringBuilder.substring(0, stringBuilder.toString().length()-1));
                }
                else
                {
                    row.createCell(6).setCellValue(stringBuilder.toString());
                }

                row.createCell(7).setCellValue(data.getCompanyLat() + "/" + data.getCompanyLng());
                row.createCell(8).setCellValue(data.getCompanyPhone());
                row.createCell(9).setCellValue(data.getCompanyApprovalDate());
                if (data.getCompanyAuth() == 0)
                {
                    row.createCell(10).setCellValue("N");
                }
                else
                {
                    row.createCell(10).setCellValue("Y");
                }
                row.createCell(11).setCellValue(data.getRegularPeople());
                row.createCell(12).setCellValue(data.getCompanyText());
                row.createCell(13).setCellValue(data.getCompanyLiveTime());
                row.createCell(14).setCellValue(data.getCompanyBreakTime());
                if (data.getCompanyDelivery() == 0)
                {
                    row.createCell(15).setCellValue("N");
                }
                else
                {
                    row.createCell(15).setCellValue("Y");
                }

                if (data.getCompanyReservation() == 0)
                {
                    row.createCell(16).setCellValue("N");
                }
                else
                {
                    row.createCell(16).setCellValue("Y" + "(" + data.getCompanyReservationTime() + ")");
                }

                if (data.getCompanyPickup() == 0)
                {
                    row.createCell(17).setCellValue("N");
                }
                else
                {
                    row.createCell(17).setCellValue("Y");
                }

                row.createCell(18).setCellValue(data.getCompanyPayType());

                if (data.getCompanyParking() == 0)
                {
                    row.createCell(19).setCellValue("N");
                }
                else
                {
                    row.createCell(19).setCellValue("Y");
                }

                if (data.getCompanyPet() == 0)
                {
                    row.createCell(20).setCellValue("N");
                }
                else
                {
                    row.createCell(20).setCellValue("Y");
                }

                row.createCell(21).setCellValue("1건");
                row.createCell(22).setCellValue("1명");
                row.createCell(23).setCellValue("1건");

                row.createCell(24).setCellValue(data.getCompanyMasterName());
                row.createCell(25).setCellValue(data.getCompanyMasterPhone());
                row.createCell(26).setCellValue(data.getCompanyMasterEmail());
                row.createCell(27).setCellValue(data.getCompanyMasterFacebook());
                row.createCell(28).setCellValue(data.getCompanyMasterKakao());
                row.createCell(29).setCellValue(data.getCompanyMasterLine());

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
