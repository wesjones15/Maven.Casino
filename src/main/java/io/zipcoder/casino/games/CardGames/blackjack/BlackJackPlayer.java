package io.zipcoder.casino.games.CardGames.blackjack;


//public class BlackJackPlayer {

//    private ArrayList<Card> hand;
//    private Double wallet;
//    private int get21 = 0;
//
//
//    public BlackJackPlayer(User user) {
//        this.hand = new ArrayList<Card>();
//        this.wallet = user.getWallet();
//    }
//
//    public Card getCard(Object o){
//        return null;
//    }
//
//
//    public void hit(Card newCard) {
//        this.hand.add(newCard);
//    }
//
//    public int get21() { return this.get21;
//    }
//
//
//    //while Hand < 21; return boolean
//    //hit() || stay()
//    //if hand == Dealer (Lose)
////if hand > Dealer &&  hand < 21 (Win)
////if hand < dealer (lose)
////if  hand > 21
////    bust(); return lose;

import io.zipcoder.casino.games.CardGames.CardPlayer;
import io.zipcoder.casino.userandplayer.User;

public class BlackJackPlayer extends CardPlayer {
    private boolean isFinished;
    private Double bet;

    public BlackJackPlayer(User profile) {
        super(profile);
    }

    public void loseBet() {
        Double currentBalance = super.user.getWallet();
        super.user.setWallet(currentBalance - bet);
    }

    public void winBet() {
        Double currentBalance = super.user.getWallet();
        super.user.setWallet(currentBalance + bet);
    }

    public Double getBet() {
        return bet;
    }

    public void setBet(Double bet) {
        this.bet = bet;
    }

    public Double getBalance() {
        return user.getWallet();
    }
}