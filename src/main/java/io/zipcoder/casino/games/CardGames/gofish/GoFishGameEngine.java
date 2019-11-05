package io.zipcoder.casino.games.CardGames.gofish;

import io.zipcoder.casino.sweetasscasinotools.DeckOfCards;
import io.zipcoder.casino.userandplayer.User;
import io.zipcoder.casino.utilities.Casino;
import io.zipcoder.casino.utilities.Console;



public class GoFishGameEngine {
    private User user;
    private GoFishDealer goFishDealer;
    private GoFishPlayer goFishPlayer;
    private GoFishGame goFishGame;
    private DeckOfCards deck;

    public GoFishGameEngine(User user){
        this.user = user;
        this.goFishPlayer = new GoFishPlayer(user);
        this.goFishDealer = new GoFishDealer();
        this.deck = new DeckOfCards();
        displayGoFishMenu();
    }
    //Go Fish Menu // Actions//
    //////////////////////////
    public void displayGoFishMenu(){
        menuChoice(Console.getIntegerInput("Welcome to GoFish!\n" +
                "1 : Deal Hand\n" +
                "2 : Leave Table"));
    }
    public void menuChoice(Integer choice){
        switch(choice){
            case 1 :
                runGame();
                break;
            case 2 :
                leaveTable();
                break;
            default :
                Console.println("Invalid response!");
        }
    }
    //START OF GAME//
    ////////////////
    public void runGame(){
        goFishGame = new GoFishGame(deck.createDeckOfCards());
        gameOn();
    }
    public void gameOn(){
        dealHands();
        while(!checkWinner(goFishPlayer, goFishDealer)) {
            userCardPrompt(goFishPlayer);



        }
    }
    ////RUN GAME METHODS///
    ///////////////////////

    public void dealHands(){
        for(int i = 0; i < 7; i++){
            //dealing cards to player and dealer
            goFishPlayer.pickUpHand(goFishGame.DealHands());
            goFishDealer.pickUpHand(goFishGame.DealHands());

        }
    }



    public boolean checkWinner(GoFishPlayer user, GoFishDealer ai) {
        if(user.getFourOfAKind() == 4){
            Console.println("Congratulations your the winner!");
            return true;
        }
        else if(ai.getFourOfAKind() == 4){
            Console.println("You Lose! Play again");
            return true;
        }
        return false;



    }
    public void leaveTable(){
        new Casino(user.getName(), user.getWallet());
    }
    public void userCardPrompt(GoFishPlayer user){
        Console.getIntegerInput(user.showHand());
    }

}
