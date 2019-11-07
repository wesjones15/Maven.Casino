package io.zipcoder.casino.sweetasscasinotools;

import java.util.Comparator;

public class SortCards implements Comparator<Card> {
    public int compare(Card a, Card b){
        return a.getValue() - b.getValue();
    }
}
