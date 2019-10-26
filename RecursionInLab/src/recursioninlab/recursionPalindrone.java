/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursioninlab;

/**
 *
 * @author risau
 */
public class recursionPalindrone {
    
    public boolean palindrone(String input)
    {
        if (input.length() == 0 || input.length() == 1) {
            return true;
        }
        if(input.charAt(0) == input.charAt(input.length() - 1))
        {
            return palindrone(input.substring(1, input.length()-1));
        }
        return false;
    }
}
