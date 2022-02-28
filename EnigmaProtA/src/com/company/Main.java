package com.company;

public class Main {

    char[] charArray = {
            ' ',
            'A', 'B', 'C',
            'D', 'E', 'F',
            'G', 'H', 'I',
            'J', 'K', 'L',
            'M', 'N', 'O',
            'P', 'Q', 'R',
            'S', 'T', 'U',
            'V', 'W', 'X',
            'Y', 'Z', 'Æ',
            'Ø', 'Å'};


    public int letterToNumber(char charr) {
        int index = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == charr) {
                index = i;
            }
        }
        return index;
    }

    public char numberToLetter(int number) {
        return charArray[number];
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}
