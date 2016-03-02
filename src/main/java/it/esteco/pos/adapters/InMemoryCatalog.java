package it.esteco.pos.adapters;

import it.esteco.pos.domain.BarCode;
import it.esteco.pos.domain.Product;
import it.esteco.pos.domain.ports.Catalog;

import java.util.Map;

public class InMemoryCatalog implements Catalog {
    private Map<BarCode, Product> productMap;

    public InMemoryCatalog(Map<BarCode, Product> productMap) {
        this.productMap = productMap;
    }

    @Override
    public Product findBy(BarCode barCode) {
        return productMap.get(barCode);
    }
}
