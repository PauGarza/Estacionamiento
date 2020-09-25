/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea2;

import java.util.Objects;

/**
 *
 * @author Paulina Garza y Dante Figueroa
 */
public class Coche <T extends Comparable<T>>  {
    
    private String nombre;
    private int clave;
    private String placa;

    public Coche(String nombre, int clave, String placa) {
        if(checarPlaca(placa) && checarClave(clave)){
            this.nombre = nombre;
            this.clave = clave;
            this.placa = placa;
        }else{
          throw new NotValidException();  
        }
    }
 
    private boolean checarClave (int clave){
        int cont = 0;
        while (clave>0){
            clave/=10;
            cont++;
        }
        return cont == 6;
    }
    
    private boolean checarPlaca (String placa){
        boolean resp = false;
        if( placa.length()==6 )
            if(esMayuscula(placa.charAt(0)) && esMayuscula(placa.charAt(3)) && esMayuscula(placa.charAt(4)) && esMayuscula(placa.charAt(5)) )
              if(esDigito(placa.charAt(1)) && esDigito(placa.charAt(2)))
                  resp = true;
        return resp;
    }
    
    private boolean esMayuscula(char a){
        return ( a != 79 && a != 73 && a <= 90 && a>=65);
    }
    
    private boolean esDigito(char a){
        return(a>=48 && a<=57);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Coche other = (Coche) obj;
        if (this.clave != other.clave) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.placa, other.placa)) {
            return false;
        }
        return true;
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: "+nombre+"\n");
        sb.append(" Clave: "+clave+"\n");
        sb.append(" Placa: "+placa+"\n");
        sb.append("\n");
        
        return sb.toString();
    }
    
    
         
}
