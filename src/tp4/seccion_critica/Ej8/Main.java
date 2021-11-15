/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.seccion_critica.Ej8;

/**
 *
 * @author user-
 */
public class Main {
    public static void main(String[]args){
        Cajero caj1 = new Cajero();
        
        Cliente cl1 = new Cliente(caj1);
        Cliente cl2 = new Cliente(caj1);
        Cliente cl3 = new Cliente(caj1);
        
        Thread t1 = new Thread(cl1);
        Thread t2 = new Thread(cl2);
        Thread t3 = new Thread(cl3);
        
        t1.start();
        t2.start();
        t3.start();
        
        try{
            t1.join();
            t2.join();
            t3.join();
        }catch(Exception exc){
            System.out.println("ERROR");
        }
        System.out.println("---FIN MAIN---");
    }
}
