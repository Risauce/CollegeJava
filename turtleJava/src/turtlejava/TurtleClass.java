/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turtlejava;

import java.awt.Color;
import javax.swing.JFrame;


/**
 *
 * @author risau
 */
public class TurtleClass extends JFrame{
    Jpanel newPanel = new Jpanel();
    
    
    int x;
    int y;
    double angle;
    
    Color penColor = new Color(0,0,0);
    
    int penSize = 2;
    int speed = 1;
    
    Boolean pendown;
    
    int length = 1000;
    int width = 1000;
    
    TurtleClass()
    {
        super("Turtle Lab");
        
        setSize(length,width);
        x = width/2;
        y = length/2;
        angle=Math.toRadians(0);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        getContentPane().add(newPanel);
        setVisible(true);
        
        pendown=true;
    
    }
    
    public void fd(int distance) //This functions draws a line from a start position to an end position. It calculates the final positions with the knowledge of our angle and start. 
    {
        //For some reason the first time the program turns it is wrong. Cannot figure out why... 
        
        double endX = Math.cos(angle); //Get the cosine and sine values for deciding the direction
        double endY = Math.sin(angle);
        
        System.out.println(endX + " " + endY);
        
        if (pendown) {       
            
            if (endX == 1) {
                newPanel.draw(x, y, (int)(endX*distance) + width/2, y);
                //x = (int)(endX*distance) + width/2;
                
            }            
            else //if(endX != 1 && endY != 1 )
            {
                newPanel.draw(x, y, (int)(endX*distance) + width/2, -(int)(endY*distance) + width/2);
                
            }
        }
        
        x = (int)(endX*distance) + width/2; //Update the position of the X and Y coor. 
        y = -1*(int)(endY*distance) + width/2;
        
        //For some reason this doesn't work!!!! :( its so close.
        
    }
    
    public void right(int rightAngle) //Turn the angle to the right so much.
    {
        
        //Handle turning to the right the proper degrees (convert Radians to degre
        angle = Math.toDegrees(angle);
        angle += -rightAngle;
        
        
        angle = Math.toRadians(angle); //Convert to radians
    }
    
    public void left(int leftAngle)
    {
        //Handle turning to the left the proper degrees (convert Radians to degre
        
        
        
        angle = Math.toDegrees(angle);        
        angle += leftAngle;
        
        System.out.println(angle);
        //angle = (angle%360);
        
        angle = Math.toRadians(angle);
    }
    
    public void penup()
    {        
        pendown = false;
    }
    
    public void pendown()
    {
        pendown=true;
    }
    
    public void home()
    {
        //Go back to center of screen, 0 0 and heading should be Ea
        x = 0;
        y = 0;
        goTo(0,0);
        
        angle = 0;
    }
    
    public void goTo(int nX, int nY)
    {
        //Move to x, y coordinates, draw if pen down the movement. Center of the screen should be considered to be 0,0.........Java sees top right corner of screen as 0, 0, you must do 
        //all the calculations to interpret Java to Turtle coordinate
        
        if (pendown) {
            newPanel.draw(x, y, nX + width/2, -1*nY + length/2);
        }
        x = nX + width/2; //Convert to the cartesian plane
        y = -1*nY + length/2;
        
        System.out.println(angle);
        
    }
    
    public void xcor() //Print the x, y -- Not really used
    {
        System.out.println(x);
    }
    
    public void ycor()
    {
        System.out.println(y);
    }
    
    public void setHeading(Double newAngle) 
    {
        //Change the heading to a 0-359 degrees turn
        /*
        //Allow the user to type in a direction and change the heading
        switch (direction) {
            case "East":
            case "east":
                angle=0;
                
                angle = Math.toRadians(angle);
                break;
            case "South":
            case "south":
                angle=90;
                
                angle = Math.toRadians(angle);
                break;
            case "West":
            case "west":
                angle=180;
                
                angle = Math.toRadians(angle);
                break;
            case "North":
            case "north":
                angle=270;
                
                angle = Math.toRadians(angle);
                break;
            default:
                System.out.println("Incorrect direction.");
                break;

        }
        */
        
        angle = newAngle;
        angle = Math.toRadians(newAngle);
    }
    
    public void speed(int newSpeed)
    {
        //Thread timers to slow down the drawing of the turtle movement(1-5).
        speed = newSpeed;
        
    }
    public void penSize(int newPenSize)
    {
        //Change the size of trail the turtle leave
        penSize = newPenSize;
        
        newPanel.size(penSize);
    }
    
    public void clear()
    {
        //Erase the screen
        newPanel.clearScreen();
        try{Thread.sleep(220);}catch(Exception e){}
    }
    
    public void penColor(int R, int G, int B)
    {
        //Draw with the R, G, B color values given. Should take three (0-255) value
        penColor = new Color(R,G,B);
        newPanel.color(penColor);
    }
    
    
}
