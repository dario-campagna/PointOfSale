package it.esteco.pos.adapters;

import it.esteco.pos.domain.Money;
import it.esteco.pos.domain.Product;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TSTaxCalculatorTest {

    private TSTaxCalculator tsTaxCalculator;

    @Before
    public void setUp() throws Exception {
        tsTaxCalculator = new TSTaxCalculator();
    }

    @Test
    public void computeTaxesForProduct() throws Exception {
        assertThat(tsTaxCalculator.getTaxes(new Product(new Money(100))), is(new Money(5)));
    }

    @Test
    public void computeTaxesForProvTaxedProduct() throws Exception {
        assertThat(tsTaxCalculator.getTaxes(new Product(new Money(100), true)), is(new Money(7)));
    }
}
