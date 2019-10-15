package fr.ecommerce.app.implementations;

import fr.ecommerce.app.PriceResolver;
import fr.ecommerce.app.models.Price;

import java.math.BigDecimal;
import java.util.Arrays;
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

    public BigDecimal computeAlternative(Price price, Integer [] articlesNumber) {
        int nbPenta = 0;
        final int arrayLength = articlesNumber.length;
        int nbArticles = Arrays.asList(articlesNumber).stream().mapToInt(i -> i).sum();
        int nbArticleLeft  = nbArticles;

        boolean shouldContinue = true;
        int i;

        while (true) {
            if (!(nbArticleLeft >= arrayLength && shouldContinue)) break;
            i = 0;
            while (i < 5 && articlesNumber[i] > 0) {
                i++;
            }
            if(i == arrayLength) {
                nbPenta++;
                nbArticleLeft = nbArticleLeft - arrayLength;
                // Remove penta from list
                for(int j = 0; j < arrayLength; j++) {
                    articlesNumber[j]--;
                }
            }
            else {
                shouldContinue = false;
            }
        }

        // Now we look for group of 4 articles
        //......

        return BigDecimal.ZERO;
    }
}
