/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inlab5.linkedlist;

/**
 *
 * @author risau
 */
public class Node {
    private Node next;
    private String name;
    
    public Node(String temp){name = temp;}
    
    public Node getNext(){return next;}
    
    public void setNext(Node temp){next = temp;}
    
    public String toString()
    {
        System.out.print(name);
        return null;
    }
    
    public String getName(){return name;}
    
    
    
    
}
