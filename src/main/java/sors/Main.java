package sors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Main {
    public static void main(String[] args) {
        final Data data = new DataParse();
        String page = data.getData("https://minfin.com.ua/currency/banks/");
        Document document = Jsoup.parse(page);
        final Element tbody = document.getElementsByTag("tbody").first();
        final Element tr = tbody.getElementsByTag("tr").first();
        final Element elementsByClass = tr.getElementsByClass("mfcur-nbu-full-wrap").first();
        System.out.println(elementsByClass.html());
    }
}