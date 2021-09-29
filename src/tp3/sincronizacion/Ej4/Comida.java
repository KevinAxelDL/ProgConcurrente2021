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
public class Comida extends Actividad {
    private String nombre;
    
    public Comida(String nombre){
        this.nombre = nombre;
    }
    
    public synchronized void accion(String nombre){
        try{
            System.out.println("... "+ nombre +" comiendo ...(COMIDA OCUPADA)");
            Thread.sleep(2000);
            System.out.println("."+ nombre +" termino de comer.(COMIDA LIBRE)");
        }catch(InterruptedException exc){
            System.out.println("Error:");
        }
    }
}
