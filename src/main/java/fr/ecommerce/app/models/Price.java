package fr.ecommerce.app.models;


import fr.ecommerce.app.exceptions.PriceNegativeException;

import java.math.BigDecimal;
import java.util.Objects;

public class Price {
    private final BigDecimal value;

    private Price(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getPriceValue() {
        return value;
    }

    /**
     * We use a factory for the arguments validation
     * @param price
     * @return
     * @throws PriceNegativeException
     */
    public static Price create(String price) throws PriceNegativeException {
        if (price == null) throw new IllegalArgumentException("The price is null");

        BigDecimal priceValue = new BigDecimal(price);

        if (priceValue.compareTo(BigDecimal.ZERO) < 0) {
            throw new PriceNegativeException(priceValue);
        }

        return new Price(priceValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return value.equals(price.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
