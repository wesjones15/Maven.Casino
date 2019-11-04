package io.zipcoder.casino.games.CardGames.gofish;

import io.zipcoder.casino.userandplayer.User;

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
