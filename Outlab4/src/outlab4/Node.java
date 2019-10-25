/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outlab4;
public class Node {
    
    private int id;
    private Node next;
    private Node previous;

    
    
    public Node(int tempcode){
        this.next = null;
        this.previous = null;
        id = tempcode;

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
    

    
}
