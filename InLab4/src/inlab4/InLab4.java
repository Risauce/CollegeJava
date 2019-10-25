/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inlab4;

/**
 *
 * @author risau
 */
public class InLab4 {

    public static void main(String [] args)
 {
 Person pOne = new Person("First");
 Person pTwo = new Person("Second");
 int a = 5;
 pOne = pTwo.changeName(pTwo, pOne, a);
 System.out.println(pOne.getName()); //8
 System.out.println(a); //9
 System.out.println( pTwo.getName()); //10

 }
}