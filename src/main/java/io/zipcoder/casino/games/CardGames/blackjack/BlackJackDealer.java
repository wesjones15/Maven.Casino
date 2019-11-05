package io.zipcoder.casino.games.CardGames.blackjack;


import io.zipcoder.casino.sweetasscasinotools.Card;
import io.zipcoder.casino.sweetasscasinotools.DeckOfCards;
import io.zipcoder.casino.utilities.Console;
public class BlackJackDealer{
    private Card[] hand;
    private Integer blackJack = 21;
    private Integer card;

    public BlackJackDealer hit() {
        if(card < 16) {
        }return null;
    }


    public final Integer deal(DeckOfCards player, int numberOfCards) {
        Console.println("The dealer hands a card to [ %s ]");
        for (int i = 0; i < numberOfCards; i++) {
        }
        return null;
    }

    private void getHandTotal() {
    }
}