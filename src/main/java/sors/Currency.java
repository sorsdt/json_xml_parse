package sors;

import java.math.BigDecimal;

public class Currency {
    String txt;
    BigDecimal rate;

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Currency(String txt, BigDecimal rate) {
        this.txt = txt;
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Currency currency = (Currency) o;

        if (!txt.equals(currency.txt)) return false;
        return rate.equals(currency.rate);
    }

    @Override
    public int hashCode() {
        int result = txt.hashCode();
        result = 31 * result + rate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "{" +
                "txt='" + txt + '\'' +
                ", rate=" + rate +
                '}';
    }
}
