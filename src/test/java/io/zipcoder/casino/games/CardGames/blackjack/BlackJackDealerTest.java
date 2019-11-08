package io.zipcoder.casino.games.CardGames.blackjack;

import io.zipcoder.casino.games.CardGames.Hand;
import io.zipcoder.casino.sweetasscasinotools.Card;
import org.junit.Assert;
import org.junit.Test;

public class BlackJackDealerTest {
    @Test
    public void testDeal1() {
        testDeal(new Card(null, null, null));
    }

    @Test
    public void testDeal2() {
        testDeal(new Card("Hearts", "1", 1));
    }

    @Test
    public void testDeal3() {
        testDeal(new Card("Diamonds", "3", 3));
    }

    @Test
    public void testDeal4() {
        testDeal(new Card("Hearts", "5", 5));
    }

    private void testDeal(Card card) {
        // given
        BlackJackDealer dealer = new BlackJackDealer();
        BlackJackPlayer player = new BlackJackPlayer(null, null);

        // when
        dealer.deal(player, card);
        Hand hand = player.getHand();

        // then
        Assert.assertTrue(hand.contains(card));
    }
}
