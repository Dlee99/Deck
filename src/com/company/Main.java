package com.company;

import java.util.*;
import java.text.DecimalFormat;

/**
 * This is a class that tests the Deck class.
 */
public class Main {
    private static final String[] numNames = {"",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten"
    };
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Please input the suits you want.  Type \"Exit\" to go to next input");
        ArrayList<String> suitsal = new ArrayList<>();
        while (true) {
            String s = sc1.next();
            if (s.equalsIgnoreCase("Exit")) {
                break;
            } else {
                suitsal.add(s);
            }
        }
        System.out.println("What is the lowest and highest non-face card you want in the deck?");
        System.out.print("Low:\t");
        int low = sc2.nextInt();
        System.out.println();
        if(low < 2){
            low = 2;
            System.out.println("Too low, sorry.  Set to 2.");
        }
        System.out.print("High:\t");
        int high = sc2.nextInt();
        if(high > 10){
            high = 10;
            System.out.println("Too high, sorry.  Set to 10.");
        }
        System.out.println("Would you like the standard face cards?  (Ace, Jack, King, and Queen.  \"Y\" or \"N\"");
        boolean f = true;
        while(true){
            String face = sc1.next();
            if(face.equalsIgnoreCase("Y")){
                f = true;
                break;
            }
            else if(face.equalsIgnoreCase("N")){
                f = false;
                break;
            }
            else{
                System.out.println("Please input \"Y\" or \"N\"");
            }
        }
        ArrayList<String> extra = new ArrayList<>();
        System.out.println("What extra cards would you like?  \"None\" if none.");
        while(true){
            String e = sc1.next();
            if(e.equalsIgnoreCase("None")){
                break;
            }
            else{
                System.out.println("How many would you like?");
                int a = sc2.nextInt();
                for(int i = 0; i < a; i++) {
                    extra.add(e);
                }
            }
        }
        String[] suits = new String[suitsal.size()];
        for(int i = 0; i < suits.length; i++){
            suits[i] = suitsal.get(i);
        }
        int[] values = new int[high - low + 1];
        for(int i = 0; i < high - low + 1; i++){
            values[i] = low + i;
        }
        int t;
        if(f){
            t = 4;
        }
        else{
            t = 0;
        }
        String[] ranks = new String[high - low + 1 + t];
        for(int i = 0; i < values.length; i++){
            ranks[i] = numNames[values[i]];
        }
        if(f){
            ranks[values.length] = "Ace";
            ranks[values.length + 1] = "Jack";
            ranks[values.length + 2] = "King";
            ranks[values.length + 3] = "Queen";
        }
        String[] extras = new String[extra.size()];
        for(int i = 0; i < extras.length; i++){
            extras[i] = extra.get(i);
        }
        Deck deck = new Deck(ranks, suits, extras);
        deck.shuffle();
        System.out.println(deck.toString());

    }
}
