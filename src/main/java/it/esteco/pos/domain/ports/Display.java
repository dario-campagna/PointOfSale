package it.esteco.pos.domain.ports;

import it.esteco.pos.domain.BarCode;
import it.esteco.pos.domain.Money;
import it.esteco.pos.domain.Product;

public interface Display {
    void showProductNotFound(BarCode barCode );

    void showTotal(Money total);

    void showPrice(Product product);
}
