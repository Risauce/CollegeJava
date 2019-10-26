/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turtlejava;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author risau
 */
public class Jpanel extends JPanel{
    
    JPanel panel;
    
    BufferedImage grid;
    Graphics2D gc;
    
    Jpanel()
    {
        super();
        panel = new JPanel();
        
    }
    
    
    
    @Override
    public void paintComponent(Graphics g)
    { 
         super.paintComponent(g);  
         Graphics2D g2 = (Graphics2D)g;
         if(grid == null){
            int w = this.getWidth();
            int h = this.getHeight();
            grid = (BufferedImage)(this.createImage(w,h));
            gc = grid.createGraphics();
           
         }
         g2.drawImage(grid, null, 0, 0);
    }
    
    public void draw(int x, int y, int endx, int endy)
    {
        
        gc.drawLine(x, y, endx, endy);
        repaint();
        
    }
    
    
    
    public void color(Color color)
    {
        gc.setColor(color);
    }
    
    public void size(int newSize)
    {
        //Stroke newStroke = Stroke();
        gc.setStroke(new BasicStroke(newSize));
    }
    
    public void clearScreen()
    {
        grid=null;
        repaint();
    }
    
    
    
}
