/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package affinecipher;

/**
 *
 * @author risau
 */
public class AffineCipher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Affine(21,26);
    }
    
    public static void Affine(int a, int b){
	  for (int num = 0; num < 26; num++)
	   System.out.println(((char)('A'+num)) + ":" + ((char)('A'+(a*num + b)% 26)) );
	}

    
}
