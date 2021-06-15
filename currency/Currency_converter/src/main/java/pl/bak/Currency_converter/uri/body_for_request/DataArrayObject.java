package pl.bak.Currency_converter.uri.body_for_request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataArrayObject implements Serializable {
    private List<DataInMultiArray> rates = new ArrayList<>();


    public List<DataInMultiArray> getRates() {
        return rates;
    }

    public void setRates(List<DataInMultiArray> rates) {
        this.rates = rates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataArrayObject that = (DataArrayObject) o;

        return Objects.equals(rates, that.rates);
    }

    @Override
    public int hashCode() {
        return rates != null ? rates.hashCode() : 0;
    }
}
