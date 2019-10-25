/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outlab3;
import java.util.Scanner;
import java.io.File;


public class Outlab3 {

    
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        boolean done = false;
        
        LLManager list = new LLManager();
        
        while(done != true){
            printMenu();
            int input = reader.nextInt();
            
            switch(input){
                    case 1:     //Load list from file.
                        list.readFile();
                        
                        break;
                    case 2:     //Create list from user input.
                        System.out.println("Enter an ID: ");
                        int inID = new Integer(reader.next());
                        
                        System.out.println("Enter a last name: ");
                        String inLast = reader.next();
                        
                        System.out.println("Enter a first name: ");
                        String inFirst = reader.next();
                        //Node add = new Node(inID, inLast, inFirst);
                        //list.inOrder(add);
                        list.addInOrder(inID, inLast, inFirst);
                        break;
                    case 3:     //Print List in order.                   - TBD
                        
                        list.printList();
                        
                        break;
                    case 4:     //Print List backwards.                  - TBD
                        Node listReverse = list.reverse();
                        
                        list.printBackwards(listReverse);
                        break;
                    case 5:     //Remove single Node based on the position the node is at in the list.
                        //Instructions do not specify what
                        System.out.println("What position would you like to delete? ");
                        int delPos = reader.nextInt();
                        list.deleteAtPosition(delPos);
            
                        break;

                    case 6:     //Delete entire list.
                        list.deleteList();
                        break;
                    case -1:    //Exit.
                        done = true;
                        break;
            }
        }
    }
    
    public static void printMenu(){     //Prints all of the menu options.
        System.out.println("Press 1 to load list from file.");
        System.out.println("Press 2 to load list with individual item from user input.");
        System.out.println("Press 3 to print list in order.");
        System.out.println("Press 4 to print list backwards.");
        System.out.println("Press 5 to remove item.");
        System.out.println("Press 6 to delete entire list.");
        System.out.println("Press -1 to exit.");
    }
    
}
