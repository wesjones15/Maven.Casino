package io.zipcoder.casino;

public class Card {
    private String suite;
    private String face;
    private Integer value;

    public Card(String suite, String face, Integer value) {
        this.suite = suite;
        this.face = face;
        this.value = value;
    }
}