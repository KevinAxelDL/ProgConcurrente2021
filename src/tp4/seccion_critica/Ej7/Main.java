/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.seccion_critica.Ej7;

/**
 *
 * @author user-
 */
public class Main {
    public static void main(String[] args){
        //NOTA:ERROR EN ORDEN DE IMPRESION
        Auto auto1 = new Auto();
        Pasajero pas1 = new Pasajero(auto1);
        Pasajero pas2 = new Pasajero(auto1);
        Pasajero pas3 = new Pasajero(auto1);
        Taxista tax1 = new Taxista(auto1);
        
        Thread t1 = new Thread(pas1);
        Thread t2 = new Thread(pas2);
        Thread t3 = new Thread(pas3);
        Thread t4 = new Thread(tax1);
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
        try{
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        }catch(Exception exc){
            System.out.println("ERROR");
        }
        System.out.println("---FIN MAIN---");
    }
}
