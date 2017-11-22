package sors;

import java.math.BigDecimal;

public class Currency {
    String txt;
    BigDecimal rate;
    String cc;

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

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Currency currency = (Currency) o;

        if (txt != null ? !txt.equals(currency.txt) : currency.txt != null) return false;
        if (rate != null ? !rate.equals(currency.rate) : currency.rate != null) return false;
        return cc != null ? cc.equals(currency.cc) : currency.cc == null;
    }

    @Override
    public int hashCode() {
        int result = txt != null ? txt.hashCode() : 0;
        result = 31 * result + (rate != null ? rate.hashCode() : 0);
        result = 31 * result + (cc != null ? cc.hashCode() : 0);
        return result;
    }
}
