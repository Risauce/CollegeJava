/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inlab1;

/**
 *
 * @author risau
 */
import java.util.Random;

public class InLab1 {

    public static void main(String[] args) {
        Random rand = new Random();
        int RandomNumber;
        int array[] = new int[10];
        
        //--------------------------------------
        //Class Stuff
        SecondClass xclass;
        
        xclass = new SecondClass(5);
        SecondClass yclass = new SecondClass(-22);
        
        int answer = yclass.getX();
        System.out.println("yclass: " + answer);
        //------------------------------------------
        
        for (int i = 0; i < array.length; i++) {
            //Create the random number Array
            RandomNumber = rand.nextInt(10) + 1;
            array[i] = RandomNumber;
            System.out.print(array[i] + " ");
        }
                System.out.print('\n');

        
        //Part 2-------------------------------------
        for (int i = array.length-1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        
        //Part 3-------------------------------------
        int secondLargest = array[0];
        int maxValue = array[0];
        
        for (int i = 0; i < array.length; i++) {
            if (maxValue < array[i]) {
                secondLargest = maxValue;
                maxValue = array[i];
                
            }
            else{
                if (array[i] > secondLargest) {
                    secondLargest = array[i];
                    
                }
                
            }
            
            
        }
        System.out.println("\n" + maxValue + " " + secondLargest);
        
        //part 4-------------------------------------------
        
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        int average = sum/array.length;
        System.out.println("The Average is: " + average);
        
        
        //part 6----------------------------------------
        int num;
        System.out.println("Histogram of the Array:");
              
        for (int i = 0; i < array.length; i++) {
            num = array[i];
            for (int j = 0; j < num; j++) {
                System.out.print("*");
            }
        System.out.print("\n");
        }
        
        //part 7----------------------------------------
        for (int i = 0; i < array.length; i++) {
            int numTimes = 0;
            int count = i+1;
            
            for (int j = 0; j < array.length; j++) {
                if (count == array[j]) {
                    numTimes +=1;
                }
            }
            System.out.println("The number " + count + " is in the array " + numTimes + " times.");
        }
    }
    
}
