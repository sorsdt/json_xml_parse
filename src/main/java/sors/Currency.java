package sors;

import java.math.BigDecimal;

public class Currency {
    String name;
    BigDecimal rate;

    public Currency(String name, BigDecimal rate) {
        this.name = name;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Currency currency = (Currency) o;

        if (!name.equals(currency.name)) return false;
        return rate.equals(currency.rate);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + rate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "name='" + name + '\'' +
                ", rate=" + rate +
                '}';
    }
}
