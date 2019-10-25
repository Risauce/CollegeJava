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
public class Movement {
    
    double x, y, z;
    int speed;
    
    Movement(int one, int two, int three)
    {
            x = one;
            y = two;
            z = three;
            speed = 0;
               
    }
    
    public int getLocation()
    {
        //returns the drones location in terms of x, y, z
    }
    
    public void goTo(double x, double y, double z)
    {
        //Tells the drone to go to position x, y, z
    }
    
    public void changeHeight(double y)
    {
        //Tells the drone to just change the height (y)
    }
    
    public void changeSpeed(int fast)
    {
        speed = fast;
        //Changes the speed to the inputted value
        
    }
}
