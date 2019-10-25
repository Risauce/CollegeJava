/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outlab3;


public class Node {
    
    private int id;
    private String lastName;
    private String firstName;
    private Node next;
    private Node previous;
    
    
    public Node(int tempcode, String tempLast, String tempFirst){
        this.next = null;
        this.previous = null;
        id = tempcode;
        lastName = tempLast;
        firstName = tempFirst; 
    }
    
    public void setNext(Node temp){
        next = temp;
    }
    
    public void setPrevious(Node temp){
        this.previous = temp;
    }
    
    public Node getPrevious(){
        return previous;
    }
    
    public Node getNext(){
        return next;
    }
    
    public int getID(){
        return id;
    }
    
    public String getLast(){
        return lastName;
    }
    
    public String getFirst(){
        return firstName;
    }
}
