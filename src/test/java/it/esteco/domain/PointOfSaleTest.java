package it.esteco.domain;

import it.esteco.domain.Catalog;
import it.esteco.domain.Display;
import it.esteco.domain.PointOfSale;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PointOfSaleTest {

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();
    private PointOfSale pointOfSale;
    private Catalog catalog;
    private Display display;
    private List<Money> cart;

    @Before
    public void setUp() throws Exception {
        cart = new ArrayList<>();
        catalog = context.mock(Catalog.class);
        display = context.mock(Display.class);
        pointOfSale = new PointOfSale(cart, catalog, display);
    }

    @Test
    public void addScannedProductToCartWhenProductExists() throws Exception {
        context.checking(new Expectations(){{
            allowing(catalog).findBy(new BarCode("A"));
            will(returnValue(new Money(100)));
        }});

        pointOfSale.onScannedProduct(new BarCode("A"));

        assertThat(cart.size(), is(1));
        assertThat(cart.get(0), is(new Money(100)));
    }

    @Test
    public void displayErrorWhenScannedProductNotExists() throws Exception {
        context.checking(new Expectations(){{
            allowing(catalog).findBy(new BarCode("Not exists"));
            will(returnValue(null));
            oneOf(display).showProductNotFound(new BarCode("Not exists"));
        }});

        pointOfSale.onScannedProduct(new BarCode("Not exists"));

        assertThat(cart.size(), is(0));
    }
}