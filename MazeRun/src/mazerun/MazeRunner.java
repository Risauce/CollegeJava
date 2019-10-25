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
public class MazeRunner {
    
    public int finish(String maze[][], int c, int r, int handC, int handR)
    {//This method recursively finds the end of a maze by comparing what the "right hand" value is on -a wall or passable terrain. 
        String dir = "E";
        
        if (maze[r][c].equals("F")) { //If it finds an F, you are done!
            System.out.println("Finished!");
            return 1;
        }
        else
        {
            this.printMaze(maze); //Print how the maze looks right now
            maze[r][c] = "X"; //Put an X where you are at.
            
            if (handC == c+1) { //These few lines are used to calculate which direction we are pointing
                dir = "N";
            }
            else if (handC == c-1) {
                dir = "S";
            }
            else if (handR == r+1) {
                dir = "E";
            }
            else if (handR == r-1) {
                dir = "W";
            }
            
            switch (dir) {
                case "N":
                    //Each direction has it's own rules, all very similiar but subtly different.
                    
                    if (maze[handR][handC].equals(".")|| maze[handR][handC].equals("X")) //If the hand is on passable, go there
                    {
                        r = handR;
                        c = handC;
                        handR = r+1;
                        handC = c;
                        return 1+finish(maze, c, r, handC, handR);
                    }
                    else //if(maze[handR][handC].equals("#")) //If not, then test if front spot is passable
                    {
                        if (maze[r-1][c].equals("F")) { //This extra test has to be in in case our method finds the end in front of us.
                            
                            System.out.println("Finished!");
                            return 1;
                        }
                        if (maze[r-1][c].equals(".") || maze[r-1][c].equals("X")) {
                            handR = r - 1;
                            handC = c + 1;
                            r = r - 1;
                            return 1+finish(maze, c, r, handC, handR);
                        }
                        else //if (maze[r-1][c].equals("#")) //If the one in front is not passable, then turn left and start over
                        {
                            handR = r - 1;
                            handC = c;
                            return 1+finish(maze, c, r, handC, handR); 
                        }
                        
                    }
                case "E":
                    if (maze[handR][handC].equals(".") || maze[handR][handC].equals("X"))
                    {
                        r = handR;
                        c = handC;
                        handR = r;
                        handC = c-1;
                        return 1+finish(maze, c, r, handC, handR);
                    }
                    else //if (maze[handR][handC].equals("#"))
                    {
                        if (maze[r][c+1].equals("F")) {
                            System.out.println("Finished!2");
                            return 1;
                        }
                        if (maze[r][c+1].equals(".") || maze[r][c+1].equals("X")) {
                            handC = c + 1;
                            handR = r + 1;
                            c = c + 1;
                            
                            return 1+finish(maze, c, r, handC, handR);
                            
                        }
                        else //if (maze[r][c+1].equals("#"))
                        {
                            handR = r;
                            handC = c + 1; //Fixed here
                            return 1+finish(maze, c, r, handC, handR); 
                        }
                        
                    }
                case "S":
                    if (maze[handR][handC].equals(".") || maze[handR][handC].equals("X")) {
                        r = handR;
                        c = handC;
                        handR = r-1;
                        handC = c;
                        return 1+finish(maze, c, r, handC, handR);
                    }
                    else //if (maze[handR][handC].equals("#"))
                    {
                        if (maze[r+1][c].equals("F")) {
                            System.out.println("Finished!2");
                            return 1;
                        }
                        if (maze[r+1][c].equals(".") || maze[r+1][c].equals(".")) {
                            handR = r + 1;
                            handC = c - 1;
                            r = r + 1;
                            
                            return 1+finish(maze, c, r, handC, handR);
                            
                        }
                        else //if (maze[r+1][c].equals("#"))
                        {
                            handR = r + 1;
                            handC = c;
                            
                            return 1+finish(maze, c, r, handC, handR); 
                        }
                        
                    }
            //if (dir.equals("W"))
                default:
                    if (maze[handR][handC].equals(".") || maze[handR][handC].equals("X")) {
                        r = handR;
                        c = handC;
                        handR = r;
                        handC = c+1;
                        return 1+finish(maze, c, r, handC, handR);
                    }
                    else //if (maze[handR][handC].equals("#"))
                    {
                        if (maze[r][c-1].equals("F")) {
                            System.out.println("Finished!2");
                            return 1;
                        }
                        if (maze[r][c-1].equals(".") || maze[r][c-1].equals("X")) {
                            handC = c - 1;
                            handR = r - 1;
                            c = c - 1;
                            
                            return 1+finish(maze, c, r, handC, handR);
                        }
                        else //if (maze[r+1][c].equals("#"))
                        {
                            handC = c - 1;
                            handR = r;
                            
                            return 1+ finish(maze, c, r, handC, handR);
                        }
                    }
            }
        }
    }
    public void printMaze(String maze[][]){ //This method prints out the maze.
        for(int i =0; i < 12; i++){
            System.out.print("\n");
            for (int j = 0; j < 12; j++) {
                System.out.print(maze[i][j] + " "); 
            }
                       
        }
        System.out.print("\n");
    }
    
}
