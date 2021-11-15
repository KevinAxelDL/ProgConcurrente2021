/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpo3.carpinteria;

/**
 *
 * @author user-
 */
public class Main {
    public static void main(String[]args){
        Ensamblador ens1 = new Ensamblador();
        Carpintero carp1 = new Carpintero(1, ens1);
        Carpintero carp2 = new Carpintero(2, ens1);
        Carpintero carp3 = new Carpintero(3, ens1);
        Carpintero carp4 = new Carpintero(4, ens1);
        
        Thread t1 = new Thread(carp1);
        Thread t2 = new Thread(carp2);
        Thread t3 = new Thread(carp3);
        Thread t4 = new Thread(carp4);
        
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
