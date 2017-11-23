package sors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.math.BigDecimal;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;

public class RatesParse implements Rates {
    @Override
    public List<Currency> getData() {
        List<Currency> currencyList = new ArrayList<>();

        String page = getData("https://minfin.com.ua/currency/banks/");
        Document document = Jsoup.parse(page);
        final Element tBody = document.getElementsByTag("tbody").first();
        for (int i = 0; i < 3; i++) {
            final Element tr = tBody.getElementsByTag("tr").get(i);
            final String course = tr.getElementsByClass("mfcur-nbu-full-wrap").first().ownText();
            final String currency = tr.getElementsByTag("a").first().ownText();
            Currency currency1 = new Currency(currency, new BigDecimal(course));
            currencyList.add(currency1);
        }
        return currencyList;
    }


    String getData(String resource) {
        final Document document = loadHtmlFromURL(resource);
        return document.html();
    }

    static Document loadHtmlFromURL(String url) {
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return doc;
    }

    static Document loadHtmlFromURL(String url, String proxyHost, int proxyPort) {
        Document doc = null;
        try {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(proxyHost, proxyPort));
            doc = Jsoup.connect(url).proxy(proxy).get();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return doc;
    }
}
