package io.zipcoder.casino.games.CardGames.blackjack;


import io.zipcoder.casino.sweetasscasinotools.Card;
import io.zipcoder.casino.userandplayer.User;

import java.util.ArrayList;

public class BlackJackPlayer {
    private ArrayList<Card> hand;
    private Double wallet;


    public BlackJackPlayer(ArrayList<Card> hand, User user) {

        this.hand = hand;
        this.wallet = user.getWallet();
    }

    public Double getWallet() {
        return wallet;
    }

    public void setWallet(Double wallet) {
        this.wallet = wallet;
    }
    public void setBet(Integer amount){
    }

    public Boolean getHand(BlackJackDealer passCards, BlackJackPlayer getsCards) {
        return null;
    }
    public Boolean checkHand(Card requested) {
        for (Card each : hand) {
            if (requested == each) {
                return true;
            }
        }return false;
    }
    public void hit(Card getCard){
    }
    public void stay(){
    }
    public void buss(){
    }

}

//if hand == Dealer (Lose)
//if hand > Dealer &&  hand < 21 (Win)
//if hand < dealer (lose)
//if  hand > 21
//    bust(); return lose;