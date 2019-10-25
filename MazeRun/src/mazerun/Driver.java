/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazerun;

/**
 *
 * @author risau
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MazeRunner first = new MazeRunner();
        
        String[][] maze = {
            {"#","#","#","#","#","#","#","#","#","#","#","#"},{"#",".",".",".","#",".",".",".",".",".",".","#"},
            {".",".","#",".","#",".","#","#","#","#",".","#"},{"#","#","#",".","#",".",".",".",".","#",".","#"},
            {"#",".",".",".",".","#","#","#",".","#",".","#"},{"#","#","#","#",".","#","F","#",".","#",".","#"},
            {"#",".",".","#",".","#",".","#",".","#",".","#"},{"#","#",".","#",".","#",".","#",".","#",".","#"},
            {"#",".",".",".",".",".",".",".",".","#",".","#"},{"#","#","#","#","#","#",".","#","#","#",".","#"},
            {"#",".",".",".",".",".",".","#",".",".",".","#"},{"#","#","#","#","#","#","#","#","#","#","#","#"}
        };
        
        
        
        int startingR = 0;
        int startingCH = 0;
        for (int i = 0; i < 12; i++) {          //looks along the first column to find an entrance (left side only)
            if (maze[i][0].equals(".")) {
                startingR = i;
                startingCH = i + 1;
            }
        }
        int howMany = first.finish(maze, 0, startingR, 0, startingCH);
        System.out.println("It took " + howMany + " moves!");  //Including turns! It just counts how many times the function ran.
        
    }

}
        
        
    
    

