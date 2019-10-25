/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtableoutlab2;

/**
 *
 * @author risau
 */
public class HashTableOutlab2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashController first = new HashController(); //Create the empty hash table
        
        
        //Testing! ----------------------------------------------------------
        first.insertFromFile();  //1
        first.insertFromFile();//2
        first.insertFromFile();
        //first.printArray();
        
        first.insertFromFile(); //4 - rehash now
        first.printArray();
        first.insertFromFile();
        first.insertFromFile();
        first.insertFromFile();  
        first.insertFromFile();
        first.insertFromFile();
        first.insertFromFile();//10
        //first.printArray();
        
        first.insertFromFile();
        first.insertFromFile();
        first.insertFromFile();  
        first.insertFromFile();
        first.insertFromFile(); //15
        first.insertFromFile();  
        first.insertFromFile();
        first.insertFromFile();
        first.insertFromFile();  
        first.insertFromFile();
        first.insertFromFile();
        first.insertFromFile();  
        first.insertFromFile();
        first.insertFromFile();
        first.insertFromFile();  
        first.insertFromFile();
        first.insertFromFile(); //27
        //first.printArray();
        
        
        first.printArray();
        
        System.out.println(first.search(6439));
        first.delete(7);
        
        
        //Finished
    }
    
}
