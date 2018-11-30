package com.company;

import java.util.Scanner;

public class TicTacToeApplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // POZWALA KONTYNUOWAĆ GRĘ
        boolean doYouWantToPlay = true;
        while (doYouWantToPlay) {

            System.out.println("pick character KSHAKDLKAJSLDLASJDLASKJFLDASKDJLA" +
                    "KSDJLAKSJDLAKSDJALSKDJALSKDJALSKDJ" +
                    "DSADHASIUDHIAUSDHAISUHDADIUAHSDIUAHSDIUAHS" +
                    "DIUAHSDIUHASIDUHAISUHDIASUHDIAUHSIDU");
            System.out.println();

            System.out.println("Enter a single character that will represent you on the board");
            char playerToken = sc.next().charAt(0);
            System.out.println("Eneter a single character that will represent...opponent");
            char opponentToken = sc.next().charAt(0);
            TicTacToe game = new TicTacToe(playerToken, opponentToken);
            AI ai = new AI();


            // set upp

            System.out.println();
            System.out.println("We can start enter a number and your token shall be put " +
                    "in its place. \n The numbers go from 1-9, left to right shall see who will winn this round.");
            TicTacToe.printIndexBoard();
            System.out.println();

            //Let's play!
            while (game.gameOver().equals("notOver")) {
                if (game.currentMarker == game.userMarker) {
                    //User Turn
                    System.out.println("It;s your turn! enter a spot for your token.");
                    int spot = sc.nextInt();
                    while (!game.playTurn(spot)) {
                        System.out.println("Try again. " + spot + "is invalid. this spot is already taken" +
                                "or ist out of range");
                        spot = sc.nextInt();
                    }
                    System.out.println("Your picked " + spot + " !");
                } else {
                    System.out.println("It's my turn!");
                    //pick a spot
                    int aiSpot = ai.pickSpot(game);
                    game.playTurn(aiSpot);
                    System.out.println("I picked " + aiSpot + "!");
                }
                //Print out new board
                System.out.println();
                game.printBoard();
            }
            System.out.println(game.gameOver());
            System.out.println();
            System.out.println("Do you want to play again enter Y if you do." +
                    " Enter anything else if you are tired.");
            char response = sc.next().charAt(0);
            doYouWantToPlay = (response == 'Y');
            System.out.println();
            System.out.println();

        }
    }
}

