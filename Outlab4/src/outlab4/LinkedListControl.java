/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outlab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


/**
 *
 * @author risau
 */
public class LinkedListControl {

    Scanner fin;
    Node first;
    Node end;
    int size;

    int n;
    int cw;
    int cc;

    public LinkedListControl() {
        first = null;
        end = null;
        size = 0;

        Scanner reader = new Scanner(System.in);

        System.out.println("What is the file you would like to read from?");
        String inFile = reader.next();
        while (true) {
            try {
                fin = new Scanner(new File(inFile)); //Don't crash if we have a file read error
                break;
            } catch (FileNotFoundException e) {
                System.err.println("Opening File Error");
                break;
            }
        }

    }
    
    public LinkedListControl(int skipper) //We use this to make lists without reading from a file -mainly just to hold the winners
    {
        first = null;
        end = null;
        size = 0;
    }

    public void addFromFile() { //This method takes the string values from the value and makes them integers for use. 

        String x = fin.nextLine();
        String[] numbers = x.split(" ");

        n = new Integer(numbers[0]);
        cw = new Integer(numbers[1]);
        cc = new Integer(numbers[2]);

        for (int i = 0; i < n; i++) {
            this.add(i + 1);
        }
    }

    public void add(int id) {      //Adds a new node to the end of the linked list. (replaces the last node)
        Node n = new Node(id);
        Node iter = first;

        if (iter == null) {//If the list is empty,
            n.setNext(n);
            n.setPrevious(n);
            first = n;
            end = first;

        } else {
            n.setPrevious(end);
            end.setNext(n);
            
            first.setPrevious(n);
            n.setNext(first);
            end = n;
        }
        size++;

    }

    public void printList() {
        Node iterator = first;
        System.out.println("Printing the list:");

        for (int i = 0; i < size; i++) {
            System.out.println(iterator.getID() + "\n");
            iterator = iterator.getNext();
        }
        
        System.out.println("----------------");
    }
    

    
    public void deletePos(int pos)
    {
        if (pos == 1) { //If we want to remove the first one
            if (size == 1) { //If there is only the first one
                first = null;
                end = null;
                size = 0;
                return;
            }
            first = first.getNext();
            first.setPrevious(end);
            end.setNext(first);
            size--;
            return;
        }
        if (pos == size) {//if we want to remove the last one
            end = end.getPrevious();
            end.setNext(first);
            first.setPrevious(end);
            size--;
            return;
        }
        Node iter = first.getNext();
        for (int i = 2; i <= size; i++) {//go until we get to the desired pos
            if (i == pos) {
                Node behind = iter.getPrevious();
                Node ahead = iter.getNext();
                
                //Exclude the one in the middle
                behind.setNext(ahead);
                ahead.setPrevious(behind);
                size--;
                return;
            }
            iter = iter.getNext();
        }
    }
    
    public void deleteNode(Node deleteThis) //This deletes the target node
    {
        if (first.getID() == deleteThis.getID()) { //If we want to remove the first node,
            if (first.getNext() == first) { //And there is only the first one,
                first = null;
                end = null;
                size = 0;
                return;
            }
            first = first.getNext();
            first.setPrevious(end);
            end.setNext(first);
            size--;
            return;
        }
        if (end.getID() == deleteThis.getID()) {//If we want to remove the last node
            if (end.getNext() == end) {//Then we want to delete the only node
                first = null;
                end = null;
                size = 0;
                return;
            }
            end = end.getPrevious();
            end.setNext(first);
            first.setPrevious(end);
            size--;
            return;
        }
        
        Node iter = first.getNext();
        for (int i = 2; i <= size; i++) {//go until we get to the desired pos
            if (iter.getID() == deleteThis.getID()) {
                Node behind = iter.getPrevious();
                Node ahead = iter.getNext();
                
                //Exclude the one in the middle
                behind.setNext(ahead);
                ahead.setPrevious(behind);
                size--;
                return;
            }
            iter = iter.getNext();
        }
    }
    
    public int getNodePosition(Node temp) //This method finds and returns a node's position
    {
        Node iter = first;
        int counter = 1;
        
        for (int i = 0; i < size; i++) {
            if (iter.getID() == temp.getID()) {
                break;
            }
            counter++;
            iter = iter.getNext();
        }
        return counter;
    }

    public void election(PrintWriter writer) {
        
            LinkedListControl winnerList = new LinkedListControl(5);
            
            Node clockW = first;
            Node counterC = end;
            
            Node clockHolder;
            Node counterHolder;
            
            writer.println("N = " + n + ", k = " + cw + ", m = " + cc + "\n");
            writer.println("Output\n-------");
            
            while (true) {
                
                if (size == 0) {
                    
                    break;
                }
                if (size == 1) {//If there is only one left, that one is elected.
                    writer.println(clockW.getID());
                    winnerList.add(clockW.getID());
                    
                    break;
                }
                
                //Move the pointers along
                for (int i = 1; i < cw; i++) {
                    clockW = clockW.getNext();
                }
                for (int i = 1; i < cc; i++) {
                    counterC = counterC.getPrevious();
                }
                
                if (clockW.getID() == counterC.getID()) //If they are on the same one
                {
                    winnerList.add(clockW.getID());

                    writer.println(clockW.getID());
                    clockHolder = clockW; //Hold the node that is supposed to be deleted
                    
                    clockW = clockW.getNext(); //Move the pointers along.
                    counterC = counterC.getPrevious();
                    
                    this.deleteNode(clockHolder); //Delete it
                    
                } else//if they are on different ones
                {
                    writer.println(clockW.getID() + " " + counterC.getID()); //Show the two selected.
                    
                    clockHolder = clockW; //Save the two before moving them
                    counterHolder = counterC;
                    
                    clockW = clockW.getNext();
                    counterC = counterC.getPrevious();
                    
                    this.deleteNode(clockHolder); //Delete the saved nodes
                    this.deleteNode(counterHolder);
                    
                }
            }
        
        writer.println();

    }
}
