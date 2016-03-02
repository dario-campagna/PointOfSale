package it.esteco.pos.adapters;

import it.esteco.pos.domain.BarCode;
import it.esteco.pos.domain.Money;
import it.esteco.pos.domain.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class InMemoryCatalogTest {

    private InMemoryCatalog inMemoryCatalog;
    private Map<BarCode, Product> productMap;

    @Before
    public void setUp() throws Exception {
        productMap = new HashMap<>();
        inMemoryCatalog = new InMemoryCatalog(productMap);
    }

    @Test
    public void returnNullWhenProductNotFound() throws Exception {
        assertNull(inMemoryCatalog.findBy(new BarCode("Not exists")));
    }

    @Test
    public void returnProductWhenItExists() {
        productMap.put(new BarCode("A"), new Product(new Money(1)));
        assertThat(inMemoryCatalog.findBy(new BarCode("A")), is(new Product(new Money(1))));
    }

}
