/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugofwar232;


import java.util.Scanner;

/**
 *
 * @author risau
 * This program uses dynamic programming to create the minimum difference and thus the perfect tug of war team composition. 
 */
public class ComputeTeams {
    
    public int [] weights;
    private int numberChildren;
    
    
    public int[][] table;
    
     public ComputeTeams(int nChildren, int weightMax)
    {
        numberChildren = nChildren;
        
        
        
    }
    
    public int[] readWeights(Scanner in)
    {  
        weights = new int [numberChildren];
        for (int i = 0; i < weights.length; i++)
        {
            weights[i] = in.nextInt();
        }
        return weights;
    }
    
    
    public int findMinRec(int arr[], int i, int sumCalculated, int sumTotal)
    {
        if (i == 0) {
            return table[i][sumCalculated] = (Math.abs((sumTotal - sumCalculated) - sumCalculated));
        } else {
            if (table[i - 1][sumCalculated + arr[i - 1]] == -10000) {
                table[i - 1][sumCalculated + arr[i - 1]] = findMinRec(arr, i - 1, sumCalculated + arr[i - 1], sumTotal);
            }

            if (table[i - 1][sumCalculated] == -10000) {
                table[i - 1][sumCalculated] = findMinRec(arr, i - 1, sumCalculated, sumTotal);
            }

            return (Math.min(table[i - 1][sumCalculated + arr[i - 1]], table[i - 1][sumCalculated]));

        }

    } 
    
    
    public int findMin(int arr[], int n) {
        int sumTotal = 0;
        
        
        for (int i = 0; i < n; i++) {
            sumTotal += arr[i];
        }
        
        table = new int[n+1][sumTotal+1];
        
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < sumTotal+1; j++) {
                table[i][j] = -10000;
            }
            
        }
        return findMinRec(arr, n, 0, sumTotal);
    }
     
     
	 
	
}
