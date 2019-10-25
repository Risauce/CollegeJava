/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3graphs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author risau
 */
public class GraphController {
    
    Scanner fin;
    int[][] adjencyMatrix; //This is our 2D adjency matrix, holding the weight values
    
    int numV; //Our number of vertices
    
    LinkedList<Integer> adjencyList[]; //This will contain all our vertices. A list of linked lists
        
    //---------------------------------------------------------------------------------------
    
    public GraphController(int size)
    {
        while (true) { //Read the file!
            try {
                fin = new Scanner(new File("graph.txt")); //Don't crash if we have a file read error
                break;
            } catch (FileNotFoundException e) {
                System.err.println("Opening File Error");
                break;
            }
        }
        
        
        //Initialize our variables - general to any number of vertices
        numV = size;
        adjencyMatrix = new int[size][size];
        adjencyList = new LinkedList[size]; //This is an array of linked lists with all our edges. 
        
        for (int i = 0; i < size; i++) { 
            adjencyList[i] = new LinkedList<>();
        }
        
    }
        
    //---------------------------------------------------------------------------------------
    
    public void addEdge(int source, int toAdd)
    {
        adjencyList[source].add(toAdd); //Adds a new edge from a source already in the array and creates an edge to a new vertex.
        
        adjencyList[toAdd].add(source); //Undirected - said we can assume symmetrical graphs
    }
        
    //---------------------------------------------------------------------------------------
    
    public void insertToArray() //This reads the input file, taking a number of rows, cols (i, j), and copying the lines and sparsing it into our adjency matrix
    {       
        
        for (int i = 0; i < numV; i++) {
            String toSplit = fin.nextLine();
            String[] weights = toSplit.trim().split("\\s+");
            for (int j = 0; j < numV; j++) {
                adjencyMatrix[i][j] = Integer.parseInt(weights[j]); //Create each node individually in our adjency matrix - copies over from the file.
                if (adjencyMatrix[i][j] > 0) { //At the same time we create the adjency matrix we can add the edges to our linked list array. 
                    this.addEdge(i, j);
                }
            }
        }        
    }
        
   
       
    //---------------------------------------------------------------------------------------
    
    
    
    public void breadthSearch(int source) //Uses our list of edges to find the paths through the adjency matrix
    {
        LinkedList<Integer> theQueue = new LinkedList<Integer>(); //This is a linked list queue, not a traditional queue
        
        boolean[] visited = new boolean[numV]; //To hold our visiited values so we do not go over them again. 
        
        System.out.println("\nBreadth first Search:");
        
        theQueue.add(source);
        visited[source] = true;
        
        while(theQueue.size() != 0)
        {
            source = theQueue.poll();
            System.out.print(source + " ");
            Iterator<Integer> i = adjencyList[source].listIterator(); //Creates an iterator on our one list, looking at each edge for a node. This is not greedy, but we were not required to.
            while(i.hasNext())
            {
                
                int nextOne = i.next();
                if (!visited[nextOne]) {
                    visited[nextOne] = true;
                    theQueue.add(nextOne);
                }
                
            }
        }
        
    }
        
    //---------------------------------------------------------------------------------------
    
    public void depthSearch(int start) //This function is used only to hold the visited array for recursive calls of recursiveDepth. 
    {
        boolean[] visited = new boolean[numV];
        System.out.println("\nDepth first Search: ");
        recursiveDepth(start, visited);
        
        
    }
        
    //---------------------------------------------------------------------------------------
    
    public void recursiveDepth(int source, boolean[] visited) //Takes in an array, so that it wont get overidden by a recursive call. This follows one path as long as it can, then backtracks if neccasary. 
    {              
        
        visited[source] = true;
 
        System.out.print(source + " ");
        Iterator<Integer> i = adjencyList[source].listIterator();
            while(i.hasNext())
            {
                
                int nextOne = i.next();
                if (!visited[nextOne]) {
                    visited[nextOne] = true;
                    recursiveDepth(nextOne, visited);
                }
                
            }
        
    }
    
        
    //---------------------------------------------------------------------------------------
    
    
    public void dijkstra(int source) //Find shortest path from a vertex to all other vertices
    {
        int distances[] = new int[numV]; //This holds ALL of the distances from the source to other vertices
        
        boolean shortOne[] = new boolean[numV]; //This is where we place nodes that ARE the shortest paths. It says true for the vertex position if it is a lower weight
        
        for (int i = 0; i < numV; i++) { //Default the distances to their highest values, meaning no connection
            distances[i] = Integer.MAX_VALUE;            
        }
        
        distances[source] = 0; //Because the distance from something to itself is zero
        
        for (int i = 0; i < numV-1; i++) {
            int small = Integer.MAX_VALUE, minIndex = -1;
            
            for (int j = 0; j < numV; j++) {
                if (!shortOne[j] && distances[j] <= small) { //Update the smallest if we find one thats smaller
                    small = distances[j];
                    minIndex = j;
                }               
            }
            
            shortOne[minIndex] = true; //We have now visited the smallest weighted node. 
            
            for (int v = 0; v < numV; v++) {
                
                //As long as we havn't visited it yet, it isnt infinity, and the paths between two different nodes is smaller than just the one, then update it to have the distance of the two smaller paths
                if (!shortOne[v] && 
                        adjencyMatrix[minIndex][v]!=0 &&
                        distances[minIndex]!= Integer.MAX_VALUE &&
                        distances[minIndex] + adjencyMatrix[minIndex][v] < distances[v])
                {
                    distances[v] = distances[minIndex] + adjencyMatrix[minIndex][v];
                }
            }           
            
            
        }
        System.out.println("\n\nDjikstra's Greedy Algorithm:");
        for (int j = 0; j < numV; j++) {
                System.out.println(j + " distance from source: " + distances[j]);
            }
        
    }
        
