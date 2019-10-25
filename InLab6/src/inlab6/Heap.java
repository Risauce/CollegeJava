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
public class Heap {
    
    int N=0;    
    private static int[] heapArray = new int[25];
        
    public void insert(int item)
    {
        heapArray[N] = item;
        if (N != 0) {
            shuffle(N);
        }
        N++;
    }
    
    public void remove()
    {
        int item = heapArray[0];
        swap(0, N-1);
        N--;
        heapArray[N] = 0;
        upkeepMin(0);
    }
    
    private void shuffle(int index)
    {
        int parent = (index-1)/2;
        
        if (heapArray[index] < heapArray[parent]) {
            swap(index, parent);
            shuffle(parent);
        }
    }
    
    private void swap (int a, int b)
    {
        int temp;
        temp = heapArray[a];
        heapArray[a] = heapArray[b];
        heapArray[b] = temp;        
    }
    
    private void upkeepMin(int parentIndex)
    {
        int leftChild = (parentIndex *2) + 1;
        int rightChild = (parentIndex *2) +2;
        
        if (heapArray[leftChild] < heapArray[rightChild] && rightChild < N && leftChild < N) {
            if (heapArray[leftChild] != 0) {
                swap(leftChild, parentIndex);
                upkeepMin(leftChild);
            }
            else
            {
                if (heapArray[rightChild] != 0) {
                    swap(rightChild, parentIndex);
                    upkeepMin(rightChild);
                }
            }
        }
    }
    
    public void printHeap()
    {
        
        for (int i = 0; i < N; i++) {
            if (i == 1 || i == 3 || i == 7 || i == 15) {
                System.out.print("\n");
            }
            System.out.print(heapArray[i] + " ");
        }
        System.out.println("\n");
        
        /*
        for (int i = 0; i < heapSize; i++) {
            if (heapArray[i] != 0) {
                System.out.print(heapArray[i] + " ");
            }
        }
        System.out.print("\n");
        */
    }
    
    /*
    void upkeepMin(int arr[], int i, int N)
    {
        int parent = ((i - 1) / 2);
        int leftChild = (i * 2) + 1;
        int rightChild = leftChild + 1;
        
        int smallest;
        if (leftChild <= N && arr[leftChild] < arr[i]) {
            smallest = leftChild;
        }
        else
            smallest = i;
        if (rightChild <= N && arr[rightChild] < arr[smallest]) {
            smallest = rightChild;
        }
        if (smallest != i) {
            swap(arr, i, smallest);
            upkeepMin(arr, smallest, N);
        }      
    }
    
    public boolean insert(int ele)
    {
        if (heapSize + 1 == N) {
            return false;
        }
        heapArray[++heapSize] = ele;
        int pos = heapSize;
        while(pos !=1 && ele < heapArray[pos/2])
        {
            heapArray[pos] = heapArray[pos/2];
            pos /= 2;
        }
        heapArray[pos] = ele;
        
        return true;
    }
    
    public int remove()
    {
        int parent, child;
        int item, temp;
        
        int size = heapArray.length - 1;
        if (size - 1 == 0) {
            System.out.println("The heap is empty.");
            return -1;            
        }
        
        item = heapArray[1];
        temp = heapArray[size-1];
        heapSize--;
        
        parent =1;
        child = 2;
        
        while(child <= size)
        {
            if (child < size && heapArray[child] < heapArray[child+1]) {
                child++;
            }
            if (temp >= heapArray[child]) {
                break;
            }
            heapArray[parent] = heapArray[child];
            parent = child;
            child *=2;
            
        }
        heapArray[parent] = temp;
        //upkeepMin(heapArray, 1, N);
        return item;
    }
    
    public void display()
    {
        for (int i = 0; i < N; i++) {
            if (heapArray[i] != 0) {
                System.out.print(heapArray[i] + " ");
            }
        }
        System.out.print("\n");
    }
    */
}
