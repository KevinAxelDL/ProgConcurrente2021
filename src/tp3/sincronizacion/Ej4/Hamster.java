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
public class Hamster implements Runnable{
    private String nombre;
    private Thread hilo;
    private Actividad[] interactuables;
    
    public Hamster(String nombre){
        this.nombre = nombre;
    }
    
    public void crearIniciarHiloHamster(){
        hilo = new Thread(this);
        hilo.start();
    }
    
    public void setInteractuables(Actividad[] interactuables){
        this.interactuables = interactuables; //Se asignan los recursos compartidos
    }
    
    
    public void hacerActividad(int actividad){
        try{
            interactuables[actividad].accion(this.nombre);
        }catch(Exception exc){
            System.out.println("Error:");
        }
        
    }
    
    public void run(){
        System.out.println("Hamster "+ this.nombre +" iniciado");
        int accion;
        while(true){
            try{;
                Thread.sleep(2000);
                accion = (int)(Math.random()*10)%3;//Elige una actividad al azar
                switch(accion){
                case 0: hacerActividad(0); break;
                case 1: hacerActividad(1); break;
                case 2: hacerActividad(2); break;
                }
            }catch(InterruptedException exc){
                    System.out.println("Error:");
            }
        }
    }
}
    

