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
public class Estacionamiento {
    
    private Coche baseDeDatos [];
    private int ocupados;
    private ArrayStackLimitada lugares;

    public Estacionamiento(int tam) {
        baseDeDatos = new Coche [tam];
        lugares = new ArrayStackLimitada();
        ocupados = 0;
    }
    
    public void alta(Coche c){
        baseDeDatos[ocupados]=c;
        ocupados++;
    }
   
    public boolean checarEnBase(Coche c){
        boolean resp = false;
        int i = 0;
        while(i < baseDeDatos.length && resp==false && baseDeDatos[i]!=null){
            if(baseDeDatos[i].equals(c) )
                resp=true;
            i++;
        }
        return resp;
    }
    
    public boolean checarEnEst (Coche c){
        boolean resp = false;
        ArrayStackLimitada aux  = new ArrayStackLimitada();
        Coche x;
        while(!lugares.isEmpty() && !resp){
            x=(Coche)lugares.pop();
            aux.push(x);
            if(x.equals(c))
                resp = true;
        }
        while(!aux.isEmpty()){
            x=(Coche)aux.pop();
            lugares.push(x);
        }
        return resp;
    }
    
    public void sacar (Coche c){
        if(checarEnEst(c)){
            boolean bandera = false;
            ArrayStackLimitada aux  = new ArrayStackLimitada();
            Coche x;
            while(!lugares.isEmpty() && !bandera){
                x=(Coche)lugares.pop();
                if(x.equals(c))
                    bandera = true;
                else
                    aux.push(x);  
            }
            while(!aux.isEmpty()){
                x=(Coche)aux.pop();
                lugares.push(x);
            }
        }else{
            throw new notFoundException();
        }
    }
    
    public void meter(Coche c){
        if(checarEnBase(c)){
            lugares.push(c);
        }else{
            throw new notBaseFoundException();
        }
    }
    
    //TODO Quitar método, solo para checar funcionalidad
    public String toString(){
        StringBuilder sb = new StringBuilder();
        while(!lugares.isEmpty()){
            sb.append(lugares.pop().toString());
        }
        return sb.toString();
    }
  
    
}
