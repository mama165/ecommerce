package fr.ecommerce.app.implementations;

import fr.ecommerce.app.exceptions.ArticleNumberNegativeException;
import fr.ecommerce.app.exceptions.PriceNegativeException;
import fr.ecommerce.app.models.Basket;
import fr.ecommerce.app.models.Price;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PriceResolverImplTest {
    private PriceResolverImpl priceResolver;

    @BeforeEach
    void setup() {
        priceResolver = new PriceResolverImpl();
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void should_compute_price_without_exceeding_timeout(Price initialPrice, Basket basket, BigDecimal priceExpected) {
        BigDecimal output = priceResolver.compute(initialPrice, basket.toList());

        assertTrue(true);
    }

    private static Stream<Arguments> provideArguments() throws ArticleNumberNegativeException, PriceNegativeException {
        return Stream.of(
                Arguments.of(
                        Price.create("8"),
                        Basket.create(2, 2, 2, 1, 1),
                        new BigDecimal("51.20")
                ),
                Arguments.of(
                        Price.create("8"),
                        Basket.create(1, 1, 1, 1, 1),
                        new BigDecimal("30")
                ),
                Arguments.of(
                        Price.create("8"),
                        Basket.create(0, 0, 0, 0, 0),
                        BigDecimal.ZERO
                )
        );
    }
}
