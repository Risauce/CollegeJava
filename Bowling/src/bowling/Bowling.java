/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowling;

/*
 * -------------------------
 * Outlab 2, CSCI132
 * Bowling Scoring Program
 * @authors William Riley Roberts & Anna Jinneman
 * Program finished 2/19/2018
 * -------------------------
 * This program will simulate 10-11 frames of bowling. There will be a random number chosen from an array for 
 * the first roll in a frame. The second roll in a frame will be a random number based on how many pins are
 * left. The program will keep track of a cumulative bowling score, and will calculate spares and strikes 
 * according to the rules of bowling.
 * -------------------------
 */

import java.util.Random;
public class Bowling {
    
    Random rand;  
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        
        Frame first = new Frame();
        Frame second = new Frame();
        Frame third = new Frame();
        
        first.play();
        second.play();
        third.play();
    }
    
    
    
}
