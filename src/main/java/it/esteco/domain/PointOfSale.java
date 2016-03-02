package it.esteco.domain;

import java.util.List;

public class PointOfSale {

    private List<Money> cart;
    private Catalog catalog;
    private Display display;

    public PointOfSale(List<Money> cart, Catalog catalog, Display display) {
        this.cart = cart;
        this.catalog = catalog;
        this.display = display;
    }

    public void onScannedProduct(BarCode barCode) {
        Money price = catalog.findBy(barCode);
        if (null == price) {
            display.showProductNotFound(barCode);
        } else {
            cart.add(price);
        }
    }
}
