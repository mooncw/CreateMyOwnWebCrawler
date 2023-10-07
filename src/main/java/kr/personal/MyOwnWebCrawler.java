package kr.personal;

import java.io.IOException;

public class MyOwnWebCrawler {
    public static void main(String[] args) throws IOException {
        DataToExcel.export(MyJsoup.getCovidStatusList(), "MyCovidExcel.xlsx");
        System.out.println("엑셀로 저장 완료");
    }
}
