/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugofwar232;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author risau
 */
public class TugOfWar232 {

    /**
     * @param args the command line arguments
     */
    
    static Scanner fin;
    static PrintWriter fout;
    
    
    public static void main(String [] args)
{

    int weightMax;
    ComputeTeams weights;   
    

    while (true) { //Read the file!
            try {
                fin = new Scanner(new File("fin.in")); //Don't crash if we have a file read error
                fout = new PrintWriter (new File ("balanced.out"));
                
                break;
            } catch (FileNotFoundException e) {
                System.err.println("Opening File Error");
                break;
            }
        }
    
    int numberChildren;
    while (fin.hasNext())
    {


        numberChildren = fin.nextInt();
        
        
        weightMax = fin.nextInt();
        
        
        weights = new ComputeTeams(numberChildren, weightMax);
        int w[] = weights.readWeights(fin);
        int num = weights.findMin(w, numberChildren);
        System.out.println(num);
        
        if (fin.hasNext())
        {

            fout.println();

        }

    }

    fout.close();

    }
}
