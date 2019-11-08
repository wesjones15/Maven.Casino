package io.zipcoder.casino.games.CardGames.blackjack;


import io.zipcoder.casino.games.CardGames.Hand;
import io.zipcoder.casino.sweetasscasinotools.Card;
import io.zipcoder.casino.userandplayer.User;

public class BlackJackPlayer{
    private String name;
    private Double wallet;
    private Double betAmount;
    private Hand hand;

    // implementation of adapter pattern
    // have any questions? Read a fucking book
    public BlackJackPlayer(User user) {
        this(user.getName(), user.getWallet());
    }

    public BlackJackPlayer(String name, Double wallet) {
        this.name = name;
        this.wallet = wallet;
        this.hand = new Hand();
    }

    public Boolean placeBet(Double betAmount) {
        Boolean success = false;
        if (verifyValidBetAmount(betAmount)) {
            decrementWallet(betAmount);
            success = true;
        }
        return success;
    }

    public void setBetAmount(Double betAmount) {
        this.betAmount = betAmount;
    }

    public Double getBetAmount(){
        return this.betAmount;
    }

    public Boolean verifyValidBetAmount(Double betAmount) {
        return (betAmount <= this.wallet && betAmount >= 0);
    }

    public void incrementWallet(Double amount) {
        this.wallet += amount;
    }

    public void decrementWallet(Double amount) {
        this.wallet -= amount;
    }

    public String getName() {
        return this.name;
    }

    public Double getWallet() {
        return this.wallet;
    }

    public Hand getHand() {
        return hand;
    }

    public void acceptCard(Card card) {
        hand.add(card);
    }

}