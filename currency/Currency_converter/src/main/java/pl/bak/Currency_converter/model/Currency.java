package pl.bak.Currency_converter.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity(name = "Credit")
@Table(
        name = "credit"
)
public class Currency {

    @Id
    @SequenceGenerator(
            name = "credit_sequence",
            sequenceName = "credit_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "credit_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Integer id;

    @Column(
            name = "currency_code",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private CurrencyCode currencyCode;

    @Column(
            name = "saleValue"
    )
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal saleValue;

    @Column(
            name = "purchaseValue"
    )
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal purchaseValue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CurrencyCode getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(CurrencyCode currencyCode) {
        this.currencyCode = currencyCode;
    }

    public BigDecimal getSaleValue() {
        return saleValue;
    }

    public void setSaleValue(BigDecimal saleValue) {
        this.saleValue = saleValue;
    }

    public BigDecimal getPurchaseValue() {
        return purchaseValue;
    }

    public void setPurchaseValue(BigDecimal purchaseValue) {
        this.purchaseValue = purchaseValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Currency currency = (Currency) o;

        if (currencyCode != currency.currencyCode) return false;
        if (!Objects.equals(saleValue, currency.saleValue)) return false;
        return Objects.equals(purchaseValue, currency.purchaseValue);
    }

    @Override
    public int hashCode() {
        int result = currencyCode != null ? currencyCode.hashCode() : 0;
        result = 31 * result + (saleValue != null ? saleValue.hashCode() : 0);
        result = 31 * result + (purchaseValue != null ? purchaseValue.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "currencyCode=" + currencyCode +
                ", saleValue=" + saleValue +
                ", purchaseValue=" + purchaseValue +
                '}';
    }
}
