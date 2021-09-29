/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.thread.Ej6.Thread;


/**
 *
 * @author user-
 */
public class Ej6 {
    public static void main (String[]args) throws InterruptedException{
        Cliente cliente1 = new Cliente("Cliente1", new int[] {2,2,1,5,2,3});
        Cliente cliente2 = new Cliente("Cliente2", new int[] {1,3,5,1,1});

        //Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();
        
        //Se crean los hilos
        Cajero cajero1 = new Cajero(cliente1, "Cajero1",initialTime);
        Cajero cajero2 = new Cajero(cliente2, "Cajero2",initialTime);
        
        //Activacion
        cajero1.start();
        cajero2.start();
        
        //Espera a que terminen los hilos
        cajero1.join();
        cajero2.join();
        
        //
        System.out.println("---Finaliza main---");
        
    }
}
