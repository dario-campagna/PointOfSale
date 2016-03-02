package it.esteco.domain.ports;

import it.esteco.domain.BarCode;
import it.esteco.domain.Product;

public interface Catalog {
    Product findBy(BarCode barCode);
}
