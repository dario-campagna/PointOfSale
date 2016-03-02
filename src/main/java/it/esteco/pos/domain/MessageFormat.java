package it.esteco.pos.domain;

public class MessageFormat {

    public String formatProductNotFound(BarCode barCode) {
        return "Product not found: " + barCode.getCode();
    }

    public String formatPrice(Money money) {
        return "CAD " + formatMoney(money);
    }

    public String formatPrice(Product product) {
        String price = formatPrice(product.getPrice()) + " G";
        if (product.isProvTaxed()) {
            price += "P";
        }
        return price;
    }

    private String formatMoney(Money money) {
        String cents = String.valueOf(money.getCents());
        return integerPart(cents) + "." + decimalPart(cents);
    }

    private String integerPart(String cents) {
        if (hasLessThanThreeDigits(cents)) {
            return "00";
        }
        return cents.substring(0, cents.length() - 2);
    }

    private String decimalPart(String cents) {
        if (hasOneDigit(cents)) {
            return "0" + cents;
        }
        return cents.substring(cents.length() - 2, cents.length());
    }

    private boolean hasOneDigit(String cents) {
        return cents.length() == 1;
    }

    private boolean hasLessThanThreeDigits(String cents) {
        return cents.length() < 3;
    }
}
