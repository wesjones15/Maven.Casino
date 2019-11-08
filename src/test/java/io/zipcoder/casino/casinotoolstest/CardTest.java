package io.zipcoder.casino.casinotoolstest;

import io.zipcoder.casino.sweetasscasinotools.Card;
import org.junit.Assert;
import org.junit.Test;

public class CardTest {
    @Test
    public void testToString1() {
        Card card = new Card("of Diamonds", "Two", 2);
        String actual = card.toString();
        String expected = "Two of Diamonds (value: 2)";
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testToString2() {
        Card card = new Card("of Clubs", "Seven", 7);
        String actual = card.toString();
        String expected = "Seven of Clubs (value: 7)";
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testToString3() {
        Card card = new Card("of Hearts", "Queen", 11);
        String actual = card.toString();
        String expected = "Queen of Hearts (value: 11)";
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testGetValue1() {
        Card card = new Card("of Diamonds", "Two", 2);
        Integer actual = card.getValue();
        Integer expected = 2;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testGetValue2() {
        Card card = new Card("of Clubs", "Seven", 7);
        Integer actual = card.getValue();
        Integer expected = 7;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testGetValue3() {
        Card card = new Card("of Hearts", "Queen", 11);
        Integer actual = card.getValue();
        Integer expected = 11;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetFace1() {
        Card card = new Card("of Diamonds", "Two", 2);
        String actual = card.getFace();
        String expected = "Two";
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testGetFace2() {
        Card card = new Card("of Clubs", "Seven", 7);
        String actual = card.getFace();
        String expected = "Seven";
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testGetFace3() {
        Card card = new Card("of Hearts", "Queen", 11);
        String actual = card.getFace();
        String expected = "Queen";
        Assert.assertEquals(expected, actual);
    }
}
