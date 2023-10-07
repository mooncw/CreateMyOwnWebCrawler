package kr.personal;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class DataToExcel {
    public static void export(List<CovidStatus> covidStatusList, String fileName) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("코로나 국내 발생 현황");

        // 헤더 행 생성
        Row headerRow = sheet.createRow(0);
        String[] headers = {"구분", "확진자(%)", "사망자(%)", "치명률(%)"};
        for (int i=0; i<headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        // 데이터 행 생성
        for (int i=0; i<covidStatusList.size(); i++) {
            CovidStatus covidStatus = covidStatusList.get(i);
            Row row = sheet.createRow(i+1);
            row.createCell(0).setCellValue(covidStatus.getCategory());
            row.createCell(1).setCellValue(covidStatus.getConfirmed());
            row.createCell(2).setCellValue(covidStatus.getDead());
            row.createCell(3).setCellValue(covidStatus.getRate());
        }

        try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
            workbook.write(fileOut);
        } finally {
            workbook.close();
        }
    }
}
