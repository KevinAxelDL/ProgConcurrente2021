/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.sincronizacion.Ej2;

/**
 *
 * @author user-
 */
public class Main {
    public static void main(String[] args) throws InterruptedException{
        Jugador jugador1 = new Jugador("Pepe");
        Orco orco1 = new Orco("1");
        Curandero curandero1 = new Curandero("1");
        
        Thread hilo1 = new Thread (orco1);
        Thread hilo2 = new Thread (curandero1);
        
        hilo2.start();
        hilo1.start();
        
        
        orco1.setObjetivo(jugador1);
        Thread.sleep(1000); //Simula no encontrar un objetivo
        curandero1.setObjetivo(jugador1);
        
        
        
        hilo1.join();
        hilo2.join();
        
        System.out.println("---FIN DE MAIN---");
    }
}
