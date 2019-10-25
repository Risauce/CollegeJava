/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg232inlab1coffee;

/**
 *
 * @author risau
 */
public class Coffee implements Comparable {
    public int price;
    public String company;
    public String color;
    
    Coffee(int price, String distr, String color)
    {
        this.price = price;
        this.company = distr;
        this.color = color;
    }
    
    
    @Override
    public int compareTo(Object temp)
    {
        Coffee otherCoffee = (Coffee) temp;
        
        if (price < otherCoffee.price) { //Check the price, is it less?
            return -1;
        }
        else if (price == otherCoffee.price) { // If the price is the same, then check the company
            if (company.compareTo(otherCoffee.company) < 0) {
                return -1;
            }
            else if (company.compareTo(otherCoffee.company) == 0) {//If the companies are the same, then check the color
                if (color.compareTo(otherCoffee.color) < 0) {
                    return -1;
                }
                else if (color.compareTo(otherCoffee.color) == 0) { //If the colors are the same, they are the same coffee
                    return 0;
                }
                else 
                {
                    return 1; 
                }
                
            }
            else{
                return 1;
            }
        }
        else{
            return 1;
        }
    }
    
    @Override
    public String toString() //Print this instead of data location.
    {
        return "Distributor: " + this.company + " sells " + this.color + " rice at " + this.price;
    }
}
