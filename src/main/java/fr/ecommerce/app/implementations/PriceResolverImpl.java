package fr.ecommerce.app.implementations;

import fr.ecommerce.app.PriceResolver;
import fr.ecommerce.app.models.Price;

import java.math.BigDecimal;
import java.util.List;

public class PriceResolverImpl implements PriceResolver {
    /**
     * We can start by finding some groupes of five articles
     * if c minimum in [a,b,c,d,e}
     * And a!=0 && b!=0 && ... (No zero)
     * Then we have  c*group of five articles...
     * @param price
     * @param articlesNumber
     * @return
     */
    @Override
    public BigDecimal compute(Price price, List<Integer> articlesNumber) {

        return BigDecimal.ZERO;
    }
}
