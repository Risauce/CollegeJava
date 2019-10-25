/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3graphs;

/**
 *
 * @author risau
 */
public class Lab3Graphs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GraphController first = new GraphController(5); //Create the instance of our graphcontroller class. 
        
        first.insertToArray();
        
        first.printGraph();
        
        first.breadthSearch(1);
        first.depthSearch(1);
        
        first.dijkstra(0);
        
        first.prims();
        
        first.warshallFloyd();
        first.floyd();
    }
    
}
