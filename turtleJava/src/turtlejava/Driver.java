/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turtlejava;

/**
 *
 * @author risau
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TurtleClass jimmy = new TurtleClass();
        
        try{Thread.sleep(220);}catch(Exception e){} //To make sure it has enough time to create the canvas!
        
        
        
        
        jimmy.penColor(255,255,0);
        jimmy.penSize(5);
        
        int sides = 8;
        int length = 55;
        
        for (int i = 0; i < sides; i++) {
            jimmy.fd(length);
            jimmy.left(360/sides);
            try{Thread.sleep(400);}catch(Exception e){}
            
        }
        
        jimmy.penup();
        jimmy.goTo(-30,-25);
        jimmy.pendown();
        jimmy.penColor(0,0,255);
        jimmy.fd(125);
        

        
        System.out.println(Math.cos(Math.toRadians(45)));               
        
    }
    
}
