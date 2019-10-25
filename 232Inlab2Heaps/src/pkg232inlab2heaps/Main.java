/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg232inlab2heaps;

/**
 *
 * @author risau
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HeapManager first = new HeapManager();
        
        first.add(12);
        first.add(45);
        first.add(21);
        first.add(5);
        first.add(21);
        first.add(10);
        first.add(3);
        first.add(55);
        first.add(15);
                
        first.printHeap();
        
        first.remove();        
        first.remove();
        
        first.printHeap();
        
        first.add(32);
        first.add(6);
        
        first.printHeap();
        
        first.remove();        
        first.remove();        
        first.remove();
        first.remove();
        
        first.printHeap();
    }
    
}
