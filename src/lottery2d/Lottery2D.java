/*
Program Name:           Lottery2D
Author:                 Anthony Sego
Date:                   3/31/2018
Purpose of Program:     Use a 2D array to store 3 random numbers (columns) for 20 different players (rows)
                        Use a 1D array to store 3 random numbers for the winning numbers
                        iterate through nest loops to determine if all three numbers match, in order.
                        each player with 3 matching numbers a winner and total number of winners
                        output list of players and their numbers, if they are winnders, and total numbers of winners
                        allow for multiple plays
                        NOTE: probability of all 3 matching is about 1/729. I was setting number
                        of players to 1000 and still not getting winners on some rounds. */
package lottery2d;

import java.util.Random;
import java.util.Scanner;

public class Lottery2D {

    //------------------------------------------------------
    //declare new global two dimensional array to generate 3 random pick 3 numbers
    //for 20 people, and a global one dimensional array for 3 winning numbers
    //------------------------------------------------------
    public static int[][] pick3Nums = new int[20][3];
    public static int[] winningNums = new int[3];
        
    //------------------------------------------------------
    //numGenerator() method for generating the random numbers for winning
    // numbers array and for each players' 3 different random numbers.
    //------------------------------------------------------
    public static void numGenerator(){

        Random rand = new Random();
        
        //-----------------------------------------------
        //Loop to generate 3 random numbers placed in a 1D array
        //-----------------------------------------------
        for(int i = 0; i < winningNums.length; ++i){
            winningNums[i] = rand.nextInt(9);
        }
        //-----------------------------------------------
        //Two loops for 2D array to generate 20 players (rows)
        //and 3 random numbers for each player (columns)
        //-----------------------------------------------
        for(int row = 0; row < pick3Nums.length; ++row){
            for(int col = 0; col < pick3Nums[row].length; ++col){
        
                pick3Nums[row][col] = rand.nextInt(9);
            }
        }

    }
    
    //------------------------------------------------------
    //displayGame() method that calls numGenerator to start new game.
    //includes all output for each game.
    //------------------------------------------------------
    public static String displayGame(){
        //------------------------------------------------------
        //initialize winCount to 0. Increases each time there are 3 matching numbers
        //------------------------------------------------------
        int winCount = 0;

        numGenerator();

        
        String displayStatement = "";
        
        //------------------------------------------------------
        //Displays beginning of game and the winning numbers before
        //outputting list of players, winners, and win count.
        //------------------------------------------------------
        System.out.println("\n<<<---------------------------------------->>>");
        System.out.println("\n\t***Welcome to the pick 3***");
        System.out.print("\t***Today's winning numbers are: ");
                for(int i = 0; i < winningNums.length; ++i){
                    System.out.print(winningNums[i] + " ");
                }
        System.out.println("\nToday's players and their lotto picks are:\n");
        
        //------------------------------------------------------
        //Nested loops to iterated through each row and display each number per row
        //before continuing to next row of 2D pick3Nums array
        //each iteration of pick3Nums columns add to winningNumMatch if the number matches
        //if after all iterations of internal loop, it has a count of 3
        //winCount increases and that player is declared a winner.
        //------------------------------------------------------
        

        for(int row = 0; row < pick3Nums.length; ++row){
            int winningNumMatch = 0;
            displayStatement += "Player " + (row+1) + ": " + "\t";
                
            
            for(int col = 0; col < pick3Nums[row].length; ++col){
                
                    
                displayStatement += " " + pick3Nums[row][col];
                    
                    
                if(winningNums[col] == pick3Nums[row][col]){
                    ++winningNumMatch;
                }
                    
                if(winningNumMatch == 3){
                displayStatement += "\t***We have a Winner***";
                ++winCount;
                }
            }
            displayStatement += "\n";
        }
        
        //------------------------------------------------------
        //winCount statement.  Outputs how many winners there were each game.
        //------------------------------------------------------
        if(winCount == 0){
            displayStatement += "\nSorry, no winners today.  Better luck next time!";
        }
        else{
            displayStatement += "\n***Number of lucky winners in this round: " + winCount;
        }
        
        return displayStatement;
    }
    

    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        String playAgainCheck = "Yes";
        
        //------------------------------------------------------
        //beginning of do while loop to play multiple games.
        //------------------------------------------------------
        do{
        
        //------------------------------------------------------
        //method call to displayGame()
        //------------------------------------------------------
        System.out.println(displayGame());
        
        System.out.println("\nWould you like to try your luck again?");
        playAgainCheck = scan.nextLine();
        
        //------------------------------------------------------
        //Vaidation for play again loop.
        //------------------------------------------------------
        while(!(playAgainCheck.equalsIgnoreCase("Yes") || playAgainCheck.equalsIgnoreCase("No"))){
            System.out.println("\nSorry, not a valid input."
                    + "\nPlease enter Yes or No: ");
            playAgainCheck = scan.nextLine();
        }
        
        }
        //------------------------------------------------------
        //end of do while loop
        //------------------------------------------------------
        while(playAgainCheck.equalsIgnoreCase("Yes")); 
        
        
    }
    
}
