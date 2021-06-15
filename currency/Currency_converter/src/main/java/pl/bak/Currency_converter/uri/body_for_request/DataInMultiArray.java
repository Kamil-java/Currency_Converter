package pl.bak.Currency_converter.uri.body_for_request;

import java.io.Serializable;
import java.util.Objects;

public class DataInMultiArray implements Serializable {
    private String currency;
    private String code;
    private double mid;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getMid() {
        return mid;
    }

    public void setMid(double mid) {
        this.mid = mid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataInMultiArray that = (DataInMultiArray) o;

        if (Double.compare(that.mid, mid) != 0) return false;
        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;
        return code != null ? code.equals(that.code) : that.code == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = currency != null ? currency.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        temp = Double.doubleToLongBits(mid);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
