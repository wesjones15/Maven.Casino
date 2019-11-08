package io.zipcoder.casino.games.CardGames.blackjack;

import io.zipcoder.casino.sweetasscasinotools.Card;
import org.junit.Assert;
import org.junit.Test;

public class BlackJackGameTest {
    @Test
    public void testCheckDealerHand1() {
        testCheckDealerHand(20, true);
    }

    @Test
    public void testCheckDealerHand2() {
        testCheckDealerHand(17, true);
    }

    @Test
    public void testCheckDealerHand3() {
        testCheckDealerHand(15, false);
    }

    private void testCheckDealerHand(Integer cardValue, Boolean expected) {
        // given
        BlackJackDealer dealer = new BlackJackDealer();
        BlackJackGame game = new BlackJackGame(dealer, null, null);
        dealer.acceptCard(new Card(null,null, cardValue));

        // when
        boolean actual = game.checkDealerHand();

        // then
        Assert.assertEquals(expected, actual);
    }
}
