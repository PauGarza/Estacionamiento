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
public class ArrayStack <T> implements StackADT<T>{
    
    protected T[] datos;
    protected int cont;
    
    public ArrayStack(){
        datos = (T[])(new Object[100]);//valor inicial ni muy chico, ni muy grande
        cont = 0;
    }
    
    public void push(T dato){
       if(cont>=datos.length){
           expandCapacity(); 
       }
       datos[cont] = dato;
       cont ++;
    }
    
    public T pop(){
        if(isEmpty())
            throw new EmptyException();
        cont--;
        T res = datos[cont];
        datos[cont]= null;
        return res;
    }
    
    public T peek(){
        if(isEmpty())
            throw new EmptyException();
        return datos[cont-1];
    }
    
    public boolean isEmpty(){
        return cont == 0;
    }

    private void expandCapacity() {
        T[] nuevo = (T[]) (new Object[datos.length*2]);
        for(int i = 0; i < datos.length; i++) 
            nuevo[i]=datos[i];
        datos=nuevo;
    }
}
