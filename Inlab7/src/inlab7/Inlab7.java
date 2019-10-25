/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inlab7;

import java.util.Random;

/**
 *
 * @author risau
 */
public class Inlab7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Random generator = new Random();
        int[] possibles = {20, 100, 500, 1000, 10000};
        
        int randomIndex = generator.nextInt(possibles.length);
        int size = possibles[randomIndex];
        
        int[] stuff = new int[size];
        
        for (int i = 0; i < stuff.length; i++) //Put random numbers in.
        {
            stuff[i] = (int) (Math.random() * size);
        }
        
        long startTime = System.currentTimeMillis();
        insertionSort(stuff);
        long finishTime = System.currentTimeMillis();
        
        System.out.println("The time in milliseconds to insertion sort " + size + 
            " items is " + (finishTime - startTime));
        
        
        for (int i = 0; i < stuff.length; i++) //Put random numbers in again. (reshuffle the array)
        {
            stuff[i] = (int) (Math.random() * size);
        }
        
        startTime = System.currentTimeMillis();
        bubbleSort(stuff);
        finishTime = System.currentTimeMillis();
        
        System.out.println("The time in milliseconds to bubble sort " + size + 
            " items is " + (finishTime - startTime));
    }
    
    public static void insertionSort(int array[])
    {
        int n = array.length;
        int counter = 0;
        
        for (int i = 1; i < n; i++) {
            int location = array[i];
            int j = i-1;
            while(j>=0 && location < array[j])
            {
                array[j+1] = array[j];
                j--;
                counter++;
                
            }
            array[j+1] = location;
        }
        System.out.println("It took " + counter + " comparisons");
             
    }
    
    public static void bubbleSort(int array[])
    {
        int n = array.length;
        int temp;
        int counter = 0;
        
        for (int i = 0; i < n-1; i++) {
            for (int j = 1; j < n-i; j++) {
                if (array[j-1] > array[j]) {
                    temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                    counter+= 1;
                }
            }
        }
        System.out.println("It took " + counter + " swaps");
    }
    
}
