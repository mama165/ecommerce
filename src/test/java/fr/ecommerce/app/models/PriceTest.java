package fr.ecommerce.app.models;

import fr.ecommerce.app.exceptions.PriceNegativeException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PriceTest {
    @Test
    void should_throw_exception_on_create_when_price_null() {
        Throwable throwable = assertThrows(IllegalArgumentException.class, () ->
                Price.create(null)
        );

        String messageExpected = "The price is null";

        assertEquals(messageExpected, throwable.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "'-677'",
            "'-97'",
            "'-46'",
            "'-677'",
            "'-7544'",
            "'-9853335'"
    })
    void should_throw_exception_when_price_negative(String price) {
        Throwable throwable = assertThrows(PriceNegativeException.class, () ->
                Price.create(price)
        );

        String messageExpected = "The price is a negative number (" + price + ").";

        assertEquals(messageExpected, throwable.getMessage());
    }
}
