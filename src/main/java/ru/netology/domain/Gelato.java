package ru.netology.domain;

import java.util.Objects;

public class Gelato extends Product {
    private String flavor;


    public Gelato(int id, String name, int price, String flavor) {
        super(id, name, price);
        this.flavor = flavor;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public Gelato() {super();}


}
