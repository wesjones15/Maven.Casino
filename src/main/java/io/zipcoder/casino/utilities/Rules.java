package io.zipcoder.casino.utilities;

public class Rules {

    public static final String craps = "---==--===--===--==| CRAPS RULES |==--===--===--==---\nOn the first round, you win if you roll a 7 or 12\nand you lose if you roll a 2, 3, or 12" +
            "\nIf you roll something else, that number becomes\nyour win target and your losing roll becomes 7" +
            "\nYou can wager your money on whether you win the round\n" +
            "---==--===--===--========-=-========--===--===--==---\n";

    public static final String blackjack = "\n\n\n|---==--===--==--===--==--===| BLACKJACK RULES |===--==--===--==--===--==---|\n" +
            "|     __________________________________________________________________    |\n" +
            "|  Each player starts with 2 cards. " +
            "Each card holds a value between 1 - 10. |\n" +
            "|\t\t\t\t\t[J], [Q], [K] cards hold a value of 10.\t\t\t\t\t|\n" +
            "|\t\t\tCard values are added together to set an overall total.\t\t\t|\n" +
            "|\tTo [HIT] is to ask for another card to increase your overall total.\t\t|\n" +
            "|\t\t\tTo [STAND] is to hold your total and end your turn.\t\t\t\t|\n" +
            "|\t\t\tIf your total is over 21, you BUST and the dealer wins.\t\t\t|\n" +
            "|\t\t\t\t\tIf you and the dealer tie, dealer wins.\t\t\t\t\t|\n" +
            "|\t\tTo win, you must have a higher overall score than the dealer.\t\t|\n" +
            "|---===--==--===--==--===--==--===--==--===--==--===--==-===--==--===--==---|\n\n\n";

    public static final String klondike = "In Klondike Dice players need to roll better combination than banker to win.\n" +
            "The banker rolls first and the player rolls and tries to beat banker’s combination.\n" +
            "\n" +
            "Combinations are ordered in sequence from highest to lowest as follows\n" +
            "\n" +
            "Five of a kind – All 5 dice showing the same number\n" +
            "Four of a kind – 4 dice showing the same number\n" +
            "Full house – 3 dice with one number and 2 dice showing another number\n" +
            "Three of a kind – 4 dice showing the same number\n" +
            "Two pairs – 2 dice pairs showing same number\n" +
            "One pair – 2 dice showing same number\n" +
            "A die not used in any combination is ignored. If players roll same combination as the banker, then they lose.\n" +
            "They must roll a better combination to win. In case no one rolls a combination including the banker, then banker wins.";

    public static final String goFish = "--> Go Fish Rules <--\n" +
            "   - Ask opponent for a card from the ones in your hand.\n" +
            "   - if opponent has cards, He must pass all the cards requested\n" +
            "   - If not, Draw a Card\n" +
            "   - Repeat\n" +
            "   - Game ends when a player reaches four stacks of four of a kind or \n" +
            "     there are no more cards in the deck\n" +
            "   - HAVE FUN!!\n\n";
}
