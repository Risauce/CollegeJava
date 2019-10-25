/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introtoreferences;

/**
 *
 * @author risau
 */
public class Eagles {
    Losers myLosers[];
    
    Eagles()
    {
        Losers first = new Losers();
        myLosers = new Losers[4];
        
        for (int i = 0; i < 4; i++) 
        {
            myLosers [i] = new Losers();
        }
        
    }
            
            
}
