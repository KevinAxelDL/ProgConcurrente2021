/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.sincronizacion.Ej4;

/**
 *
 * @author user-
 */
public class Hamaca extends Actividad{
    private String nombre;
    
    public Hamaca(String nombre){
        this.nombre = nombre;
    }
    
    public synchronized void accion(String nombre){
        try{
            System.out.println("... "+ nombre +" usando la hamaca ...(HAMACA OCUPADA)");
            Thread.sleep(4000);
            System.out.println("."+ nombre +" termino de usar la hamaca.(HAMACA LIBRE)");
        }catch(InterruptedException exc){
            System.out.println("Error:");
        }
    }
}
