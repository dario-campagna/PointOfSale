package it.esteco.pos.adapters;

import it.esteco.pos.domain.BarCode;
import it.esteco.pos.domain.MessageFormat;
import it.esteco.pos.domain.Money;
import it.esteco.pos.domain.Product;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ConsoleDisplayTest {

    private ByteArrayOutputStream outputStream;
    private ConsoleDisplay consoleDisplay;

    @Before
    public void setUp() throws Exception {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        consoleDisplay = new ConsoleDisplay(new MessageFormat());
    }

    @Test
    public void displayNotFoundMessage() throws Exception {
        consoleDisplay.showProductNotFound(new BarCode("XXX"));
        assertThat(outputStream.toString(), is("Product not found: XXX\n"));
    }

    @Test
    public void displayTotal() throws Exception {
        consoleDisplay.showTotal(new Money(101));
        assertThat(outputStream.toString(), is("CAD 1.01\n"));
    }

    @Test
    public void displayProductPrice() throws Exception {
        consoleDisplay.showPrice(new Product(new Money(1111)));
        assertThat(outputStream.toString(), is("CAD 11.11 G\n"));
    }

    @Test
    public void displayProvTaxedProductPrice() throws Exception {
        consoleDisplay.showPrice(new Product(new Money(100000), true));
        assertThat(outputStream.toString(), is("CAD 1000.00 GP\n"));
    }
}
