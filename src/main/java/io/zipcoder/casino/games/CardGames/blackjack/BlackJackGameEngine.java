package io.zipcoder.casino.games.CardGames.blackjack;

//
//
//public class BlackJackGameEngine {
//    private User user;
//    private BlackJackGame blackJackGame;
//    private BlackJackPlayer blackJackPlayer;
//    private BlackJackDealer blackJackDealer;
//    private DeckOfCards deck;
//
//    public BlackJackGameEngine(User user) {
//        this.user = user;
//        this.blackJackPlayer = new BlackJackPlayer(user);
//        this.blackJackDealer = new BlackJackDealer();
//        this.deck = new DeckOfCards();
//        displayBlackJackMenu();
//    }
//
//    //BlackJack Menu & Choices//
//    public void displayBlackJackMenu() {
//        menuChoice(Console.getIntegerInput( " ___________________________\r\n|\tWelcome to BlackJack!\t|\r\n|\t\t\t\t\t\t\t|\r\n|\t\t1. Deal Hand\t\t|\r\n|\t\t2. View Rules\t\t|\r\n|\t\t3. Leave Table\t\t|\r\n|___________________________|"));
//     //string escape
//    }
//
//    private void menuChoice(Integer choice) {
//        switch(choice){
//            case 1:
//                runGame();
//                break;
//            case 2:
//                BlackJackGame.showGameRules();
//                displayBlackJackMenu();
//            case 3:
//                leaveTable();
//                break;
//            default:
//                Console.println("Invalid input, try again!");
//        }
//    }
//
//    //Begin Game//
//    public void runGame() {
//        blackJackGame = new BlackJackGame(deck.createDeckOfCards());
//        gameOn();
//    }
//
//    private void gameOn() {
//        dealHands();
//        while(!checkWinner(blackJackPlayer, blackJackDealer)){
//            userCardPrompt(blackJackPlayer);
//        }
//    }
//    //Run Game Methods//
//
//    private void dealHands() {
//        for(int i = 0; i < 2; i++){
//            //dealing cards to all currentplayers
//            blackJackPlayer.getCard(blackJackGame.DealHands());
//        }
//    }
//    private boolean checkWinner(BlackJackPlayer user, BlackJackDealer ai) {
//        if(user.get21() == 21){
//            Console.println("Congratulations! You won!");
//            return true;
//        }
//        else if(ai.get21() == 21){
//            Console.println("You lose! Play again?");
//            return true;
//        }
////        else if(user.get21() > 21){
////            Console.println("Bust! You lose!\nPlay again?");
////            return true;
////        }
////        else if(user.get21() > ai.get21()){
////            Console.println("You won! Play again?");
////            return true;
////        }
////        else if(user.get21() < ai.get21()){
////            Console.println("You lose! Play again?");
////            return true;
////        }
//        return false;
//    }
//
//    private void leaveTable() { new Casino(user.getName(), user.getWallet()); }
//    private void userCardPrompt(BlackJackPlayer user) {
////        Console.getIntegerInput(user);
//    }
//
//    public Integer chooseAction() {
//        return null;
//    }
//    public Boolean getWinner() {
//        return null;
//    }
//
//    public void runBlackJackGame() {
//
//    }

//
//}


import io.zipcoder.casino.userandplayer.User;

public class BlackJackGameEngine {
    private BlackJackDealer blackJackDealer;
    private BlackJackPlayer blackJackPlayer;

    public BlackJackGameEngine(User user) {
        this.blackJackDealer = new BlackJackDealer();
        this.blackJackPlayer = new BlackJackPlayer(user);
        runGame();
    }

    public void runGame() {
        BlackJackGame game = new BlackJackGame(blackJackPlayer, blackJackDealer);
        game.run();
    }
}

