package kr.personal;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyJsoup {
    private static final String MAIN_URL="https://ncov.kdca.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=11&ncvContSeq=&contSeq=&board_id=&gubun=";
    private Document document;

    public MyJsoup() throws IOException {
        this(MAIN_URL);
    }

    public MyJsoup(String url) throws IOException {
        this.document = Jsoup.connect(url).get();
    }

    public static List<CovidStatus> getCovidStatusList() throws IOException {
        Document document = new MyJsoup().document;

        List<CovidStatus> covidStatusList = new ArrayList<>();

        Element table = document.select("table.num").last();

        Elements tbodyData = table.select("tbody>tr");

        for (Element row : tbodyData) {
            String category = row.select("th").text();
            String confirmed = row.select("td:nth-child(2)").text();
            String dead = row.select("td:nth-child(3)").text();
            String rate = row.select("td:nth-child(4)").text();

            covidStatusList.add(new CovidStatus(category, confirmed, dead, rate));
        }

        return covidStatusList;
    }
}