    //---------------------------------------------------------------------------------------
    
    public void prims() //Minimum spanning tree
    {
        
        int minEdge[] = new int[numV];
        int finishedTree[] = new int[numV]; //This is the minimum spanning tree once done
        boolean shortOne[] = new boolean[numV];  //Whether or not its included yet
        
        for (int i = 0; i < numV; i++) {
            minEdge[i] = Integer.MAX_VALUE; //Set all the smallest distances to infinity so if we have any number at all it is smaller
            
        }
        
        minEdge[0] = 0; //The distance of the first node to itself 
        finishedTree[0] = -1; //Make the first node the root of tree
        
        for (int i = 0; i < numV-1; i++) {
            
            int small = Integer.MAX_VALUE, minIndex = -1;
            for (int j = 0; j < numV; j++) {
                if (!shortOne[j] && minEdge[j] <= small) {
                    small = minEdge[j];
                    minIndex = j;
                }               
            }
            
            shortOne[minIndex] = true;
            
            for (int v = 0; v < numV; v++) {             
                
                if (adjencyMatrix[minIndex][v]!=0 &&
                        !shortOne[v] &&
                        adjencyMatrix[minIndex][v] < minEdge[v]) 
                {
                    finishedTree[v] = minIndex;
                    minEdge[v] = adjencyMatrix[minIndex][v];
                }
            }
            
        }
        System.out.println("\nPrim's Minimum Spanning Tree:");
        for (int i = 1; i < numV; i++) {
            System.out.println(finishedTree[i] + " - "+ i+ " " + adjencyMatrix[i][finishedTree[i]]);
        }
        
        
    }
    
    //---------------------------------------------------------------------------------------
    
    
    public void warshallFloyd() //Find the shortest path between ALL nodes
    {
        int distances[][] = new int[numV][numV];
        
        for (int i = 0; i < numV; i++) { // This is our base adjency matrix, it makes all the shortest paths without consideration for connecting nodes
            
            for (int j = 0; j < numV; j++) {
                distances[i][j] = adjencyMatrix[i][j];
                if (distances[i][j] == 0 && i!=j) {
                    distances[i][j] = 9999; //Go through and set all 0 edges to "infinity", as long as it isn't its own connecction.
                }
            }
        }
        
        for (int k = 0; k < numV; k++) {
            for (int i = 0; i < numV; i++) {
                for (int j = 0; j < numV; j++) {
                    if (distances[i][j] > distances[i][k] + distances[k][j]) { //If the distance with an intermediary node is shorter than the one edge, then update 
                            distances[i][j] = distances[i][k] + distances[k][j];
                        
                    }
                }
            }
        }
        
        System.out.println("Floyd-Warhsalls Shortest Paths: ");
        for (int i = 0; i < numV; i++) {
            for (int j = 0; j < numV; j++) {
                if (distances[i][j] == 0) {
                    //System.out.print("INF ");
                }
                //else
                    System.out.print(distances[i][j] + " ");
            }
            System.out.println();
        }
        
    }
     
    //---------------------------------------------------------------------------------------
       
    public void floyd() //Find all reachable paths with a directed graph
    {
        Boolean distances[][] = new Boolean[numV][numV];
        
        for (int i = 0; i < numV; i++) { // This is our base adjency matrix, it makes all the shortest paths without consideration for connecting nodes
            
            for (int j = 0; j < numV; j++) {
                if (adjencyMatrix[i][j] != 0 && adjencyMatrix[i][j] < 99) {
                    distances[i][j] = true;
                }
                else
                    distances[i][j] = false;
                
            }
        }
        
        for (int k = 0; k < numV; k++) {
            for (int i = 0; i < numV; i++) {
                for (int j = 0; j < numV; j++) {
                    if (!distances[i][j]) { //If it is false, see if we can make it true with intermediary connetions. 
                            distances[i][j] = distances[i][k] & distances[k][j];
                        
                    }
                }
            }
        }
        
        System.out.println("\nFloyd Reachability: (are there connections from all nodes to the others)");
        for (int i = 0; i < numV; i++) {
            for (int j = 0; j < numV; j++) {
                if (distances[i][j] == true) {
                    System.out.print("1 ");
                }
                else
                    System.out.print("0 ");
            }
            System.out.println();
        }
    }
        
    //---------------------------------------------------------------------------------------
    
     public void printGraph() //A simple funciton to print out the adjency matrix. 
    {
        System.out.println("Adjency Matrix:");
        for (int i = 0; i < numV; i++) {
            for (int j = 0; j < numV; j++) {
                System.out.print(adjencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }
    
    /*0 9 31 0 6 0 
0 0 0 4 0 15
3 0 0 0 8 0 
0 4 0 0 0 0 
8 52 0 0 0 0 
0 13 0 0 0 0*/ //A directed graph to test - works except for prims - which shouldn't work for a directed graph anyway.
    
        
}
    
    
    
    

