package fr.ecommerce.app.exceptions;

import java.math.BigDecimal;

public class PriceNegativeException extends Exception {
    public PriceNegativeException(BigDecimal priceValue) {
        super("The price is a negative number (" + priceValue + ").");
    }
}
