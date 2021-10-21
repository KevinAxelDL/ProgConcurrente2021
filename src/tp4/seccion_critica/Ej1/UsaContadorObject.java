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
public class UsaContadorObject implements Runnable{
    private SynchronizedObjectCounter counter2;
    private int accion;// 0 -> restar; 1 -> sumar
    
    public UsaContadorObject(SynchronizedObjectCounter inst, int accion){
        this.accion = accion;
        counter2 = inst;
    }
    public void run(){
        switch(accion){
            case 0:
                for(int i=0; i <= 8; i++){
                    try{
                        counter2.decrement();
                    }catch(Exception exc){
                        System.out.println("ERROR EN HILO");
                    }
                }
            case 1:
                for(int i=0; i <= 8; i++){
                    try{
                        counter2.increment();
                    }catch(Exception exc){
                        System.out.println("ERROR EN HILO");
                    }
                }
        }
    }
}
