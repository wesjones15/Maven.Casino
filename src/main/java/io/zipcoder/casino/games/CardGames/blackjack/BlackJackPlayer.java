package io.zipcoder.casino.games.CardGames.blackjack;
//import io.zipcoder.casino.games.CardGames.CardPlayer;
import io.zipcoder.casino.games.CardGames.Hand;
import io.zipcoder.casino.sweetasscasinotools.Card;

public class BlackJackPlayer{
    private String name;
    private Double wallet;
    private Double betAmount;
    private Hand hand;

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
        // remove betAmount from wallet
    }

    public Double getBetAmount() {
        return this.betAmount;
    }

    public void setBetAmount(Double betAmount) {
        this.betAmount = betAmount;
    }

    public Boolean verifyValidBetAmount(Double betAmount) {
        return (betAmount <= this.wallet);
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

    public void setName(String name) {
        this.name = name;
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