package it.esteco.pos.domain.ports;

import it.esteco.pos.domain.BarCode;
import it.esteco.pos.domain.Product;

public interface Catalog {
    Product findBy(BarCode barCode);
}
