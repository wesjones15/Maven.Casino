package io.zipcoder.casino.casinotoolstest;

import io.zipcoder.casino.sweetasscasinotools.Card;
import io.zipcoder.casino.sweetasscasinotools.Deck;
import org.junit.Assert;
import org.junit.Test;

public class DeckTest {
    @Test
    public void testRemoveTopCard() {
        Deck deck = new Deck();
        Card card = deck.removeTopCard();
        Assert.assertTrue(card instanceof Card);
    }
}
