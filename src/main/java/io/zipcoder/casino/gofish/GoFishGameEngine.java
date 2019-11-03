package io.zipcoder.casino.gofish;

import io.zipcoder.casino.User;
import io.zipcoder.casino.utilities.Console;

import java.sql.SQLOutput;

public class GoFishGameEngine {
    private User user;
    private GoFishDealer goFishDealer;
    private GoFishPlayer goFishPlayer;
    private GoFishGame goFishGame;

    public GoFishGameEngine(User user){
        this.user = user;
    }

    public void displayGoFishMenu(){
        System.out.println();

    }
    public Integer chooseAction(){

        return null;
    }
    public void getWinner(/*Player fourOfAKind, Dealer fourOfAKind*/) {

    }

}
