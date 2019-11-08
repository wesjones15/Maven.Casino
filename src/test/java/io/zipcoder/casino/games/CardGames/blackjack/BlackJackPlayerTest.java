package io.zipcoder.casino.games.CardGames.blackjack;

import io.zipcoder.casino.games.CardGames.Hand;
import io.zipcoder.casino.sweetasscasinotools.Card;
import org.junit.Assert;
import org.junit.Test;

public class BlackJackPlayerTest {

    @Test
    public void testDecrement1() {
        testDecrement(99.0, 99.5);
    }



    @Test
    public void testDecrement2() {
        testDecrement(999.0, 99.5);
    }



    @Test
    public void testDecrement3() {
        testDecrement(959.0, 99.5);
    }



    @Test
    public void testDecrement4() {
        testDecrement(929.0, 99.5);
    }



    private void testDecrement(Double preDecrementWalletAmount, Double amountToDecrementBy) {
        // given
        BlackJackPlayer player = new BlackJackPlayer(null, preDecrementWalletAmount);
        Double expected = preDecrementWalletAmount - amountToDecrementBy;

        // when
        player.decrementWallet(amountToDecrementBy);
        Double actual = player.getWallet();

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIncrement1() {
        testIncrement(999.0, 10001.0);
    }

    @Test
    public void testIncrement2() {
        testIncrement(100.0, 10001.0);
    }

    @Test
    public void testIncrement3() {
        testIncrement(9.0, 1.0);
    }

    @Test
    public void testIncrement4() {
        testIncrement(3.0, 12.0);
    }

    private void testIncrement(Double preIncrementWalletAmount, Double amountToIncrementBy) {
        // given
        BlackJackPlayer player = new BlackJackPlayer(null, preIncrementWalletAmount);
        Double expected = preIncrementWalletAmount + amountToIncrementBy;

        // when
        player.incrementWallet(amountToIncrementBy);
        Double actual = player.getWallet();

        // then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testPlaceBet1() {
        // given
        testPlaceBet(9999999.000, 999.00);
    }


    @Test
    public void testPlaceBet2() {
        // given
        testPlaceBet(9999999.000, 99999.00);
    }


    @Test
    public void testPlaceBet3() {
        // given
        testPlaceBet(99999.000, 9999.00);
    }


    private void testPlaceBet(Double preBetWalletAmount, Double betAmount) {
        // given
        BlackJackPlayer player = new BlackJackPlayer(null, preBetWalletAmount);
        Double expectedPostBetWalletAmount = preBetWalletAmount - betAmount;

        // when
        player.placeBet(betAmount);
        Double actualPostBetWalletAmount = player.getWallet();

        // then
        Assert.assertEquals(expectedPostBetWalletAmount, actualPostBetWalletAmount);
    }


    @Test
    public void testAcceptCard1() {
        testAcceptCard(new Card(null, null, null));
    }

    @Test
    public void testAcceptCard2() {
        testAcceptCard(new Card("Hearts", "King", 10));
    }

    @Test
    public void testAcceptCard3() {
        testAcceptCard(new Card("Diamonds", "King", 10));
    }


    private void testAcceptCard(Card cardToBeAccepted) {
        BlackJackPlayer player = new BlackJackPlayer(null, null);
        Hand playerHand = player.getHand();
        String preDealHandState = playerHand.toString();

        // when
        player.acceptCard(cardToBeAccepted);
        String postDealHandState = playerHand.toString();

        // then
        Assert.assertNotEquals(preDealHandState, postDealHandState);
    }
}
