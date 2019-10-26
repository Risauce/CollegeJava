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
public class RecursionInLab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        recursionPalindrone first = new recursionPalindrone();
        commonD second = new commonD();
        
        boolean yay = first.palindrone("anna");
        System.out.println(yay);
        yay = first.palindrone("bob");
        System.out.println(yay);
        yay = first.palindrone("john");
        System.out.println(yay);
        yay = first.palindrone("riley");
        System.out.println(yay);
        yay = first.palindrone("Anna");
        
        System.out.println(yay);
        
        
        int num = second.commonDivisor(12, 36);
        System.out.println(num);
        
    }
    
    
}
