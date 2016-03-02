package it.esteco.domain;

public interface Catalog {
    Money findBy(BarCode barCode);
}
