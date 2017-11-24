package sors;

public class Main {
    public static void main(String[] args) {
        Rates json = new RatesJson();
        Rates parse = new RatesParse();
        Rates xml = new RatesXml();
        System.out.println(json.getData());
        System.out.println(parse.getData());
        System.out.println(xml.getData());
    }
}