package com.example.HotelCali;

import lombok.Data;
import lombok.Setter;

public enum Type {
    SIMPLE("Simple"),
    DOUBLE("Double"),
    SUITE("Suite");

    private String text;
    Type(String simple) {
        this.text = simple;
    }

    public String getText() {
        return text;
    }
}
