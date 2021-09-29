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
public class Ej2 {
    public static void main (String[]arg){
        //Test
        // Ej2MiEjecucion es subclase de Thread
        Thread miHilo1 = new Ej2MiEjecucion();
        Thread miHilo2 = new Ej2MiEjecucion();
        miHilo1.setName("HILO-1");
        miHilo2.setName("HILO-2");
        miHilo1.start();
        miHilo2.start();
        System.out.println("En el main");
    }
    
}
