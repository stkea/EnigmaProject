package com.company;

import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);

    enum Menu {
        MAIN,
        CAESAR,
        VIGENÈRE
    }


    public void displayMainMenu() {
        System.out.println("1) Caesar-encryption");
        System.out.println("2) Vigenère");
        System.out.println("3) Exit");
        evalUserInput(scanner.nextInt(), Menu.MAIN);
    }

    public void displayCaesarMenu() {
        System.out.println("1) Encryption");
        System.out.println("2) Decryption");
        System.out.println("3) Main menu");
        evalUserInput(scanner.nextInt(), Menu.CAESAR);
    }

    public void displayVigenèreMenu() {
        System.out.println("1) Encryption");
        System.out.println("2) Decryption");
        System.out.println("3) Main menu");
        evalUserInput(scanner.nextInt(), Menu.VIGENÈRE);
    }

    public void evalUserInput(int selected, Menu currentMenu) {
        switch (currentMenu) {
            case MAIN -> {
                switch (selected) {
                    case 1 -> {
                        clearConsole();
                        displayCaesarMenu();
                    }
                    case 2 -> {
                        clearConsole();
                        displayVigenèreMenu();
                    }
                    case 3 -> {
                        System.exit(1);
                    }
                }
            }
            case CAESAR -> {
                switch (selected) {
                    case 1 -> {
                        clearConsole();
                        System.out.println(new Caesar().encrypt());
                        displayCaesarMenu();
                    }
                    case 2 -> {
                        clearConsole();
                        System.out.println(new Caesar().decrypt());
                        displayCaesarMenu();
                    }
                    case 3 -> {
                        clearConsole();
                        displayMainMenu();
                    }
                }
            }
            case VIGENÈRE -> {
                switch (selected) {
                    case 1 -> {
                        clearConsole();
                        System.out.println(new Vigenère().encrypt());
                        displayVigenèreMenu();
                    }
                    case 2 -> {
                        clearConsole();
                        System.out.println(new Vigenère().decrypt());
                        displayVigenèreMenu();
                    }
                    case 3 -> {
                        clearConsole();
                        displayMainMenu();
                    }
                }
            }
        }
    }

    public void clearConsole() {
        for (int i = 0; i < 30; i++) {
            System.out.println("\b");
        }
    }



}
