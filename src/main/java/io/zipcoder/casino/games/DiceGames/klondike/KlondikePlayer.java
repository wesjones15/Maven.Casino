package io.zipcoder.casino.games.DiceGames.klondike;

public class KlondikePlayer {
    //private User user;
    private String name;
    private Double wallet;
    private Double betAmount;

   /* public KlondikePlayer(User user) {
        this.user = user;
    }*/

    public KlondikePlayer(String name, Double wallet) {
        this.name = name;
        this.wallet = wallet;
    }

    public Boolean placeBet(Double betAmount) {
        Boolean success = false;
        if (verifyValidBetAmount(betAmount)) {
            decrementWallet(betAmount);
            success = true;
        }
        return success;
    }
    public Boolean verifyValidBetAmount(Double betAmount) {
        return (betAmount <= this.wallet) && (betAmount > 0);
    }
    public void incrementWallet(Double amount) {
        this.wallet += amount;
    }
    public void decrementWallet(Double amount) {
        this.wallet -= amount;
    }
    public Double getBetAmount() {
        return this.betAmount;
    }

    public void setBetAmount(Double betAmount) {
        this.betAmount = betAmount;
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

    /*public void leaveGame() {
        new Casino(user.getName(), user.getWallet());
    }*/

}
