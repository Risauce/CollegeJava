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
public class Node<E> {
    public E data;
    public Node<E> right;
    public Node<E> left;
    
    
    public Node(E data)
    {
        this.data = data;
        this.right = null;
        this.left = null;
    }
    
    public void setRight(Node<E> temp)
    {
        this.right = temp;
    }
    
    public void setLeft(Node<E> temp)
    {
        this.left = temp;
    }
    
    public E getData()
    {
        return this.data;
    }
    
    public Node<E> getLeft()
    {
        return this.left;
    }
    
    public Node<E> getRight()
    {
        return this.right;
    }
}
