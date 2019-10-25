/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outlab1;

/**
 *
 * @author risau
 * This Program is the marble game of Nim. It holds an AI that plays against the player, taking marbles from the 'stack' until
 * either the player or computer takes the last marble and loses. 
 */
import java.util.Random;
import java.util.Scanner;
public class Nim {

    /**
     * @param args the command line arguments
     */    
    Scanner reader = new Scanner(System.in);  // Reading from System.in
        
    public static void main(String[] args) 
    {
        //This is the main function, it instanciates all the 'global' variables and determines what difficulty and order to go in.
        //it then runs the playerfirst or computerfirst.
        //----------------------------
        Random rand = new Random();
        int stack = rand.nextInt(91) + 10;
        int order = rand.nextInt(2);
        int difficulty = rand.nextInt(2);
        
        //Needed booleans:-------------
        boolean done = false;
        boolean hard = false;  
        boolean playerFirst = false;
        //-----------------------------
        
        if (difficulty == 1) {
            hard = true;
        }
        if (order == 1) {
            playerFirst = true;
        }
        
        System.out.println(stack +" " + order);
        
        Nim game = new Nim();
        
        if (playerFirst) {
            game.playerFirst(done, hard, stack);
        }
        else
            game.compFirst(done, hard, stack); 
    }
    
    public Nim()
    {
        //Constructor method (used for nothing in this program)
    }
    
    public void playerFirst(boolean done, boolean difficulty, int stack)
    {//THE GAME IF PLAYER GOES FIRST
        while(true)
        {
            stack = playerTake(stack);
            printStack(stack);
            
            if (stack == 0) {
                //done = true;
                System.out.println("Computer Wins!");
                break;
            }
            if (difficulty) {
                stack = smartComTake(stack);
                printStack(stack);
            }
            else
            {   
                stack = dumbComTake(stack);
                printStack(stack);
            }
            if (stack == 0) {
                //done = true;
                System.out.println("Player 1 Wins!");
                break;
            }
        }
    }
    
    public void compFirst (boolean done, boolean difficulty, int stack)
    {//THE GAME IF COMPUTER GOES FIRST (basically the same just alternated)
        while(!done)
        {
            
            if (difficulty) {
                stack = smartComTake(stack);
                printStack(stack);
            }
            else
            {   
                stack = dumbComTake(stack);
                printStack(stack);
            }
            if (stack == 0) {
                
                System.out.println("Player1 Wins!");
                break;
            }
            
            stack = playerTake(stack);
            printStack(stack);
            if (stack == 0) {
                
                System.out.println("Computer Wins!");
                break;
            }
            
            
            
        }
    }
    
    public void printStack(int stack)
    {//Simple method to print the stack value.
        System.out.println("\nThe Stack is at: " + stack + " marbles.");
    }
    
    public int playerTake(int stack)
    {//This method is what controls what value of marbles the user takes from the stack. It won't allow illegal plays, and when the stack is at
        //1 it realizes so and makes you chose one. 
        System.out.print("Enter the number of marbles to remove: ");
        int n = reader.nextInt(); // Scans the next token of the input as an int.
        if (n <= stack/2 && n >= 1) {
            stack = stack - n;
        }
        else if (stack == 1) {
            stack = 0;
        }
        else
        {
            System.out.print("That is an illegal play! Do something less than half the stack and greater than 0: ");
            n = reader.nextInt();
            if (n>=stack/2 || n==0) {
                System.out.print("Ok, you're taking 1 marble then.");
                n = 1;
            }
            stack = stack - n;
            
        }
        return(stack);
    }
    
    public int dumbComTake(int stack) 
    {
        //this method controls the random number pull of a dumb computer. 
        Random rand = new Random();
        int take = rand.nextInt((stack/2)) + 1;
        
        
        while (take > stack) {
            take = rand.nextInt((stack/2)) + 1;
        }
        
        if (stack == 1) {
            take = 1;
        }
        
        System.out.println("The Computer took " + take + " marbles!");
        return(stack - take);
    }
            
    public int smartComTake(int stack)
    {
        
        //this method controls what a smart computer would take via algorithms. It will always aim for a power of 2 - 1 unless it has such a number, in 
        //which case it will revert to a dumbcomputer move. (random)
        Random rand = new Random();
        
        int taken;
        int winNums[] = {3, 7, 15, 31, 63};
        int loseNums[] = {2, 6, 14, 30, 62};
        boolean found = false;
        
        //If the stack is at any of the values inside loseNums, then the algorithm will not work. So we need to check.
        for (int i = 0; i < loseNums.length; i++) {
            if (stack == loseNums[i]) {
                found = true;
                break;
            }
        }
        
        if (!found) 
        {
            for (int i = 0; i < winNums.length; i++) {
                if (winNums[i] < stack && stack - winNums[i] < stack/2) {
                    
                    taken = stack - winNums[i];
                    if (stack == 1) {
                        taken = 1;
                    }
                    stack = winNums[i];
                    System.out.println("The Computer took " + taken + " marbles!(Smartly)");
                    break;
                }
            }
        }
        else
            //if it is on a bad number, then just make a random play.
        {
            stack = dumbComTake(stack);
        }
            return(stack);
    }
    
    
}
