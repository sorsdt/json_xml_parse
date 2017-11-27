package sors;

import java.util.List;

public interface Rates {
    List<Currency> getData();

    default boolean isOurCurrency(String txt) {
        switch (txt) {
            case "Долар США":
            case "Російський рубль":
            case "Євро": return true;
        }
        return false;
    }
}
