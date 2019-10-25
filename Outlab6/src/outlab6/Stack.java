/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outlab6;

/**
 *
 * @author risau
 */
public class Stack {
    private Object stack [];
    private int top;
    
    Stack()
    {
        top = -1;
        stack = new Object [8];
    }
    
    public void makeEmpty()
    {
        top = -1;
    }
    
    public boolean empty()
    {
        return (top == -1);
    }
    
    private boolean full()
    {
        return (top == stack.length - 1);
    }
    
    public void push (Object item)
    {
        if (full())
        {
            System.out.println("Stack is full, going to resize.");
            Object temp [] = new Object [stack.length * 2];
            for (int i = 0; i <= top; i++)
            {
                temp[i] = stack[i];
            }
            stack = temp;
        }
        System.out.println("pushed " + item);
        top++;
        stack[top] = item;
    }
    
    public Object peek ()
    {
        if (!empty())
        {
            return stack[top];
        }
        else
        {
            return null;
        }
    }
    
    public Object pop ()
    {
        if (!empty())
        {
            Object result = stack[top];
            top--;
            return result;
        }
        else
        {
            return null;
        }
    }
    
    public int returnSize()
    {
        return stack.length;
    }
}
