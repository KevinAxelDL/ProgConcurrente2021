/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.thread;

/**
 *
 * @author user-
 */
public class Ej5UnHilo implements Runnable {
    private String nombreHilo;
    
    Ej5UnHilo(String nombre){
        //Constructor
        this.nombreHilo = nombre;
    }
    //Punto de entrada de hilo
    //Los hilos comienzan a ejecutarse aqui
    public void run(){
        System.out.println("Comenzando "+ this.nombreHilo);
        
        try {
            for(int contar = 0; contar < 10; contar++){
                Thread.sleep(400);
                System.out.println("En "+ this.nombreHilo +", el recuento "+ contar);
            }
        }catch(InterruptedException exc){
            System.out.println(this.nombreHilo + "Interrupido.");
        }
        System.out.println("Terminado "+ this.nombreHilo);
    }
}
