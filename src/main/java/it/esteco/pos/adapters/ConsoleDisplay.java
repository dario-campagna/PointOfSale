package it.esteco.pos.adapters;

import it.esteco.pos.domain.BarCode;
import it.esteco.pos.domain.MessageFormat;
import it.esteco.pos.domain.Money;
import it.esteco.pos.domain.Product;
import it.esteco.pos.domain.ports.Display;

public class ConsoleDisplay implements Display
{
    private MessageFormat messageFormat;

    public ConsoleDisplay(MessageFormat messageFormat) {
        this.messageFormat = messageFormat;
    }

    @Override
    public void showProductNotFound(BarCode barCode) {
        System.out.println(messageFormat.formatProductNotFound(barCode));
    }

    @Override
    public void showTotal(Money total) {
        System.out.println(messageFormat.formatPrice(total));
    }

    @Override
    public void showPrice(Product product) {
        System.out.println(messageFormat.formatPrice(product));
    }
}
