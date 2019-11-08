package io.zipcoder.casino.sweetasscasinotools;

public class Dice {
    private final Integer numberOfFaces;
    private final Die[] dice;

    public Dice(Integer numberOfDice, Integer numberOfFaces) {
        this.numberOfFaces = numberOfFaces;
        this.dice = new Die[numberOfDice];
        for (int currentIndex = 0; currentIndex < dice.length; currentIndex++) {
            dice[currentIndex] = new Die(numberOfFaces);
        }
    }

    public Integer rollAndSum() {
        Integer total = 0;
        for (int currentIndex = 0; currentIndex < dice.length; currentIndex++) {
            Die die = dice[currentIndex];
            die.roll();
            Integer valueRolled = die.getCurrentFacesValue();
            total += valueRolled;
        }
        return total;
    }

    public Die getDie(Integer index) {
        return this.dice[index];
    }

    public Die[] getDieArray() {
        return this.dice;
    }


}
