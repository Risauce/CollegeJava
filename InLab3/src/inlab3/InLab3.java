/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inlab3;

/**
 *
 * @author risau
 */
public class InLab3 {

    public static void main(String[] args) 
    {
        int arg[] = {0, 4, 6, 7}, x;
        for(x = arg.length; x>0; x++);
            System.out.println(--x);
            
       compute_value(60);
    }
    
    public static int compute_value(int integer_value) {
 // Declare Local Variables
 boolean done = false;
 int count = 1;
 int current = integer_value + 2;
 // While loop
 while (! done) {
 current = current / count;
 if (current % 3 == 0)
 done = true;
 else if (current < 1)
 done = true;
 else
 count += 1;
 System.out.println(current);
 }
 System.out.println(count);
 return count;
} // method compute_value 
    
    public void takePicture()
    {
        //Tells the hardware to take a picture. 
    }
    
    
    
    
    
}
