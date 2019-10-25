package outlab3;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class LLManager{
    Node first;

    
    private Scanner fin;

    //-----------------
    LLManager(){
        first = null;
        try{
            fin = new Scanner(new File("input.dat")); //Don't crash if we have a file read error
        }
        catch(FileNotFoundException e){
                System.err.println("Opening File Error");
        }
    }
    
    //-----------------------------------------------------
    public void readFile(){     //Option 1 - Reads in file, then calls add to create nodes.
    
       while(fin.hasNextLine()){
           String x = fin.nextLine();
           String[] words = x.split(",");
           
           for(String i : words){
                i = i.trim();
                
            }
           
           Integer number = new Integer(words[0]);
           
           this.addInOrder(number, words[1], words[2]);
           
       }
       System.out.println("\nFile read.\n");
    }
    
    //----------------------------------------------------------
    public void addInOrder(int id, String last, String firstName) {      //Option 2 - Adds a new node to the linked list.
        Node n = new Node(id, last, firstName);

        if (first == null) { //If there is no list yet, set first
            first = n;
            first.setNext(null);
            return;
        }

        Node current = first;
        Node temp = null;

        while (current != null && current.getID() < n.getID()) { //Go through whole thing and stop once we find where we need to put it
            temp = current;
            current = current.getNext();
        }

        if (n.getID() < first.getID() || n.getID() == first.getID()) { //If the ID is less than the first ID, switch around first 
            if (n.getID() == first.getID()) {
                if (n.getLast().compareTo(first.getLast()) < 0) {
                    n.setNext(first);
                    first = n;
                }
                else
                {
                    n.setNext(first.getNext());
                    first.setNext(n);
                }
            }
            else
            {
                n.setNext(first);
                first = n;
            }
                      
            return;
        }

        if (temp == null) { //To make sure there isn't a null pointer
            n.setNext(current);
            return;
        }

        if (current != null && current.getID() == n.getID()) { //If the IDs are the same, organize them correctly
            
            if (current.getLast().compareTo(n.getLast()) < 0) {
                if (temp.getLast().compareTo(n.getLast()) > 0) { //This should allow for triple comparison (if 3 IDs are the same)
                                     
                    n.setNext(current);
                    temp.setNext(n);
                    return;
                }
                else
                {                
                    n.setNext(current.getNext());
                    current.setNext(n);
                }
                return;
            }
        }

        n.setNext(current);
        temp.setNext(n);
        return;
    }
    
    //--------------------------------------------------------
    public int getLengthRecursive(Node iter) {
        if (iter == null) {
            return 0;
        } else {
            return 1 + getLengthRecursive(iter.getNext());
        }
    }
    
    
    
    //---------------------------------------------------------
    public void add(int id, String last, String firstName){      //Option 2 - Adds a new node to the linked list (at the end)
        Node n = new Node(id, last, firstName);
        Node iter = first;
    
        if(iter == null){
                first = n;
                first.setNext(null);
        }
        else {
            while(iter.getNext() != null){
                iter = iter.getNext();
                
            }
            // Adds a new node at the end of list.
            //inOrder(n);
            iter.setNext(n);
        }
    
    }
    
    //-----------------------------------------
    public void printList(){    //Option 3 - Prints list in ascending order by ID or Last name.
        Node iterator = first;
   
        System.out.println(this.getLengthRecursive(first));
        while(iterator != null){
            System.out.println(iterator.getID() + " " +  iterator.getLast() + " " + iterator.getFirst() + "\n");
            iterator = iterator.getNext();
        }
    }
    
    //-----------------------------------------------------
    public void printBackwards(){ //Option 4 - Prints list in opposite decending order by ID or Last name.
        Node iterator = first;
        //Node next = iterator.getNext();
        
        while(iterator != null){
            //reverse();
            System.out.println(iterator.getID() + " " +  iterator.getLast() + " " + iterator.getFirst() + "\n");
            iterator = iterator.getNext();
        }
    }
//----------------------------------------------------------
    public boolean delete(String temp){   //Option 5 - Deletes a node based on last name from user input.
        Node iter = first;
        Node lagptr;
        Node after;
        
        
        while(iter != null && !temp.equals(iter.getLast()) && iter != first){ //This is never called, primitive delete. 
           
           iter = iter.getNext();
                       
        }
        
        if (iter != first) {
            lagptr = iter.getPrevious();
            after = iter.getNext();
            
            lagptr.setNext(after);
            after.setPrevious(lagptr);
            return true;
        }
        
        return false;
    } 
    
    //------------------------------------------------------
    public void deleteList(){   //Option 6 - Deletes the entire list.
        first = null;
        System.out.println("\nList deleted.\n");
    }
    
    
    //----------------------------------------------------
    public int length(Node first) //Just returns the list length
    {
        if (first == null) {
            return 0;
        }
        int count = 0; //This will hold the length
        
        Node iter = first; 
        
        while(iter != null) //Iterate through the whole list
        {
            count++;
            iter = iter.getNext();
        }
        return count;
    }
   
    //------------------------------------------------
    public Node deleteAtPosition(int position) //Advanced delete that deletes the node at specified position
    {
        int size = this.length(first);
        if (position > size || position < 1) { //If it is not a valid location
            System.out.println("Invalid Position");
            return first;            
        }
        
        if (position == 1) { //If we are trying to delete the first pos node, switch first around
            Node temp = first;
            first = first.getNext();
            temp.setNext(null);
            return temp;
        }
        else
        {
            Node previous = first;
            int count = 1;
            while(count < position -1) //Go to the position 
            {
                previous = previous.getNext();
                count++;
            }
            Node current = previous.getNext(); //And chance rereference everything to remove the specified node
            previous.setNext(current.getNext());
            current.setNext(null);
            return current;
        }
    }
//------------------------------------------------------
public Node reverse(){ //inverse the nodes
        if(first == null){
            return first;
        }
        Node current = first;
        Node previous = null;
        Node next = null;
        
        while(current != null){
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        return previous;
    }
    
    //-------------------------------------------------
    public void printBackwards(Node first){ //Option 4 - Prints list in opposite decending order by ID or Last name.
        if(first == null){
            return;
        } 
        Node iterator = first;
        
        while(iterator != null){
            //reverse();
            System.out.println(iterator.getID() + " " +  iterator.getLast() + " " + iterator.getFirst() + "\n");
            iterator = iterator.getNext();
        }
    }



//--------------------------------------------------------- Old attempted addinorders below. 
    /*
    public void addInOrder(Node data) {
        Node iter = first;
        Node addNode = data;

        if (iter == null) { //If the list is empty,
            this.add(data.getID(), data.getLast(), data.getFirst());
            return;
        }
        
        if (iter.getNext() == null) { //If there is only the first node,
            if (iter.getID() > addNode.getID()) { //And the one to enter is less than,
                addNode.setNext(iter);
                first = addNode;
                addNode.getNext().setPrevious(addNode);
                System.out.println("Added one");
                return;
            }
            else{
                //this.add(addNode); //Else throw it on the end.
                Node after = iter.getNext();
                after.setPrevious(addNode);
                iter.setNext(addNode);
                addNode.setNext(after);
                addNode.setPrevious(iter);
                
                System.out.println("Added");
                return;
            }
        }
        else
        {
            while(iter != null)
            {
                if (iter.getID() > addNode.getID()) {
                    
                    addNode.setNext(iter);
                    addNode.setPrevious(iter.getPrevious());
                    iter.getPrevious().setNext(addNode);
                    System.out.println("Added one conditionally");
                    return;
                }
                else
                    iter = iter.getNext();
            }
            System.out.println("Got to end");
            iter.setNext(addNode);
            addNode.setPrevious(iter);
        }

    }
    */
    
    /*
    //---------------------------------------------
   public void addInOrder (Node data)
    {
        
        Node iter = first;
    
        if (iter == null) {
            first = data;
            first.setNext(null);
            
        
        } else {
            Node before;
            Node after = iter.getNext();

            if (after == null) {
                System.out.println("NULLLLLL");
                this.add(data);
                this.printList();
            } else {

                Integer firstID = data.getID();
                Integer secondID;

                try {
                    secondID = after.getID();
                } catch (Exception e) {
                    secondID = 0;
                }

                if (Objects.equals(firstID, secondID)) {

                    String oneLast = data.getLast();
                    String secondLast;

                    try {
                        secondLast = after.getLast();
                    } catch (Exception e) {
                        secondLast = "";
                    }

                    while (oneLast.compareTo(secondLast) < 0) {
                        after = after.getNext();
                    }
                } else {

                    while (firstID.compareTo(secondID) < 0) {
                        after = after.getNext();
                    }
                }

                before = after.getPrevious();
                data.setNext(after);
                data.setPrevious(before);
                before.setNext(data);
                after.setPrevious(data);

            }
        }*/
    }

