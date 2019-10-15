package fr.ecommerce.app;

import fr.ecommerce.app.models.Price;

import java.math.BigDecimal;
import java.util.List;

public interface PriceResolver {

    BigDecimal compute(Price price, List<Integer> articlesNumber);
}
