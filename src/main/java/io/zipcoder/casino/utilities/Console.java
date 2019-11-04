package io.zipcoder.casino.utilities;


import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * You are advised against modifying this class.
 */
public final class Console {
    private static Scanner input;
    private static PrintStream output;

    public Console(InputStream in, PrintStream out) {
        this.input = new Scanner(in);
        this.output = out;
    }

    public static void print(String val, Object... args) {
        output.format(val, args);
    }

    public static void println(String val, Object... vals) {
        print(val + "\n", vals);
    }

    public  static String getStringInput(String prompt, Object... args) {
        println(prompt, args);
        return input.nextLine();
    }

    public  static Double getDoubleInput(String prompt, Object... args) {
        String stringInput = getStringInput(prompt, args);
        try {
            Double doubleInput = Double.parseDouble(stringInput);
            return doubleInput;
        } catch (NumberFormatException nfe) { // TODO - Eliminate recursive nature
            println("[ %s ] is an invalid user input!", stringInput);
            println("Try inputting a numeric value!");
            return getDoubleInput(prompt, args);
        }
    }

    public static Long getLongInput(String prompt, Object... args) {
        String stringInput = getStringInput(prompt, args);
        try {
            Long longInput = Long.parseLong(stringInput);
            return longInput;
        } catch (NumberFormatException nfe) { // TODO - Eliminate recursive nature
            println("[ %s ] is an invalid user input!", stringInput);
            println("Try inputting an integer value!");
            return getLongInput(prompt, args);
        }
    }

    public static Integer getIntegerInput(String prompt, Object... args) {
        return getLongInput(prompt, args).intValue();
    }
}

