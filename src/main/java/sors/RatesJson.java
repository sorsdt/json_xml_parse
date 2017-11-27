package sors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RatesJson implements Rates {
    @Override
    public List<Currency> getData() {
/*        String jsonString = "[{\"r030\":985,\"txt\":\"Злотий\",\"rate\":7.555179,\"cc\":\"PLN\",\"exchangedate\":\"24.11.2017\"}" +
                ",{\"r030\":986,\"txt\":\"Бразильський реал\",\"rate\":8.214093,\"cc\":\"BRL\",\"exchangedate\":\"24.11.2017\"}]";*/
        InputStream input = null;
        try {
            input = new URL("http://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json").openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Reader jsonString = null;
        try {
            jsonString = new InputStreamReader(input, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Currency[] currencies = gson.fromJson(jsonString, Currency[].class);
        List<Currency> currencyList = new ArrayList<>();
        for (Currency currency : currencies) {
            if (isOurCurrency(currency.getTxt())) {
                currencyList.add(currency);
            }
        }
        return currencyList;
    }
}
