package sors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.net.InetSocketAddress;
import java.net.Proxy;

public class DataParse implements Data {
    @Override
    public String getData(String resource) {
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
