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
public class Ej5 {
    
    public static void main(String[] args){
        System.out.println("Hilo principal iniciando.");
        
        //Primero, construye un objeto unHilo
        Ej5UnHilo mh = new Ej5UnHilo("#1");
        
        //Luego, construye un hilo en ese objeto
        Thread nuevoHilo = new Thread(mh);
        
        //Finalmente, comienza la ejecucion del hilo
        nuevoHilo.start();
        
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
