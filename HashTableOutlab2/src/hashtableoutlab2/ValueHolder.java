/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtableoutlab2;

/**
 *
 * @author risau
 */
public class ValueHolder {
    int key;
    String value;
    
    public ValueHolder(int n, String k)
    {
        key = n;
        value = k;
    }
    
    //We don't need to ever change the values, and we can retrive them using .key notation-rather than functions to do so. 
    
    @Override
    public String toString() //Print this instead of data location.
    {
        return key + " " + value;
    }
    
}
