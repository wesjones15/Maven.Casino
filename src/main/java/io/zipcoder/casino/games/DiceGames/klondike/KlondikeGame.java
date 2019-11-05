package io.zipcoder.casino.games.DiceGames.klondike;


import io.zipcoder.casino.sweetasscasinotools.Dice;

public class KlondikeGame {

    private int numOfDie;
    private int numOfFaces;
    private Dice dice;
    private Dice[] diceValues;

    public KlondikeGame() {
        this.numOfDie = 5;
        this.numOfFaces = 6;
        this.dice = new Dice(numOfDie, numOfFaces);
    }

    public Dice[] roll() {
        return null;
    }

    public Double getBet() {
        return null;
    }

    public void checkDiePatterns() {
    }
    //pulling methods from gambling game and game interface

}
