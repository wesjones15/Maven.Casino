package io.zipcoder.casino.sweetasscasinotools;

public class Card {
    private String suite;
    private String face;
    private Integer value;

    public Card(String suite, String face, Integer value) {
        this.suite = suite;
        this.face = face;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card[" +
                "suite = " + suite  +
                ", face = " + face  + "]  " + value;
    }

    public Integer getValue() {
        return value;
    }
}