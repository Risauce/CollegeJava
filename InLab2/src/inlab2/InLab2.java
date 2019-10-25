/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inlab2;

/**
 *
 * @author risau
 */
public class InLab2 {
    int length;
    int width;

    
    public InLab2(int l, int w) //for rect
    {
        length = l;
        width = w;
    }
    
    public InLab2(int l)
    {
        length = l; //radius
        width = 0;
    }
    
    public double calcCircle()
    {
        double pi = 3.14;
        
        if (length < 0) {
            System.out.println("You cannot have a negative radius.");
            
        }
        
        double area = (length * pi * length);
        
        
        
        return area;
    }
    
    public int calcRect()
    {
        int area = length * width;
        if (area <= 0) {
            System.out.println("That is an invalid area");
        }
        
        return area;
    }
    
    public void changeLength(int num)
    {
        length += num;
    }
    
    public static void main(String[] args) {
        InLab2 r = new InLab2(6,7);
        InLab2 c = new InLab2(7);
        
        c.changeLength(-10);
        r.changeLength(-9);
        
        double circleAnswer = c.calcCircle();
        int rectAnswer = r.calcRect();
        
        System.out.println("The circle area: " + circleAnswer + "\nThe Rectangular area: " + rectAnswer);
    }
}
