/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorts;

/**
 *
 * @author risau
 */
public class Sorts {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }
    
    public void insertionSort(int intArray[])
    {
        int n = intArray.length;
        for (int i = 1; i < n; i++) {
            int key = intArray[i];
            
            int j = i-1;
            while(j>= 0 && intArray[j] > key)
            {
                intArray[j+1] = intArray[j];
                j=j-1;
            }
            intArray[j+1]  = key;
        }
    }
    
    public void bubbleSort(int intArray[])//This is O(n^2), how can we make it so best case scenario is O(n)?
    {
        int n = intArray.length;
        int temp;
        
        for (int i = 0; i < n-1; i++) {
            for (int j = 1; j < (n-i); j++) {
                if (intArray[j-1] > intArray[j]) {
                    temp = intArray[j-1];
                    intArray[j-1] = intArray[j];
                    intArray[j] = temp;
                }
            }
        }
    }
    
}
