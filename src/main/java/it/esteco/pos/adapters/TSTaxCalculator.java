package it.esteco.pos.adapters;

import it.esteco.pos.domain.Money;
import it.esteco.pos.domain.Product;
import it.esteco.pos.domain.ports.TaxCalculator;

public class TSTaxCalculator implements TaxCalculator {

    public static final int G_TAX_PERCENTAGE = 5;
    public static final int P_TAX_PERCENTAGE = 2;

    @Override
    public Money getTaxes(Product product) {
        Money taxes = product.getPrice().percentage(G_TAX_PERCENTAGE);
        if (product.isProvTaxed()) {
            taxes = taxes.add(product.getPrice().percentage(P_TAX_PERCENTAGE));
        }
        return taxes;
    }
}
