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
public class commonD {
    
    public int commonDivisor(int num1, int num2)
    {
        if (num1 % num2 == 0) {
            return num2;
        }
        else { //if (num1 % num2 != 0)
            return commonDivisor(num2, num1%num2);
        }
    }
    
}
