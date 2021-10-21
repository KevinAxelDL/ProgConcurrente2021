/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpo2.semaforos_de_paso;

/**
 *
 * @author user-
 */
public class Main {
    public static void main (String[]args){
        Recurso rec = new Recurso();
        
        Hilo obj1 = new Hilo("1",0,rec);
        Hilo obj2 = new Hilo("2",1,rec);
        Hilo obj3 = new Hilo("3",2,rec);
        
        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);
        Thread t3 = new Thread(obj3);
        //
        t1.start();
        t2.start();
        t3.start();
        //
        try{
            t1.join();
            t2.join();
            t3.start();
        }catch(InterruptedException exc){
            System.out.println("ERROR EN join()");
        }
        System.out.println("---FIN MAIN---");
    }
}
