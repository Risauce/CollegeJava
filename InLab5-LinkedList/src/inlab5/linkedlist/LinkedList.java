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
public class LinkedList {
    Node first;
    
    public LinkedList(){
        first = null;
    }
    
    void add(String temp){
        //adding to the end
        
        Node n = new Node(temp);
        Node iter = first;
        
        
        if(iter == null) {
            first = n;
            first.setNext(null);
        }
        else {
            while(iter.getNext() != null)
                iter = iter.getNext();

            // add new node at the end
        Node toAppend = new Node(temp);
            iter.setNext(toAppend);
        }
        

    }

        
        
    
    
    boolean delete(String temp)
    {
        Node iter = first;
        Node lagptr = first;
        
        
        while(iter != null)
        {
            if (iter.getName().equals(temp)) {
                //delete
                if (iter == first) {
                    first = first.getNext();
                }
                else{
                lagptr.setNext(iter.getNext());
                }
                return true;
            }
            lagptr = iter;
            iter = iter.getNext();
        }
        
        return false;
    }
    
    void print(){
        Node iterator = first;
        
        while(iterator != null)
        {
            System.out.println(iterator.getName());
            System.out.println("");
            iterator = iterator.getNext();
        }
    }
    
    void deleteList(){first = null;}
}
