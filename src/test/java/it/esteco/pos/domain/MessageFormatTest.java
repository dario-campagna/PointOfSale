package it.esteco.pos.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MessageFormatTest {

    private MessageFormat messageFormat;

    @Before
    public void setUp() throws Exception {
        messageFormat = new MessageFormat();
    }

    @Test
    public void productNotFound() throws Exception {
        assertThat(messageFormat.formatProductNotFound(new BarCode("XXX")), is("Product not found: XXX"));
    }

    @Test
    public void formatTotal() throws Exception {
        assertThat(messageFormat.formatPrice(new Money(100)), is("CAD 1.00"));
    }

    @Test
    public void formatProductPrice() throws Exception {
        assertThat(messageFormat.formatPrice(new Product(new Money(10))), is("CAD 00.10 G"));
    }

    @Test
    public void formatProvTaxedProductPrice() throws Exception {
        Product product = new Product(new Money(1), true);
        assertThat(messageFormat.formatPrice(product), is("CAD 00.01 GP"));
    }
}
