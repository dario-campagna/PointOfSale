package it.esteco.pos.domain;

public class BarCode {

    private final String code;

    public BarCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BarCode barCode = (BarCode) o;

        return code != null ? code.equals(barCode.code) : barCode.code == null;

    }

    @Override
    public int hashCode() {
        return code != null ? code.hashCode() : 0;
    }
}
