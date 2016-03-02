package it.esteco.pos.main;

import it.esteco.pos.adapters.ConsoleDisplay;
import it.esteco.pos.adapters.InMemoryCatalog;
import it.esteco.pos.adapters.TSTaxCalculator;
import it.esteco.pos.domain.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PointOfSaleFactory {

    public PointOfSale create() {
        Map<BarCode, Product> productMap = new HashMap<>();
        productMap.put(new BarCode("123"), new Product(new Money(1000)));
        productMap.put(new BarCode("456"), new Product(new Money(100), true));
        productMap.put(new BarCode("789"), new Product(new Money(5000), true));
        return new PointOfSale(new ArrayList<>(), new InMemoryCatalog(productMap), new ConsoleDisplay(new MessageFormat()), new TSTaxCalculator());
    }

}
