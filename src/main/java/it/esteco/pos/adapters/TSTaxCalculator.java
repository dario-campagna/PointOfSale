package it.esteco.pos.adapters;

import it.esteco.pos.domain.Money;
import it.esteco.pos.domain.Product;
import it.esteco.pos.domain.ports.TaxCalculator;

public class TSTaxCalculator implements TaxCalculator {
    @Override
    public Money getTaxes(Product product) {
        Money taxes = product.getPrice().percentage(5);
        if (product.isProvTaxed()) {
            taxes = taxes.add(product.getPrice().percentage(2));
        }
        return taxes;
    }
}
