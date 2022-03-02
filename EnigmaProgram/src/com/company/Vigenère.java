package com.company;

import java.util.Scanner;

public class Vigenère {

    Scanner scanner = new Scanner(System.in);
    final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";


    public String encrypt() {
        System.out.print("Enter text: ");
        String text = scanner.nextLine().toUpperCase();
        System.out.print("Enter password: ");
        String password = scanner.nextLine().toUpperCase();
        int passwordIndex = 0;

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (passwordIndex == (password.length())) passwordIndex = 0;
            if (Character.isSpaceChar(text.charAt(i))) {
                builder.append(" ");
            } else {
                // text
                char textLetterChar = text.charAt(i);
                int textLetterIndex = ALPHABET.indexOf(textLetterChar)+1;
                // password
                char passwordChar = password.charAt(passwordIndex);
                int passwordLetterIndex = ALPHABET.indexOf(passwordChar);

                int point =  textLetterIndex + passwordLetterIndex;

                if (point >= ALPHABET.length()) {
                    int newAlphabetIndex = point-ALPHABET.length();
                    char newChar = ALPHABET.charAt(newAlphabetIndex);
                    builder.append(newChar);
                } else {
                    char newChar = ALPHABET.charAt(point);
                    builder.append(newChar);
                }
                passwordIndex++;
            }
        }
        return builder.toString();
    }

    public String decrypt() {
        System.out.print("Enter text: ");
        String text = scanner.nextLine().toUpperCase();
        System.out.print("Enter password: ");
        String password = scanner.nextLine().toUpperCase();
        int passwordIndex = 0;

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (passwordIndex == (password.length())) passwordIndex = 0;
            if (Character.isSpaceChar(text.charAt(i))) {
                builder.append(" ");
            } else {
                // cipher
                char cipherChar = text.charAt(i);
                int cipherLetterIndex = ALPHABET.indexOf(cipherChar);
                // password
                char passwordChar = password.charAt(passwordIndex);
                int passwordLetterIndex = ALPHABET.indexOf(passwordChar);

                int point = cipherLetterIndex > passwordLetterIndex ?
                        cipherLetterIndex - passwordLetterIndex // E.g:   X - P
                        :
                        (ALPHABET.length()-(passwordLetterIndex - cipherLetterIndex)); // E.g:   Alphabet.length - C - S

                // We -1 to match 0-indexing.
                char newChar = ALPHABET.charAt(point - 1);
                builder.append(newChar);
                passwordIndex++;
            }
        }
        return builder.toString();
    }



}
