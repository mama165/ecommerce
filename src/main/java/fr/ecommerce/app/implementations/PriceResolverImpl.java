package fr.ecommerce.app.implementations;

import fr.ecommerce.app.PriceResolver;
import fr.ecommerce.app.models.OperationPercent;
import fr.ecommerce.app.models.Price;
import org.paukov.combinatorics3.Generator;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class PriceResolverImpl implements PriceResolver {
    private static final BigDecimal TWENTY_FIVE_PERCENT = new BigDecimal("3.75");
    private static final BigDecimal TWENTY_PERCENT = new BigDecimal("3.2");
    private static final BigDecimal TEN_PERCENT = new BigDecimal("2.7");
    private static final BigDecimal FIVE_PERCENT = new BigDecimal("1.9");

    private static final List<List<Integer>> FIVE_PERCENT_LIST =
            Generator.permutation(0, 0, 0, 1, 1)
                    .simple()
                    .stream()
                    .collect(Collectors.toList());

    private static final List<List<Integer>> TEN_PERCENT_LIST =
            Generator.permutation(0, 0, 1, 1, 1)
                    .simple()
                    .stream()
                    .collect(Collectors.toList());

    private static final List<List<Integer>> TWENTY_PERCENT_LIST =
            Generator.permutation(0, 1, 1, 1, 1)
            .simple()
            .stream()
            .collect(Collectors.toList());

    private static final List<List<Integer>> TWENTY_FIVE_PERCENT_LIST =
            Generator.permutation(1, 1, 1, 1, 1)
                    .simple()
                    .stream()
                    .collect(Collectors.toList());

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
