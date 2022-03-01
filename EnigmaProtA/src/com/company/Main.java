package com.company;

public class Main {


    final String ALPHABET = " ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";

    public int letterToNumber(char charr) {
        return ALPHABET.indexOf(charr);
    }

    public char numberToLetter(int index) {
        return ALPHABET.charAt(index);
    }


    public static void main(String[] args) {
        Main main = new Main();
    }
}
