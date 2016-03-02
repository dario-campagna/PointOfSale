package it.esteco.pos.domain;

public class Money {

    private final int cents;

    public Money(int cents) {
        this.cents = cents;
    }

    public int getCents() {
        return cents;
    }

    @Override
    public String toString() {
        return String.valueOf(cents);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Money money = (Money) o;

        return cents == money.cents;

    }

    @Override
    public int hashCode() {
        return cents;
    }

    public Money add(Money money) {
        return new Money(cents + money.getCents());
    }
}
