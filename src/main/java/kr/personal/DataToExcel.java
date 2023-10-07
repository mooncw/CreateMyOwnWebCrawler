package kr.personal;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class DataToExcel {
    public static void export(List<CovidStatus> covidStatusList, String fileName) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("코로나 국내 발생 현황");
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,3));
        sheet.setColumnWidth(0,3000);
        sheet.setColumnWidth(1,5000);
        sheet.setColumnWidth(2,5000);
        sheet.setColumnWidth(3,3000);

        // 셀 스타일 지정
        CellStyle titleStyle = workbook.createCellStyle();
        CellStyle headerStyle = workbook.createCellStyle();
        CellStyle rowsStyle = workbook.createCellStyle();

        titleStyle.setAlignment(HorizontalAlignment.CENTER);
        titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        headerStyle.setFillBackgroundColor(IndexedColors.YELLOW.getIndex());

        rowsStyle.setAlignment(HorizontalAlignment.CENTER);
        rowsStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        // 셀 폰트 지정
        Font titleFont = workbook.createFont();
        Font headerFont = workbook.createFont();

        titleFont.setBold(true);
        titleFont.setFontHeight((short)380);
        titleStyle.setFont(titleFont);

        headerFont.setFontHeight((short)260);
        headerStyle.setFont(headerFont);

        // 제목 행 생성
        Row titleRow = sheet.createRow(0);
        titleRow.setHeight((short)600);
        String title = "국내 확진자 연령별 현황(8.31 00시 기준)";
        Cell cell = titleRow.createCell(0);
        cell.setCellValue(title);
        cell.setCellStyle(titleStyle);

        // 헤더 행 생성
        Row headerRow = sheet.createRow(1);
        headerRow.setHeight((short)400);
        String[] headers = {"구분", "확진자(%)", "사망자(%)", "치명률(%)"};
        for (int i=0; i<headers.length; i++) {
            cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }

        // 데이터 행 생성
        for (int i=0; i<covidStatusList.size(); i++) {
            CovidStatus covidStatus = covidStatusList.get(i);
            Row row = sheet.createRow(i+2);
            cell = row.createCell(0);
            cell.setCellValue(covidStatus.getCategory());
            cell.setCellStyle(rowsStyle);

            cell = row.createCell(1);
            cell.setCellValue(covidStatus.getConfirmed());
            cell.setCellStyle(rowsStyle);

            cell = row.createCell(2);
            cell.setCellValue(covidStatus.getDead());
            cell.setCellStyle(rowsStyle);

            cell = row.createCell(3);
            cell.setCellValue(covidStatus.getRate());
            cell.setCellStyle(rowsStyle);
        }

        try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
            workbook.write(fileOut);
        } finally {
            workbook.close();
        }
    }
}
