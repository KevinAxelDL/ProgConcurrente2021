/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.seccion_critica.Ej1;

/**
 *
 * @author user-
 */
public class Main {
    public static void main(String[]args){
        SynchronizedCounter counter1 = new SynchronizedCounter();
        SynchronizedObjectCounter counter2 = new SynchronizedObjectCounter();

        UsaContador obj1 = new UsaContador(counter1, 1);
        UsaContador obj2 = new UsaContador(counter1, 0);
        UsaContadorObject obj3 = new UsaContadorObject(counter2, 1);
        UsaContadorObject obj4 = new UsaContadorObject(counter2, 0);
        
        System.out.println("---CON METODOS SYNCHRONIZED---");
        
        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);
        
        t1.start();
        t2.start();
        
        try{
            t1.join();
            t2.join();
        }catch(Exception exc){
            System.out.println("ERROR EN Join()");
        }
        
        System.out.println("---CON BLOQUES SYNCHRONIZED---");
        
        Thread t3 = new Thread(obj3);
        Thread t4 = new Thread(obj4);
        
        t3.start();
        t4.start();
        
        try{
            t3.join();
            t4.join();
        }catch(Exception exc){
            System.out.println("ERROR EN Join()");
        }
        
        System.out.println("---FIN MAIN---");
    }
}
