package io.zipcoder.casino.games.CardGames.blackjack;


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