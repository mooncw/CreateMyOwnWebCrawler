package kr.personal.controller;

import kr.personal.view.DataToExcel;
import kr.personal.view.DataToPDF;

public class MyOwnWebCrawler {
    public static void main(String[] args) {
        try {
            DataToExcel.export(MyJsoup.getCovidStatusList(), "MyCovidExcel.xlsx");
            System.out.println("엑셀로 저장 성공.");
        } catch (Exception e) {
            System.out.println("엑셀로 저장 실패!!!");
            e.printStackTrace();
        }
        try {
            DataToPDF.export(MyJsoup.getCovidStatusList(), "MyCovidPdf.pdf");
            System.out.println("PDF로 저장 성공.");
        } catch (Exception e) {
            System.out.println("PDF로 저장 실패!!!");
            e.printStackTrace();
        }
    }
}
