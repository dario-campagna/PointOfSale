package it.esteco.pos.adapters.display;

import it.esteco.pos.domain.BarCode;
import it.esteco.pos.domain.MessageFormat;
import it.esteco.pos.domain.Money;
import it.esteco.pos.domain.Product;
import it.esteco.pos.domain.ports.Display;

public class ScreenDisplay implements Display {

    private MessageFormat messageFormat;
    private DisplayArea displayArea;

    public ScreenDisplay(MessageFormat messageFormat, DisplayArea displayArea) {
        this.messageFormat = messageFormat;
        this.displayArea = displayArea;
    }

    @Override
    public void showProductNotFound(BarCode barCode) {
        displayArea.show(messageFormat.formatProductNotFound(barCode));
    }

    @Override
    public void showTotal(Money total) {
        displayArea.show(messageFormat.formatPrice(total));
    }

    @Override
    public void showPrice(Product product) {
        displayArea.show(messageFormat.formatPrice(product));
    }
}
