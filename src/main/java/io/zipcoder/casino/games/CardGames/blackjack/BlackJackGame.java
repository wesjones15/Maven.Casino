package io.zipcoder.casino.games.CardGames.blackjack;


import io.zipcoder.casino.sweetasscasinotools.Card;
import io.zipcoder.casino.sweetasscasinotools.DeckOfCards;

import java.util.Stack;

public class BlackJackGame {
    private Stack<Card> deck;
    private Card card;


    public BlackJackGame(Stack<Card> deck) {this.deck = deck;
    }
    public Card DealHands(){
        if(deck.size() == 0){
            System.out.println("Deck Empty!");
        }
        return deck.pop();
    }

    public static void showGameRules() {
    }

    public Stack<Card> getDeck() {
        return deck;
    }

    public void shuffle() {

    }

    public String playerMove() {
        return null;
    }

    public String dealerMove() {
        return null;
    }

    public Boolean getWinner() {
        return null;
    }

    public Boolean getLoser() {
        return null;
    }



    //pulling methods from gambling game and game interface
}
