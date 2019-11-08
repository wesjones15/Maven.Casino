package io.zipcoder.casino.gamestest.KlondikeTest;

import io.zipcoder.casino.games.DiceGames.klondike.KlondikeGame;
import io.zipcoder.casino.games.DiceGames.klondike.KlondikePlayer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KlondikePlayerTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void klondikePlayerConstructorTest() {
        String expectedName = "KH";
        Double expectedWallet = 100.0;
        KlondikePlayer kp = new KlondikePlayer(expectedName, expectedWallet);

        String actualName = kp.getName();
        Double actualWallet = kp.getWallet();
        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedWallet, actualWallet);
    }

    @Test
    public void placeBetTest1() {
        Double betAmount = 100.0;
        Boolean expected = true;
        KlondikePlayer kp = new KlondikePlayer("KH", 100.0);

        Boolean actual = kp.placeBet(betAmount);
        Assert.assertTrue(actual);
    }

    @Test
    public void placeBetTest2() {
        Double betAmount = 200.0;
       // Boolean expected = false;
        KlondikePlayer kp = new KlondikePlayer("KH", 100.0);

        Boolean actual = kp.placeBet(betAmount);
        Assert.assertFalse(actual);
    }

    @Test
    public void verifyValidBetAmountTest1() {
        Double betAmount = 100.0;
        //Boolean expected = true;
        KlondikePlayer kp = new KlondikePlayer("KH", 100.0);

        Boolean actual = kp.verifyValidBetAmount(betAmount);
        Assert.assertTrue(actual);
    }

    @Test
    public void verifyValidBetAmountTest2() {
        Double betAmount = 200.0;
        //Boolean expected = false;
        KlondikePlayer kp = new KlondikePlayer("KH", 100.0);

        Boolean actual = kp.verifyValidBetAmount(betAmount);
        Assert.assertFalse(actual);
    }

    @Test
    public void getNameTest() {
        KlondikePlayer kp = new KlondikePlayer("KH", 100.0);
        String expectedName = "KH";
        String actualName = kp.getName();
        Assert.assertEquals(expectedName, actualName);
    }


    @Test
    public void getWalletTest() {
        KlondikePlayer kp = new KlondikePlayer("KH", 100.0);
        Double expected = 100.0;
        Double actual = kp.getWallet();
        Assert.assertEquals(expected, actual);
    }

}
