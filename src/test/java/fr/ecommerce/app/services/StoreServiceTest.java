package fr.ecommerce.app.services;

import fr.ecommerce.app.PriceResolver;
import fr.ecommerce.app.exceptions.ArticleNumberNegativeException;
import fr.ecommerce.app.exceptions.PriceNegativeException;
import fr.ecommerce.app.models.Basket;
import fr.ecommerce.app.models.Price;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

@ExtendWith(MockitoExtension.class)
class StoreServiceTest {
    private StoreService storeService;
    @Mock
    private PriceResolver priceResolver;

    @BeforeEach
    void setup() {
        storeService = new StoreService(priceResolver);
    }

    @ParameterizedTest
    @CsvSource({
            "-75",
            "-86.54",
            "-864.32",
            "-6.786"
    })
    void should_not_compute_price_when_price_negative(String price) {
        ;
        int articleA = 2;
        int articleB = 2;
        int articleC = 2;
        int articleD = 2;
        int articleE = 2;

        assertThrows(PriceNegativeException.class, () ->
                storeService.minimize(price, articleA, articleB, articleC, articleD, articleE)
        );

        verifyZeroInteractions(priceResolver);
    }

    @Test
    void should_not_compute_price_when_price_null() {
        int articleA = 2;
        int articleB = 2;
        int articleC = 2;
        int articleD = 2;
        int articleE = 2;

        assertThrows(IllegalArgumentException.class, () ->
                storeService.minimize(null, articleA, articleB, articleC, articleD, articleE)
        );

        verifyZeroInteractions(priceResolver);
    }

    @Test
    void should_compute_when_minimize_price() throws PriceNegativeException, ArticleNumberNegativeException {
        String price = "8";
        int articleA = 2;
        int articleB = 2;
        int articleC = 2;
        int articleD = 1;
        int articleE = 1;

        storeService.minimize(price, articleA, articleB, articleC, articleD, articleE);
        Basket basket = Basket.create(articleA, articleB, articleC, articleD, articleE);

        verify(priceResolver, times(1)).compute(Price.create(price), basket.toList());
        verifyNoMoreInteractions(priceResolver);
    }
}
