package it.esteco.pos.main;

import it.esteco.pos.adapters.InMemoryCatalog;
import it.esteco.pos.adapters.TSTaxCalculator;
import it.esteco.pos.adapters.display.ConsoleDisplay;
import it.esteco.pos.adapters.display.DisplayArea;
import it.esteco.pos.adapters.display.ScreenDisplay;
import it.esteco.pos.domain.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PointOfSaleFactory {

    public PointOfSale consolePOS() {
        return new PointOfSale(new ArrayList<>(), new InMemoryCatalog(getProductMap()), new ConsoleDisplay(new MessageFormat()), new TSTaxCalculator());
    }

    public PointOfSale screenPOS(DisplayArea displayArea) {
        return new PointOfSale(new ArrayList<>(), new InMemoryCatalog(getProductMap()), new ScreenDisplay(new MessageFormat(), displayArea), new TSTaxCalculator());
    }

    private Map<BarCode, Product> getProductMap() {
        Map<BarCode, Product> productMap = new HashMap<>();
        productMap.put(new BarCode("123"), new Product(new Money(1000)));
        productMap.put(new BarCode("456"), new Product(new Money(100), true));
        productMap.put(new BarCode("789"), new Product(new Money(5000), true));
        return productMap;
    }
}
