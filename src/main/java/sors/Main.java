package sors;

public class Main {
    public static void main(String[] args) {
        Rates json = new RatesJson();
        Rates xml = new RatesXml();
        Rates parse = new RatesParse();
        System.out.println(json.getData());
        System.out.println(xml.getData());
        System.out.println(parse.getData());
    }
}