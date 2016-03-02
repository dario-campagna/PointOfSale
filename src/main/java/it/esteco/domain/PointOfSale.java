package it.esteco.domain;

import java.util.List;

public class PointOfSale {

    private List<Integer> cart;
    private Catalog catalog;

    public PointOfSale(List<Integer> cart, Catalog catalog) {
        this.cart = cart;
        this.catalog = catalog;
    }

    public void onScannedProduct(String barCode) {
        cart.add(catalog.findBy(barCode));
    }
}
