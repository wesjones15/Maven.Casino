package io.zipcoder.casino.games.CardGames.blackjack;


import io.zipcoder.casino.interfaces.Game;
import io.zipcoder.casino.sweetasscasinotools.Card;
import io.zipcoder.casino.userandplayer.User;

import java.util.ArrayList;

public class BlackJackPlayer {

    private ArrayList<Card> hand;
    private Double wallet;
    private int get21 = 0;


    public BlackJackPlayer(User user) {
        this.hand = new ArrayList<Card>();
        this.wallet = user.getWallet();
    }

    public Card getCard(Object o){
        return null;
    }


    public void hit(Card newCard) {
        this.hand.add(newCard);
    }

    public int get21() { return this.get21;
    }


    //while Hand < 21; return boolean
    //hit() || stay()
    //if hand == Dealer (Lose)
//if hand > Dealer &&  hand < 21 (Win)
//if hand < dealer (lose)
//if  hand > 21
//    bust(); return lose;

}
