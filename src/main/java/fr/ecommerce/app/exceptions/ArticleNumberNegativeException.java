package fr.ecommerce.app.exceptions;

import java.util.List;

public class ArticleNumberNegativeException extends Exception {
    private static final String COMMA_SEPARATOR = ",";

    private ArticleNumberNegativeException(String message) {
        super(message);
    }

    public ArticleNumberNegativeException(List<String> negativeValues) throws ArticleNumberNegativeException {
        String message = "The negative numbers are : " + String.join(COMMA_SEPARATOR, negativeValues);
        throw new ArticleNumberNegativeException(message);
    }
}
