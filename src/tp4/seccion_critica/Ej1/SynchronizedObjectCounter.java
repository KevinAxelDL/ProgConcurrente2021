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
public class SynchronizedObjectCounter {
    /*
    Descripcion de clase: crea instancias con una variable a la cual se le puede
    incrementar y decrementar su valor y puede ser retornada
    */
    private int c = 0;
    public void increment(){
        //Bloque sincronizado
        synchronized(this){
            System.out.println("Obj.increment()(IN)");
            c++;
            System.out.println(c);
            System.out.println("Obj.increment()(OUT)");
        }//Este elemento debe ser casteado a Integer
    }
    
    public void decrement(){
        //Bloque sincronizado
        synchronized(this){
            System.out.println("Obj.decrement()(IN)");
            c--;
            System.out.println(c);
            System.out.println("Obj.decrement()(OUT)");
        }
        
    }
    
    public int value(){return c;}
    
}
