package pl.bak.Currency_converter.model;

public enum CurrencyCode {
    PLN("PLN"),
    EUR("EUR"),
    USD("USD"),
    GBP("GBP"),
    AUD("AUD");

    public final String value;

    CurrencyCode(String value) {
        this.value = value;
    }
}
