/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtableoutlab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author risau
 */
public class HashController {
    ValueHolder[] array; 
    Scanner fin;
    int size;
    float load;
    
    public HashController()
    {
        size = 5;
        load = 0;
        array = new ValueHolder[5];
        
        while (true) {
            try {
                fin = new Scanner(new File("hashTest.txt")); //Don't crash if we have a file read error
                break;
            } catch (FileNotFoundException e) {
                System.err.println("Opening File Error");
                break;
            }
        }
    }
    
   
    
    public void insertFromFile() //Add from the file, taking the string array and splitting into key, value pairs. 
    {
        String x = fin.nextLine();
        String[] pairs = x.split("\\s+"); // //s+ is the whitespace indicator
                
        int key = new Integer(pairs[0]);
        String value = pairs[1];
        
        try //This is for the off-case that the value has 2 parts to the name...
        {
            String secondValue = pairs[2];
            value = value + " " + secondValue;
        }
        catch (Exception outOfBounds) {}
        
        int hashValue = key % size; //Get the hash value for insertion
        
        
        
        
        
        //checkLoad();
        int i = 0;
        while(array[hashValue+i] != null) //Keep going as long as the required position is full 
        {
            if ((hashValue + i) < size-1) { //Make sure that we aren't going above bounds, if so we need to go to the beginning of the array and attempt to add there. (Linear probing)        
                
                i++;
                
            }
            else
            {
                i = i-size;
                i++;
            }
                
        }
        
        
        
        array[hashValue+i] = new ValueHolder(key, value);
        load++;
        checkLoad();  //See if it is too full, rehash if needed
    }
    
    public void checkLoad() //This function makes sure the table isn't too full, if it is it calls rehash. 
    {
        if (((load*10)/size) >= 8) { //Then we need to rehash
            
            System.out.println("TOO FULL");
            rehash(1);
            
            
        }
        
        
    }
            
    public void rehash(int doIt) //This function takes the current table, taking each value and rehashing it. It's called if the load factor is too high or the delete function takes one out. 
    {
        int doubleSize;
        if (doIt == 1) {
            doubleSize = size*2;
        }
        else //This happens if we just delete. 
        {
            doubleSize = size;
        }
        
        
        ValueHolder[] temp = new ValueHolder[doubleSize]; // Create an empty array that is the required size. 
        
        for (int i = 0; i < size; i++) { //Go through every value in the original array, and rehash it:
            if (array[i] != null) {
                int newHash = array[i].key % doubleSize;                
                
                int n = 0;
                while (temp[newHash + n] != null) { //(Linear probing
                    if ((newHash + n) >= doubleSize-1) {
                        newHash = 0;
                        n = 0;

                    } else {
                        n++;
                    }
                }
                
                temp[newHash+n] = new ValueHolder(array[i].key, array[i].value); //Insert the value
                
            }
            
        }
        size = doubleSize;
        array = temp;
        
        
        this.printArray();
        
    }
    
    public String search(int key) //This function looks for an entered key in the table, and returns the associated value. 
    {
        int hashValue = key%size;
        
        for (int i = hashValue; i < size-1; i++) {
            if (i == 40) {
                return null;
            }
            while(array[i] != null)
            {
                
                if (array[i].key == key) {
                    return "Your searched for key gets the value: " + array[i].value;
                }
                else 
                    i++;
            }
        }
        for (int i = 0; i < hashValue+1; i++) { //This occurs if linear probing caused the value to be pushed to the beginning of the array. 
            while(array[i] != null)
            {
                if (array[i].key == key) {
                    return "Your searched for key gets the value: " + array[i].value;
                }
                else 
                    i++;
            }
        }
        return null;
    }
    
    public void delete(int key) //This function finds the requested value and turns it to null. It then rehashes the function. 
    {
        if (search(key) != null) {
            int i = key % size; 
            
            
            while(array[i].key != key)
            {
                if (i >= size) {
                    break;
                }
                i = (i+1) % size;
            }
            array[i] = null;
                    
        }
        
        load--;
        rehash(0);
    }
    
    
    
    public void printArray(){ //This prints out the array in the format: key, value
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
        System.out.println();
    }
    
}
