/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advancedlinkedlist;

/* This one has stuff for outlab 3, reading files and advanced linked list stuff
 */
import java.io.File;
import java.util.Scanner;

public class AdvancedLinkedList {
    Scanner fin;
    AdvancedLinkedList()
    {
        try
        {
            fin = new Scanner(new File("input.dat"));
        }
        catch(Exception e)
        {
            System.err.println("Opening File Error");
        }
    }
    
    public void readFile()
    {
        while(fin.hasNextLine())
        {
            String x = fin.nextLine();
            String[] words = x.split(","); //Creates an array with a string split at the commas
            
            Integer number = new Integer(words[0]); //Casts a string to an int!!!!!
            //System.out.println(number); //Prints the first ID number
            
            for(String i : words)
            {
                i = i.trim(); //Gets rid of whitespace!!!
                System.out.println(i);
            }
            
            
            //System.out.println(x);
        }
    }
    
    public static void main(String[] args) {
        new AdvancedLinkedList().readFile();
        
        String first = "Hunter";
        String second = "Hunter";
        
        System.out.println(first == second); //THIS COMPARES THE MEMORY LOCATION!
        
        String three = new String("Hunter"); // This creates a new block of memory, totally different spot than first and second.
        
        System.out.println(first == three);
        System.out.println(first.equals(three)); //THIS COMPARES THE CONTENTS OF THE STRING !!!
                
    }
    
}
