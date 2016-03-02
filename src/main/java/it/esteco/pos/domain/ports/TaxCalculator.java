package it.esteco.pos.domain.ports;

import it.esteco.pos.domain.Money;
import it.esteco.pos.domain.Product;

public interface TaxCalculator {
    Money getTaxes(Product product);
}
