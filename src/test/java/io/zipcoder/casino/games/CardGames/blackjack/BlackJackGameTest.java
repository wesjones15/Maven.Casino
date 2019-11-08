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

//    @Test
//    public void testChooseGameOption(){
//        //given
//        Integer expected = 1;
//        String option = "Set Bet";
//        BlackJackPlayer player = new BlackJackPlayer("Bob", 100.0);
//        BlackJackGame blackJackGame = new BlackJackGame(player);
//        //when
//        Integer actual = blackJackGame.chooseGameOption(option);
//        //TODO google how to insert a value into the system.in (console) & junit
//        //then
//        Assert.assertEquals(actual, expected);
//
//    }
//    @Test
//    public void menuChoiceTest1(){
//        BlackJackGame blackJackGame = new BlackJackGame(new User("Kai", 1, 554, 58.78));
//        String input = "DEAL";
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//
//        Assert.assertEquals("DEAL", blackJackGame.menuChoice(String choice));
//    }
}
