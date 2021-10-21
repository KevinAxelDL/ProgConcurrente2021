/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.seccion_critica.Ej3;

/**
 *
 * @author user-
 */
public class Main {
    public static void main(String[]args){
        Recurso rec = new Recurso();
        
        Proceso p1 = new Proceso(1,rec);
        Proceso p2 = new Proceso(2,rec);
        Proceso p3 = new Proceso(3,rec);

        
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);
        Thread t3 = new Thread(p3);

        
        t1.start();
        t2.start();
        t3.start();

        
        try{
            t1.join();
            t2.join();
            t3.join();

        }catch(Exception exc){
            System.out.println("ERROR EN JOIN");
        }
        
        System.out.println("---FIN MAIN---");
    }
}
