package it.esteco.domain.ports;

import it.esteco.domain.BarCode;
import it.esteco.domain.Money;

public interface Catalog {
    Money findBy(BarCode barCode);
}
