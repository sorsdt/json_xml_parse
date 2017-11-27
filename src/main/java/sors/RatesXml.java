package sors;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RatesXml implements Rates {
    @Override
    public List<Currency> getData() {
/*        String xmlString = "<exchange>\n" +
                "<currency>\n" +
                "<r030>985</r030>\n" +
                "<txt>Злотий</txt>\n" +
                "<rate>7.591094</rate>\n" +
                "<cc>PLN</cc>\n" +
                "<exchangedate>27.11.2017</exchangedate>\n" +
                "</currency>\n" +
                "<currency>\n" +
                "<r030>986</r030>\n" +
                "<txt>Бразильський реал</txt>\n" +
                "<rate>8.214093</rate>\n" +
                "<cc>BRL</cc>\n" +
                "<exchangedate>27.11.2017</exchangedate>\n" +
                "</currency>\n" +
                "<currency>\n" +
                "</exchange>";*/
        List<Currency> currencyList = new ArrayList<>();
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse("http://bank.gov.ua/NBUStatService/v1/statdirectory/exchange");
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("currency");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String txt = eElement.getElementsByTagName("txt").item(0).getTextContent();
                    if (isOurCurrency(txt)) {
                        String rate = eElement.getElementsByTagName("rate").item(0).getTextContent();
                        Currency currency = new Currency(txt, new BigDecimal(rate));
                        currencyList.add(currency);
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return currencyList;
    }
}
