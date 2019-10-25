/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg232inlab1coffee;

/**
 *
 * @author risau
 */
public class TreeManager<E extends Comparable> {
    public Node<E> root;
    
    TreeManager(E data)
    {
        Node<E> temp = new Node<E>(data);
        temp.setRight(null);
        temp.setLeft(null);
        
        root = temp;
    }
    
    /*public Node addToTree(Node<E> parent, Node<E> toAdd)
    {
        if (parent == null) {
            
            return (toAdd);
        }
        if (toAdd.data.compareTo(parent.data) < 0) {
            parent.left = addToTree(parent.left, toAdd);
        }
        else if (toAdd.data.compareTo(parent.data) > 0) {
            parent.right = addToTree(parent.right, toAdd);
        }
        else{
            return toAdd; //No duplicates allowed
        }
        
        return toAdd;
    }
*/
    
        public Node addToTreeData(Node<E> parent, E data)
    {
        Node addNode = new Node<E>(data);
        if (parent == null) {
            
            return (addNode);
        }
        if (data.compareTo(parent.data) < 0) {
            parent.left = addToTreeData(parent.left, (E)addNode.data);
        }
        else if (data.compareTo(parent.data) > 0) {
            parent.right = addToTreeData(parent.right, (E)addNode.data);
        }
        else{
            return parent; //No duplicates allowed
        }
        
        
        return parent;
    }
        
    public E furthestLeaf(Node parent) 
    { 
        Node<E> current = parent; 
  
        /* loop down to find the leftmost leaf */
        while (current.left != null) 
           current = current.left; 
  
        return current.data; 
    } 
        
    public Node deleteNode(Node<E> parent, E data)
    {
        if (parent == null) { //If the tree is empty, then we are done - there is nothing to delete.
            
            return null;
        }
        
        int comparedInt = data.compareTo(parent.data); //Compare the parent node and the data of what we want to delete. Gets -1, 0, or 1
        
        if (comparedInt < 0) {
            
            return deleteNode(parent.left, data); //Traverse to the left
        }
        else if (comparedInt > 0) {
            
            return deleteNode(parent.right, data); //Traverse to the right
        }
        else // The data is the parent (current node)
        {        
            if (parent.left == null) {
                return parent.right;
               
            }
            else if (parent.right == null) {
                return parent.left;
            }
            
            parent.data = (E) furthestLeaf(parent.right);
            parent.right = deleteNode(parent.right, parent.data);
            
            /*
            if (parent.left == null && parent.right == null) { //If there are no children
                System.out.println("No Children");
                temp = parent;
                parent = null;
            }
            else if ((parent.left != null && parent.right == null) || (parent.left == null && parent.right != null)) { //If there is one child
                System.out.println("One Child");
                if (temp == parent.left) { //Check which one is empty
                    temp = parent.right;
                    
                }
                else
                    temp = parent.left;
                
                parent = temp;
            }
            Node temp = null;
            if (parent.left == null || parent.right == null) { //There is either zero or one child
                
                
                if (temp == parent.left) { //Check which one is empty (one child case)
                    temp = parent.right;
                    
                    
                }
                else
                    temp = parent.left;
                
                if (temp == null) { //No children
                    temp = parent;
                    parent = null;
                    System.out.println("No child" + temp.data);
                }
                else {//One child continued
                    parent = temp;
                    System.out.println("One child");
                }
                
            }
            else //There are TWO children
            {
               
                
                System.out.println("Two Children");
                temp = furthestLeaf(parent.right);
                parent.data = (E) temp.data;
                parent.right = deleteNode(parent.right, (E)temp.data);
            }
*/
        }   
        
        
        return parent;
    }
    
    
    public void inOrder(Node<E> data){
        if(root != null){
            if(data != null){
                inOrder(data.getLeft());
                System.out.println(data.getData());
                inOrder(data.getRight());
            }
        }
    }
    
    public void preOrder(Node<E> data){
        if(root != null){
            if(data != null){
                System.out.println(data.getData());
                preOrder(data.getLeft());
                preOrder(data.getRight());
            }
        }
    }
    
    public void postOrder(Node<E> data){
       if(root != null){
            if(data != null){
                postOrder(data.getLeft());
                postOrder(data.getRight());
                System.out.println(data.getData());
            }
        } 

    }
}
