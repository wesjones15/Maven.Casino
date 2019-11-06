package io.zipcoder.casino.games.CardGames.gofish;

import io.zipcoder.casino.sweetasscasinotools.Card;
import io.zipcoder.casino.sweetasscasinotools.DeckOfCards;
import io.zipcoder.casino.userandplayer.User;

import io.zipcoder.casino.utilities.Casino;
import io.zipcoder.casino.utilities.Console;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class GoFishGameEngine {
    private User user;
    private GoFishPlayer goFishDealer;
    private GoFishPlayer goFishPlayer;
    private DeckOfCards deck = new DeckOfCards();
    private GoFishGame goFishGame;

    public GoFishGameEngine(User user){
        this.user = user;
        this.goFishPlayer = new GoFishPlayer(user);
        this.goFishDealer = new GoFishPlayer();
        this.goFishGame = new GoFishGame(deck.createDeckOfCards());
        displayGoFishMenu();
    }
    //Go Fish Menu // Actions//
    //////////////////////////
    private void displayGoFishMenu(){
        menuChoice(Console.getIntegerInput("Welcome to GoFish!\n" +
                "1 : Go Fish rules\n" +
                "2 : Deal Hand\n" +
                "3 : Leave Table"));
    }
    private void menuChoice(Integer choice){
        switch(choice){
            case 1 :
                Console.println(goFishGame.gameRules());
                displayGoFishMenu();
                break;
            case 2 :
                gameOn();
                break;
            case 3 :
                leaveTable();
                break;
            default :
                Console.println("Invalid response!");
        }
    }
    //START OF GAME//
    ////////////////
    public void gameOn(){
        dealHands();
        while(!checkWinner(goFishPlayer, goFishDealer)) {
            userTurn(goFishPlayer);

        }
    }
    ////RUN GAME METHODS///
    ///////////////////////

    private void dealHands(){
        for(int i = 0; i < 7; i++){
            //dealing cards to player and dealer
            goFishPlayer.pickUpHand(goFishGame.DealHands());
            goFishDealer.pickUpHand(goFishGame.DealHands());

        }
    }
    private boolean checkWinner(GoFishPlayer user, GoFishPlayer ai) {
        if(user.getFourOfAKind() == 4){
            Console.println("Congratulations your the winner!\n" +
                    "Reward : $50.0");
            this.user.setWallet(this.user.getWallet() + 50.0);
            return true;
        }
        else if(ai.getFourOfAKind() == 4){
            Console.println("You Lose! Play again");
            return true;
        }
        return false;
    }

    ///////USERS TURN
    private void userTurn(GoFishPlayer user){
        passOrDraw(Console.getIntegerInput(user.showHand()));
    }
    private void passOrDraw(Integer cardIndex) {

        Card askingCard = goFishPlayer.getCard(cardIndex);

        if (goFishGame.checkHand(goFishDealer.getHand(), askingCard)) {
            goFishPlayer.receiveCards(goFishDealer.passCard(askingCard));
            userTurn(goFishPlayer);
        } else {
            goFishPlayer.draw(goFishGame.getDeck());
            ///Starts dealers turn
            dealerTurn();

        }
    }

    //////DEALERS TURN
    private void dealerTurn(){
        Card card = askedCard();
        if(goFishGame.checkHand(goFishPlayer.getHand(), card)){
            goFishDealer.receiveCards(goFishPlayer.passCard(card));
            dealerTurn();
        }else{
            goFishDealer.draw(goFishGame.getDeck());
        }
    }
    private Card askedCard(){
        int handSize = goFishDealer.getHand().size();
        int randomCard = (int)(Math.random() * ((handSize - 1) + 1)) + 1;
        return goFishDealer.getCard(randomCard);

    }
    ///LEAVE GOFISH////
    private void leaveTable(){
        new Casino(user.getName(), user.getWallet());
    }

}
