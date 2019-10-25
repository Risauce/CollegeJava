/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inlab6;

/**
 *
 * @author risau
 */
public class Driver {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {       
        
        Heap first = new Heap();
        
        first.insert(15);
        first.insert(5);
        first.insert(8);
        first.insert(4);
        first.insert(9);
        first.insert(22);
        first.insert(17);
        first.insert(6);
        first.insert(14);
                
        first.printHeap();
        
        first.remove();
        first.remove();
        first.printHeap();
        
        first.insert(18);
        first.insert(12);
        first.printHeap();
        
        first.remove();
        first.remove();
        first.remove();
        first.printHeap();
        
    }
    
}
