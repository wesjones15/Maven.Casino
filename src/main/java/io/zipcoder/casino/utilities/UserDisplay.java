package io.zipcoder.casino.utilities;

import io.zipcoder.casino.games.CardGames.blackjack.BlackJackGameEngine;
import io.zipcoder.casino.games.CardGames.gofish.GoFishGameEngine;
import io.zipcoder.casino.games.DiceGames.craps.CrapsGameEngine;
import io.zipcoder.casino.games.DiceGames.klondike.KlondikeGameEngine;
import io.zipcoder.casino.userandplayer.User;




public class UserDisplay {

    public static Integer displayOptions(String... options) {
        for (int i = 0; i < options.length; i++) {
            Console.println("%s : %s", i+1, options[i]);
        }
        return Console.getIntegerInput("Select your action: ");
    }


    public static User createCasinoUser() {
        String name ;
        Integer age;
        Double wallet;
        name = Console.getStringInput("Name: ");
        age = validateAge();
        wallet = validateWallet();
        return  new User(name, 2, age, wallet);
    }
    //This doesn't make sense. Well, maybe if you have a birthday while you're stuck in this loop.
    public static Integer validateAge() {
        Integer age;
        do {
            age = Console.getIntegerInput("Age(minimum age 18): ");
        } while (age < 18);
        return age;
    }

    public static Double validateWallet(){
        Double wallet;
        do {
            wallet = Console.getDoubleInput("Monies in your wallet: ");
        }while(wallet < 0);
        return wallet;
    }

    public  static String chooseGame(int action, User user) {
        String stringForTesting = " ";
        switch(action) {
            case 1:
                // gofish
                stringForTesting = "gofish";
                GoFishGameEngine gfge = new GoFishGameEngine(user);
                gfge.displayGoFishMenu();
                break;
            case 2:
                // black jack
                BlackJackGameEngine bjGame = new BlackJackGameEngine(user);
                stringForTesting = "black jack";
                break;
            case 3:
                // klondike
                KlondikeGameEngine newKlondikeGame = new KlondikeGameEngine(user);
                newKlondikeGame.run();
                stringForTesting = "klondike";
                break;
            case 4:
                // craps
                stringForTesting = "craps";
                CrapsGameEngine cge = new CrapsGameEngine(user);
                cge.run();
                break;
            case 5:
                stringForTesting = "Leaving";
                Console.println("Thank you!, Come again");
                Console.exit();
            default:
                stringForTesting = "default";
                break;
        }
        return stringForTesting;
    }
}
