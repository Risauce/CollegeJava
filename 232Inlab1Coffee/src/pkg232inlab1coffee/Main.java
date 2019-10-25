/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg232inlab1coffee;

import java.util.Scanner;

/**
 *
 * @author risau
 */
public class Main {

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) {

        
        Coffee coffee1 = new Coffee(2, "Brewing Co.", "Medium");
        TreeManager first = new TreeManager(coffee1);
        
        //Creating coffee nodes to add to tree.
        Coffee coffee2 = new Coffee(4, "McDonalds", "Light");
        Coffee coffeeDuplicate = new Coffee(4, "McDonalds", "Light"); //Duplicate node to show program will not insert duplicates.
        Coffee coffee3 = new Coffee(1, "McDonalds", "Medium");
        Coffee coffee4 = new Coffee(3, "The Roast","Dark");
        Coffee coffee5 = new Coffee(110, "Cup Coffee", "Dark");
        Coffee coffee6 = new Coffee(50, "CreekCoffee", "Light");
        Coffee coffee7 = new Coffee(4,"CreekCoffee", "Dark" );
        Coffee coffee8 = new Coffee(4, "CupOJoe", "Light");
        
        //----------------------------------------------
        //Adding nodes to the tree, calling addToTreeData.
        first.addToTreeData(first.root, coffee2);
        first.addToTreeData(first.root, coffeeDuplicate); //Should not add Duplicate
        first.addToTreeData(first.root, coffee3);
        first.addToTreeData(first.root, coffee4);
        first.addToTreeData(first.root, coffee5);
        first.addToTreeData(first.root, coffee6);
        first.addToTreeData(first.root, coffee7);
        first.addToTreeData(first.root, coffee8);
        //----------------------------------------------
        
       
        System.out.println("Tree post Order: \n");
        first.postOrder(first.root); //Printing postOrder
        
        System.out.println("\nTree pre Order: \n");
        first.preOrder(first.root); //Printing preOrder
        
        System.out.println("\nTree in Order: \n");
        first.inOrder(first.root); //Printing InOrder
        
        

        
        
        System.out.println("\n");
        
        Coffee toDelete1 = new Coffee(110, "Cup Coffee", "Dark");
        first.deleteNode(first.root, toDelete1); 
        
        Coffee toDelete2 = new Coffee(4,"CreekCoffee", "Dark");
        first.deleteNode(first.root, toDelete2); 
        
        
        System.out.println("Tree in Order after deletion: \n");
        first.inOrder(first.root); 
        
        
        first.deleteNode(first.root, coffee6); //Will remove node #6 (AKA $50, Light, CreekCoffee)
        
        
        System.out.println("Tree in Order after deletion: \n");
        first.inOrder(first.root); 

        
        
        
    }

    
}
