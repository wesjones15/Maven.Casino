package io.zipcoder.casino.gofish;

import io.zipcoder.casino.User;
import io.zipcoder.casino.utilities.Console;


public class GoFishGameEngine {
    private User user;
    private GoFishDealer goFishDealer;
    private GoFishPlayer goFishPlayer;
    //private GoFishGame goFishGame = new GoFishGame();
    private Console console = new Console(System.in , System.out);

    public GoFishGameEngine(User user){
        this.user = user;
        displayGoFishMenu();
    }

    public void displayGoFishMenu(){
        menuChoice(console.getIntegerInput("Welcome to GoFish!\n" +
                "1 - Deal Hand\n" +
                "2 - Leave Table"));

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
                console.println("Invalid response!");

        }
    }
    public void runGame(){

    }
    public Double leaveTable(){
        return user.getWallet();
    }

    public void checkWinner(GoFishPlayer user, GoFishDealer ai) {
        if(user.getFourOfAKind() == 4)
            console.println("Congratulations your the winner!");
        else if(ai.getFourOfAKind() == 4);
            console.println("You Lose! Play again");

    }

}
