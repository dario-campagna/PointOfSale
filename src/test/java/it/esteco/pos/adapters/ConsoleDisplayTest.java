package it.esteco.pos.adapters;

import it.esteco.pos.adapters.display.ConsoleDisplay;
import it.esteco.pos.domain.BarCode;
import it.esteco.pos.domain.MessageFormat;
import it.esteco.pos.domain.Money;
import it.esteco.pos.domain.Product;
import it.esteco.pos.domain.ports.Display;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ConsoleDisplayTest extends AbstractDisplayAdapterTest {

    private ByteArrayOutputStream outputStream;
    private ConsoleDisplay consoleDisplay;

    @Before
    public void setUp() throws Exception {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        consoleDisplay = new ConsoleDisplay(new MessageFormat());
    }

    @Override
    protected Display getDisplay() {
        return consoleDisplay;
    }

    @Override
    protected String shownMessage() {
        return outputStream.toString();
    }
}
