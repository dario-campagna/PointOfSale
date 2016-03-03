package it.esteco.pos.adapters;

import it.esteco.pos.adapters.display.DisplayArea;
import it.esteco.pos.adapters.display.ScreenDisplay;
import it.esteco.pos.domain.MessageFormat;
import it.esteco.pos.domain.ports.Display;
import org.junit.Before;

public class ScreenDisplayTest extends AbstractDisplayAdapterTest {

    private ScreenDisplay screenDisplay;
    private StubDisplayArea displayArea;

    @Before
    public void setUp() throws Exception {
        displayArea = new StubDisplayArea();
        screenDisplay = new ScreenDisplay(new MessageFormat(), displayArea);
    }

    @Override
    protected Display getDisplay() {
        return screenDisplay;
    }

    @Override
    protected String shownMessage() {
        return displayArea.getText();
    }

    public static class StubDisplayArea implements DisplayArea {

        private String text;

        @Override
        public void show(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }
}
