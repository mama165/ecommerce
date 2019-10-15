package fr.ecommerce.app.models;

import fr.ecommerce.app.exceptions.ArticleNumberNegativeException;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Basket {
    private final int articleA;
    private final int articleB;
    private final int articleC;
    private final int articleD;
    private final int articleE;

    private Basket(int articleA, int articleB, int articleC, int articleD, int articleE) {
        this.articleA = articleA;
        this.articleB = articleB;
        this.articleC = articleC;
        this.articleD = articleD;
        this.articleE = articleE;
    }

    public static Basket create(int articleA, int articleB, int articleC, int articleD, int articleE) throws ArticleNumberNegativeException {
        List<String> negativeIntegers = new LinkedList<>();

        if (articleA < 0) {
            negativeIntegers.add(String.valueOf(articleA));
        }

        if (articleB < 0) {
            negativeIntegers.add(String.valueOf(articleB));
        }

        if (articleC < 0) {
            negativeIntegers.add(String.valueOf(articleC));
        }

        if (articleD < 0) {
            negativeIntegers.add(String.valueOf(articleD));
        }

        if (articleE < 0) {
            negativeIntegers.add(String.valueOf(articleE));
        }

        if (!negativeIntegers.isEmpty()) {
            throw new ArticleNumberNegativeException(negativeIntegers);
        }

        return new Basket(articleA, articleB, articleC, articleD, articleE);
    }

    public int getArticleA() {
        return articleA;
    }

    public int getArticleB() {
        return articleB;
    }

    public int getArticleC() {
        return articleC;
    }

    public int getArticleD() {
        return articleD;
    }

    public int getArticleE() {
        return articleE;
    }

    public List<Integer> toList() {
        return Collections.unmodifiableList(
                Arrays.asList(
                        articleA,
                        articleB,
                        articleC,
                        articleD,
                        articleE
                )
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return articleA == basket.articleA &&
                articleB == basket.articleB &&
                articleC == basket.articleC &&
                articleD == basket.articleD &&
                articleE == basket.articleE;
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleA, articleB, articleC, articleD, articleE);
    }
}
