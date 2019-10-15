package fr.ecommerce.app.models;

import fr.ecommerce.app.exceptions.ArticleNumberNegativeException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BasketTest {
    @ParameterizedTest
    @MethodSource("provideNumbers")
    void should_throw_exception_when_book_number_negative(int articleA, int articleB, int articleC, int articleD, int articleE, String messageExpected) {
        Throwable throwable = assertThrows(ArticleNumberNegativeException.class, () ->
                Basket.create(articleA, articleB, articleC, articleD, articleE)
        );

        assertEquals(messageExpected, throwable.getMessage());
    }

    private static Stream<Arguments> provideNumbers() {
        return Stream.of(
                Arguments.of(-1, 1, 1, 1, 1, "The negative numbers are : -1"),
                Arguments.of(5, 3, -4, 1, -9, "The negative numbers are : -4,-9"),
                Arguments.of(-565, -43, -4, -9, 8, "The negative numbers are : -565,-43,-4,-9"),
                Arguments.of(-3, -63, -4, 56, -9, "The negative numbers are : -3,-63,-4,-9")
        );
    }
}
