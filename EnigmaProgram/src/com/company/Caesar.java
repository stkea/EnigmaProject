package com.company;

import java.util.Scanner;

public class Caesar {
    Scanner scanner = new Scanner(System.in);

    enum Action {
        ENCRYPT,
        DECRYPT
    }


    public String encrypt() {
        return performTextManipulation(Action.ENCRYPT);
    }

    public String decrypt() {
        return performTextManipulation(Action.DECRYPT);
    }



    public String performTextManipulation(Action actionType) {
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        System.out.print("Enter shift-value: ");
        int shiftValue = scanner.nextInt();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (Character.isSpaceChar(text.charAt(i))) {
                builder.append(" ");
            } else {
                int newCodepoint = calculateNewCodepoint(text.codePointAt(i), shiftValue, actionType);
                char newChar = (char) newCodepoint;
                builder.append(newChar);
            }
        }
        return builder.toString();
    }

    public int calculateNewCodepoint(int oldCodePoint, int shiftvalue, Action action) {
        if (action.equals(Action.ENCRYPT)) {
            return oldCodePoint + shiftvalue;
        }
        if (action.equals(Action.DECRYPT)) {
            return oldCodePoint - shiftvalue;
        }
        return -1;
    }


}
