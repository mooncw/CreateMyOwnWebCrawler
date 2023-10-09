package kr.personal.view;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.*;
import kr.personal.model.CovidStatus;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class DataToPDF {
    public static void export(List<CovidStatus> covidStatusList, String fileName) throws Exception {
        Document document = new Document(PageSize.A4);

        try {
            PdfWriter.getInstance(document, new FileOutputStream(new File(fileName)));
            document.open();

            // 폰트 설정
            BaseFont baseFont = BaseFont.createFont("malgun.ttf", BaseFont.IDENTITY_H, true);
            Font titleFont = new Font(baseFont, 20, Font.BOLD);
            Font headerFont = new Font(baseFont, 12);
            Font rowsFont = new Font(baseFont, 10);

            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);

            float[] columnWidths = {50, 50, 50, 50};
            table.setWidths(columnWidths);

            // 제목 생성
            Paragraph title = new Paragraph("국내 확진자 연령별 현황(8.31 00시 기준)",titleFont);
            title.setAlignment(1);
            document.add(title);
            document.add(new Paragraph("\r\n"));

            // 헤더 생성
            String[] headers = {"구분", "확진자(%)", "사망자(%)", "치명률(%)"};
            for (String header : headers) {
                PdfPCell cell = new PdfPCell();
                cell.setPhrase(new Phrase(header, headerFont));
                cell.setBackgroundColor(BaseColor.GRAY);
                table.addCell(cell);
            }
            table.completeRow();

            // 데이터 행 생성
            for (CovidStatus covidStatus : covidStatusList) {
                PdfPCell cell = new PdfPCell();
                cell.setPhrase(new Phrase(covidStatus.getCategory(), rowsFont));
                table.addCell(cell);
                cell.setPhrase(new Phrase(covidStatus.getConfirmed(), rowsFont));
                table.addCell(cell);
                cell.setPhrase(new Phrase(covidStatus.getDead(), rowsFont));
                table.addCell(cell);
                cell.setPhrase(new Phrase(covidStatus.getRate(), rowsFont));
                table.addCell(cell);
                table.completeRow();
            }
            document.add(table);
        } finally {
            document.close();
        }
    }
}
