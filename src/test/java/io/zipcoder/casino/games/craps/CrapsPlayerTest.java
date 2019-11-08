package io.zipcoder.casino.games.craps;

import io.zipcoder.casino.games.DiceGames.craps.CrapsPlayer;
import org.junit.Assert;
import org.junit.Test;


public class CrapsPlayerTest {
    @Test
    public void testConstructor() {
        String name = "Wes";
        Double wallet = 444.44;
        CrapsPlayer player = new CrapsPlayer(name, wallet);
        Assert.assertEquals(name, player.getName());
        Assert.assertEquals(wallet, player.getWallet(), 2);
    }

    @Test
    public void testPlaceBet1() {
        String name = "Wes";
        Double wallet = 444.44;
        CrapsPlayer player = new CrapsPlayer(name, wallet);
        Boolean actual = player.placeBet(25.5);
        Assert.assertTrue(actual);
    }

    @Test
    public void testPlaceBet2() {
        String name = "Wes";
        Double wallet = 44.44;
        CrapsPlayer player = new CrapsPlayer(name, wallet);
        Boolean actual = player.placeBet(-46.8);
        Assert.assertFalse(actual);
    }

    @Test
    public void testPlaceBet3() {
        String name = "Wes";
        Double wallet = 4.44;
        CrapsPlayer player = new CrapsPlayer(name, wallet);
        Boolean actual = player.placeBet(25.5);
        Assert.assertFalse(actual);
    }

    @Test
    public void testSetBetAmount() {
        String name = "Wes";
        Double wallet = 4.44;
        CrapsPlayer player = new CrapsPlayer(name, wallet);
        Double betAmount = 25.33;
        player.setBetAmount(betAmount);
        Double actual = player.getBetAmount();
        Assert.assertEquals(betAmount, actual);
    }

    @Test
    public void testVerifyValidBetAmount1() {
        String name = "Wes";
        Double wallet = 44.44;
        CrapsPlayer player = new CrapsPlayer(name, wallet);
        Double betAmount = 25.33;
        Assert.assertTrue(player.verifyValidBetAmount(betAmount));
    }

    @Test
    public void testVerifyValidBetAmount2() {
        String name = "Wes";
        Double wallet = 2.44;
        CrapsPlayer player = new CrapsPlayer(name, wallet);
        Double betAmount = 25.33;
        Assert.assertFalse(player.verifyValidBetAmount(betAmount));
    }

    @Test
    public void testVerifyValidBetAmount3() {
        String name = "Wes";
        Double wallet = 44.44;
        CrapsPlayer player = new CrapsPlayer(name, wallet);
        Double betAmount = -25.33;
        Assert.assertFalse(player.verifyValidBetAmount(betAmount));
    }

    @Test
    public void testIncrementWallet1() {
        String name = "Wes";
        Double wallet = 44.44;
        CrapsPlayer player = new CrapsPlayer(name, wallet);
        player.incrementWallet(22.22);
        Assert.assertEquals(player.getWallet(), 66.66, 2);
    }

    @Test
    public void testIncrementWallet2() {
        String name = "Wes";
        Double wallet = 44.44;
        CrapsPlayer player = new CrapsPlayer(name, wallet);
        player.incrementWallet(22.22);
        Assert.assertNotEquals(player.getWallet(), wallet);
    }

    @Test
    public void testDecrementWallet1() {
        String name = "Wes";
        Double wallet = 44.44;
        CrapsPlayer player = new CrapsPlayer(name, wallet);
        player.decrementWallet(22.22);
        Assert.assertEquals(player.getWallet(), 22.22, 2);
    }

    @Test
    public void testDecrementWallet2() {
        String name = "Wes";
        Double wallet = 44.44;
        CrapsPlayer player = new CrapsPlayer(name, wallet);
        player.decrementWallet(22.22);
        Assert.assertNotEquals(player.getWallet(), wallet);
    }

    @Test
    public void testSetName() {
        String name = "Wes";
        Double wallet = 4.44;
        CrapsPlayer player = new CrapsPlayer(name, wallet);
        String expected = "Namey";
        player.setName(expected);
        String actual = player.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetWallet() {
        String name = "Wes";
        Double expected = 4.44;
        CrapsPlayer player = new CrapsPlayer(name, expected);
        Double actual = player.getWallet();
        Assert.assertEquals(expected, actual);
    }
}
