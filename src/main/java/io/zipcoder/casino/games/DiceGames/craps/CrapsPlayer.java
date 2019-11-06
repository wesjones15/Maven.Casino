package io.zipcoder.casino.games.DiceGames.craps;

public class CrapsPlayer {
    private String name;
    private Double wallet;
    private Double betAmount;

    public CrapsPlayer(String name, Double wallet) {
        this.name = name;
        this.wallet = wallet;
    }

//    public Integer rollDice() {
//        return null;
//    }

    public Boolean placeBet(Double betAmount) {
        Boolean success = false;
        if (verifyValidBetAmount(betAmount)) {
            decrementWallet(betAmount);
            success = true;
        }
        return success;
    }

    public Double getBetAmount() {
        return this.betAmount;
    }

    public void setBetAmount(Double betAmount) {
        this.betAmount = betAmount;
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

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Double getWallet() {
        return this.wallet;
    }
}
