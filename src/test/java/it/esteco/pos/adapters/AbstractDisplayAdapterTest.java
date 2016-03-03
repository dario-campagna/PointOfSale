package it.esteco.pos.adapters;

import it.esteco.pos.domain.BarCode;
import it.esteco.pos.domain.Money;
import it.esteco.pos.domain.Product;
import it.esteco.pos.domain.ports.Display;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public abstract class AbstractDisplayAdapterTest {

    @Test
    public void displayNotFoundMessage() throws Exception {
        getDisplay().showProductNotFound(new BarCode("XXX"));
        assertThat(shownMessage(), is("Product not found: XXX"));
    }

    @Test
    public void displayTotal() throws Exception {
        getDisplay().showTotal(new Money(101));
        assertThat(shownMessage(), is("CAD 1.01"));
    }

    @Test
    public void displayProductPrice() throws Exception {
        getDisplay().showPrice(new Product(new Money(1111)));
        assertThat(shownMessage(), is("CAD 11.11 G"));
    }

    @Test
    public void displayProvTaxedProductPrice() throws Exception {
        getDisplay().showPrice(new Product(new Money(100000), true));
        assertThat(shownMessage(), is("CAD 1000.00 GP"));
    }

    protected abstract Display getDisplay();

    protected abstract String shownMessage();
}
