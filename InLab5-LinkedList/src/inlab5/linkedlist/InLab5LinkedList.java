/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inlab5.linkedlist;

/**
 *
 * @author risau
 */
import java.util.Scanner;
public class InLab5LinkedList {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        LinkedList list = new LinkedList();
        
        boolean done = false;
        while(done == false)
        {
            printMenu();
            int input = reader.nextInt();
            switch(input)
            {
                case 1:
                    System.out.println("What name would you like to enter?");
                    String inName = reader.next();
                    list.add(inName);
                    break;
                case 2:
                    list.print();
                    break;
                case 3:
                    System.out.println("What name would you like to delete?");
                    String delName = reader.next();
                    list.delete(delName);
                    break;
                case 4:
                    System.out.print("Are you sure?");
                    String bool = reader.next();
                    if (bool == "yes" || bool == "y") {
                        list.deleteList();
                    }
                    break;
                    
                case -1:
                    done = true;
                    break;
                    
                default:
                    System.out.println("Try again");
                    break;
                    
            
            
            }
        }
    }
    
    static void printMenu()
    {
        System.out.println("What would you like to do?");
        System.out.println("Press 1 to add an item to the back of the list");
        System.out.println("Press 2 to print the list");
        System.out.println("Press 3 to delete an item");
        System.out.println("Press 4 to clear the whole list");
        System.out.println("Press -1 to exit");
        
        
    }
    
}
