/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magicsquareinlab232;

/**
 *
 * @author risau
 */
public class MagSquare {
    
    boolean usedVal[];
    int n;
    int solutionArray[][];
    
    MagSquare(int num)
    {
        n = num;
        
        usedVal = new boolean[n*n];       
        solutionArray = new int[n][n];
        
    }
    
    public void solve(int row, int col) {
        for (int i = 1; i <= (n * n); i++) { //Go through 1-n, not using values already used
            if (usedVal[i - 1] == false) {
                solutionArray[row][col] = i;
                usedVal[i - 1] = true;

                if (filled()) { //If solution is valid (not neccesarily complete)
                    //System.out.println("Filled");
                    if (done()) {
                        //Then print!
                        printSol();

                    }
                } else {
                    //System.out.println("else");
                    if (col != 2) { //If we aren't on the last col, just move to the next col, otherwise we need to move to next row
                        solve(row, col + 1);
                    } else if (row != 2) { //Make sure we aren't also at the end
                        solve(row + 1, 0);
                    }

                }

                solutionArray[row][col] = 0;
                usedVal[i - 1] = false;

            }

        }

    }

    
    public boolean filled()
    {
        for (int i = 0; i < usedVal.length; i++) {
            if (usedVal[i] == false) {
                
                return false;
            }
        }
        
        return true;
    }
    
    public boolean done() //Check rows, cols, and diagonals
    {
        for (int i = 0; i < n; i++) {
            if (isValidRow(i) == false || isValidCol(i) == false) {
                
                return false;
            }
        }
        
        return isValidDiag();
        
    }
    
     public boolean isValidRow(int r){
        if(solutionArray[r][0] + solutionArray[r][1]+ solutionArray[r][2]==15){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean isValidCol(int pos) //Check all the cols with a floor loop 
    {
        if ((solutionArray[0][pos] + solutionArray[1][pos] + solutionArray[2][pos]) == 15) {
            return true;
        }
        else
            return false;
    }
    
    public boolean isValidDiag(){
        if((solutionArray[0][0] + solutionArray[1][1] + solutionArray[2][2] ==15) && (solutionArray[2][0] + solutionArray[1][1] + solutionArray[0][2] ==15)){
            return true;
        }else{
            return false;
        }
    }
    
    public void printSol()
    {
        System.out.println("Single Solution:");
        for (int j = 0; j < n; j++) {
            System.out.println();
            for (int k = 0; k < n; k++) {
                System.out.print((solutionArray[j][k] + " "));
            }
        }
        System.out.println("\n------------");
    }
    
}
