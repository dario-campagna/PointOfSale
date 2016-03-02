package it.esteco;

import it.esteco.domain.Catalog;
import it.esteco.domain.PointOfSale;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PointOfSaleTest {

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Test
    public void addScannedProductToCartWhenProductExists() throws Exception {
        List<Integer> cart = new ArrayList<>();
        Catalog catalog = context.mock(Catalog.class);
        context.checking(new Expectations(){{
            allowing(catalog).findBy("A");
            will(returnValue(100));
        }});

        PointOfSale pointOfSale = new PointOfSale(cart, catalog);
        pointOfSale.onScannedProduct("A");

        assertThat(cart.size(), is(1));
        assertThat(cart.get(0), is(100));
    }
}