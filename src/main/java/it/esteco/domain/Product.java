package it.esteco.domain;

public class Product {
    private Money price;

    public Product(Money price) {
        this.price = price;
    }

    public Money getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Product product = (Product) o;

        return price != null ? price.equals(product.price) : product.price == null;

    }

    @Override
    public int hashCode() {
        return price != null ? price.hashCode() : 0;
    }
}
