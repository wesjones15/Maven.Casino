package io.zipcoder.casino.games.CardGames.blackjack;

import io.zipcoder.casino.sweetasscasinotools.Card;
import io.zipcoder.casino.sweetasscasinotools.DeckOfCards;
import io.zipcoder.casino.userandplayer.PlayerClass;

import java.util.ArrayList;

public class TempBlackJackGame {
    private PlayerClass player;
    public static DeckOfCards deck;
    private ArrayList<Card> playerHand;
    private ArrayList<Card> dealerHand;
    private Integer playerHandScore;
    private Integer dealerHandScore;

    public TempBlackJackGame() {
    }

    public void welcomeToBlackJack(){
        //intro message in BlackJackGameEngine
    }
}
