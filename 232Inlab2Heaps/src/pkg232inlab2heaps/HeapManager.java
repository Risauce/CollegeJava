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
public class HeapManager {
    int[] array = new int[25];
    int size= 0;
    
    
    private void swap(int pos1, int pos2)
    {
        int temp = array[pos1];
        
        array[pos1] = array[pos2];
        array[pos2] = temp;
    }
    public void add(int item)
    {   
        boolean isIn = false;
        for (int i = 0; i < size; i++) {
            if (array[i] == item) {
                isIn = true;
                break;
            }
        }
        
        if (isIn) {
            return;
        }
        array[size] = item;
        if (size != 0) {
            shuffle(size);
        }
        size++;
    }

    private void shuffle(int index)
    {
        int parent = (index-1)/2;
        
        if (array[index] < array[parent]) {
            swap(index, parent);
            shuffle(parent);
        }
    }
    
    public void remove()
    {        
        swap(0, size-1);
        size--;
        array[size] = 0;
        upkeepMin(0);
    }
    
private void upkeepMin(int parentIndex)
    {
        int leftChild = (parentIndex *2) + 1;
        int rightChild = (parentIndex *2) +2;
        
        
        
        if (array[leftChild] < array[parentIndex] && rightChild < size && leftChild < size) {
            //System.out.println("Made it");
            if (array[leftChild] < array[rightChild]) {
                swap(leftChild, parentIndex);
                upkeepMin(leftChild);
            }
            else
            {
                if (array[rightChild] != 0) {
                    swap(rightChild, parentIndex);
                    upkeepMin(rightChild);
                }
            }
        }
        else if (array[rightChild] < array[parentIndex] && rightChild < size && leftChild < size) {
            if (array[leftChild] != 0) {
                swap(leftChild, parentIndex);
                upkeepMin(leftChild);
            }
            else
            {
                if (array[rightChild] != 0) {
                    swap(rightChild, parentIndex);
                    upkeepMin(rightChild);
                }
            }
        }
    }
    
    public void printHeap()
    {
        
        for (int i = 0; i < size; i++) {
            if (i == 1 || i == 3 || i == 7 || i == 15) {
                System.out.print("\n");
            }
            System.out.print(array[i] + " ");
        }
        System.out.println("\n");
        
    }
    
    
}
