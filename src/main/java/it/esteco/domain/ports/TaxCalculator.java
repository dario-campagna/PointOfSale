package it.esteco.domain.ports;

import it.esteco.domain.Money;
import it.esteco.domain.Product;

public interface TaxCalculator {
    Money getTaxes(Product product);
}
