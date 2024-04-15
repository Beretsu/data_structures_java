/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mmm
 * @param <E>
 */
public class Stack<E> extends DynamicArray<E>{
    
    public void push(E element){
        addToEnd(element);
    }
    
    public E pop(){
        int len = size();
        E obj = peek();
        removeAt(len-1); // needs correction, returns indexOutofbounds
        return obj;
    }
    
    public E peek(){
        int len = size();
        if(len == 0){
            throw new EmptyStackException();
        }
        return get(size()-1);
    }
    
    public boolean isEmpty(){
        return size() == 0;
    }
}
