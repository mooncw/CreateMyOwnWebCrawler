package kr.personal;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfEncodings;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.util.List;

public class DataToPDF {
    public static void export(List<CovidStatus> covidStatusList, String fileName) throws FileNotFoundException {
        /*try {
            String fontPath = "C:/windows/Fonts/malgun.ttf";
            BaseFont baseFont = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, true);
            Font font = new Font(baseFont, 12);

            PdfDocument pdfDocument = new PdfDocument(new PdfWriter(fileName));
            Document document = new Document(pdfDocument);

            // 제목 추가
            Paragraph title = new Paragraph("국내 확진자 연령별 현황(8.31 00시 기준)");
            document.add(title.setFont(font));

            float[] columnWidths = {100, 50, 50, 50};
            Table table = new Table(UnitValue.createPercentArray(columnWidths));
            String[] headers = {"구분", "확진자(%)", "사망자(%)", "치명률(%)"};

            // 헤더 설정
            for (String header : headers) {
                Cell cell = new Cell();

                table.addCell(new Paragraph(header).setFont(font));
            }
        }*/
    }
}
