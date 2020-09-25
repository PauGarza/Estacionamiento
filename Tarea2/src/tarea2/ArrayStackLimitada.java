/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea2;

/**
 *
 * @author Paulina Garza y Dante Figueroa
 */
public class ArrayStackLimitada<T> extends ArrayStack<T> {
    
    private final int capacidad =5;
    
    public  boolean isFull(){
        return (cont==capacidad);
    }
    
    public void push(T dato){
        if(!isFull()){
           datos[cont] = dato;
           cont ++; 
        } else{
           throw new FullException(); 
        }
    }
    
}
