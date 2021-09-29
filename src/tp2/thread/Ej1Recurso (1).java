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
public class Ej1Recurso {

    public static void uso() {
        //Metodo estatico
        Thread t = Thread.currentThread();
        System.out.println("en Recurso: Soy" + t.getName());
    }
}


