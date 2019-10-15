package fr.ecommerce.app.models;

public enum OperationPercent {
    TWENTY_FIVE("25"),
    TWENTY("20"),
    TEN("10"),
    FIVE("5");

    private final String percentage;

    OperationPercent(String percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return percentage;
    }
}
