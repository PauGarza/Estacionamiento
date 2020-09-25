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
public class Tarea2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
           Coche c0 = new Coche("Dante", 189229, "M98HTG");
           Coche c1 = new Coche("Pau", 188456, "M98KTG");
           Coche c2 = new Coche("Beto", 189635, "M98HTG");
           Coche c3 = new Coche("Max", 189221, "M98HTG");
           Coche c4 = new Coche("Mike", 189222, "M98HTG");
           Coche c5 = new Coche("Sebastián", 189223, "M98HTG");
           Coche c6 = new Coche("Monroy", 189224, "M98HTG");
           Coche c7 = new Coche("Ulises", 189225, "M98HTG");
           Coche c8 = new Coche("Diana", 189226, "M98HTG");
           Coche c9 = new Coche("José", 189227, "M98HTG");
           Estacionamiento e1 = new Estacionamiento(10);
           e1.alta(c0);
           e1.alta(c1);
           e1.alta(c2);
           e1.alta(c3);
           e1.alta(c4);
           e1.alta(c5);
           e1.alta(c6);
           e1.alta(c7);
           e1.alta(c8);
           //e1.alta(c9); c9 no dado de alta para pruebas
           
           //Agregar al estacionamiento vacio
           e1.meter(c0);
           
           //Agregar al estacionamiento lleno, solo tiene 5 lugares
           e1.meter(c1);
           e1.meter(c2);
           e1.meter(c3);
           e1.meter(c4);
           //e1.meter(c5);
           
           //retira el carro más afuera
           e1.sacar(c4);
           
           //retirar el carro más andentro
           e1.sacar(c0);
           
           //retirar el carro de enmedio
           e1.sacar(c2);
           //sacar un carro que no esta
           e1.sacar(c7);
           
           //meter un carro que no esta en la base de datos
           e1.meter(c9);
           
        }catch(NotValidException e){
            System.out.println("Algún carro tiene un dato inválido");
        }
        catch(EmptyException e){
            
        }
        catch(FullException e){
            System.out.println("El estacionamiento ya está lleno");
        }catch(notBaseFoundException e){
            System.out.println("El carro no está registrado en la base de datos");
        }catch(notFoundException e){
            System.out.println("El carro no se encuentra en el estacionamiento");
        }
        
    }
    
}
