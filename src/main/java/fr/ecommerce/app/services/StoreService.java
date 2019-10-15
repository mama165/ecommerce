package fr.ecommerce.app.services;

import fr.ecommerce.app.PriceResolver;
import fr.ecommerce.app.exceptions.ArticleNumberNegativeException;
import fr.ecommerce.app.exceptions.PriceNegativeException;
import fr.ecommerce.app.features.IMinimize;
import fr.ecommerce.app.models.Basket;
import fr.ecommerce.app.models.Price;

import java.math.BigDecimal;

public class StoreService implements IMinimize {
   private final PriceResolver priceResolver;

    StoreService(PriceResolver priceResolver) {
        this.priceResolver = priceResolver;
    }

    @Override
    public BigDecimal minimize(String initialPrice, int articleA, int articleB, int articleC, int articleD, int articleE) throws PriceNegativeException, ArticleNumberNegativeException {
        Price price = Price.create(initialPrice);
        Basket basket = Basket.create(articleA, articleB, articleC, articleD, articleE);
        return priceResolver.compute(price, basket.toList());
    }
}
