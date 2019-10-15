package fr.ecommerce.app.features;

import fr.ecommerce.app.exceptions.ArticleNumberNegativeException;
import fr.ecommerce.app.exceptions.PriceNegativeException;

import java.math.BigDecimal;

public interface IMinimize {
    BigDecimal minimize(String initialPrice, int articleA, int articleB, int articleC, int articleD, int articleE) throws PriceNegativeException, ArticleNumberNegativeException;
}
