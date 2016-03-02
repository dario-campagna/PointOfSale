package it.esteco.pos.domain;

import it.esteco.pos.domain.ports.Catalog;
import it.esteco.pos.domain.ports.Display;
import it.esteco.pos.domain.ports.TaxCalculator;

import java.util.List;

public class PointOfSale {

    private List<Product> cart;
    private Catalog catalog;
    private Display display;
    private TaxCalculator taxCalculator;

    public PointOfSale(List<Product> cart, Catalog catalog, Display display, TaxCalculator taxCalculator) {
        this.cart = cart;
        this.catalog = catalog;
        this.display = display;
        this.taxCalculator = taxCalculator;
    }

    public void onScannedProduct(BarCode barCode) {
        Product product = catalog.findBy(barCode);
        if (null == product) {
            display.showProductNotFound(barCode);
        } else {
            cart.add(product);
            display.showPrice(product);
        }
    }

    public void onTotalRequested() {
        Money total = new Money(0);
        for (Product product : cart) {
            total = total.add(product.getPrice().add(taxCalculator.getTaxes(product)));
        }
        display.showTotal(total);
    }
}
