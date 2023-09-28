package com.karlson.application.helpers;

import java.util.Scanner;

public class UserInputManager {


    private static final Scanner scanner = new Scanner(System.in);


    public static int getLimitedInt(int min, int max) {
        int input = getInt();
        if (input >= min && input <= max || input == 9) {
            return input;
        } else {
            TextManager.notValidChoice();
            return getLimitedInt(min, max);
        }
    }

    public static int getInt() {
        int input;
        while (true) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                TextManager.notValidInt();
            }
        }
        return input;
    }

    public static String getString() {
        System.out.print("Set name: ");
        return scanner.nextLine();
    }
}
