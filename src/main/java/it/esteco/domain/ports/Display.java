package it.esteco.domain.ports;

import it.esteco.domain.BarCode;
import it.esteco.domain.Money;

public interface Display {
    void showProductNotFound(BarCode barCode );

    void showTotal(Money total);
}
