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
public class Ej5C {
    
    public static void main(String[] args){
        System.out.println("Hilo principal iniciando.");
        
        //Crear una instancia de la subclase de Thread
        Ej5CUnHilo hilo1 = new Ej5CUnHilo();
        hilo1.setName("#1");
        Ej5CUnHilo hilo2 = new Ej5CUnHilo();
        hilo2.setName("#2");
        Ej5CUnHilo hilo3 = new Ej5CUnHilo();
        hilo3.setName("#3");
        
        //Finalmente, comienza la ejecucion del hilo
        hilo1.start();
        hilo2.start();
        hilo3.start();
        
        for(int i = 0; i < 50; i++){
            System.out.println(" .");
        }
        
        try{
            Thread.sleep(100);
        }catch (InterruptedException exc){
            System.out.println("Hilo principal interrupido.");
        }
        System.out.println("Hilo principal finalizado.");
    }
    ///////////////////////////////////////////////////////////////////////////
    
    
    
}
