package sors;

public class Main {
    public static void main(String[] args) {
        Rates rates = new RatesParse();
        System.out.println(rates.getData());
    }
}