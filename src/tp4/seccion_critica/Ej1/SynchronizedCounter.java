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
public class SynchronizedCounter {
    /*
    Descripcion de clase: crea instancias con una variable a la cual se le puede
    incrementar y decrementar su valor y puede ser retornada
    */
    private int c = 0;
    public synchronized void increment(){
        System.out.println("increment()(IN)");
        c++;
        System.out.println(c);
        System.out.println("increment()(OUT)");
    }//Metodo sincronizado
    
    public synchronized void decrement(){
        System.out.println("decrement()(IN)");
        c--;
        System.out.println(c);
        System.out.println("decrement()(OUT)");
    }//Metodo sincronizado
    
    public synchronized int value(){return c;}//Metodo sincronizado
}
