/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.seccion_critica.Ej3;

import java.util.concurrent.Semaphore;

/**
 *
 * @author user-
 */
public class Recurso {
    private Semaphore sem1;
    private Semaphore sem2;
    private Semaphore sem3;
    private Semaphore sem4;
    
    public Recurso(){
        sem1 = new Semaphore(1);
        sem2 = new Semaphore(0);
        sem3 = new Semaphore(0);
        sem4 = new Semaphore(0);
    }
    
    public void accion(Proceso p){
        System.out.println("Proceso "+ p.getNombre() +" en recurso ...");
        try{
            Thread.sleep(500);
        }catch(InterruptedException exc){
            System.out.println("ERROR EN HILO");
        }
    }

    public Semaphore getSem1() {
        return sem1;
    }

    public Semaphore getSem2() {
        return sem2;
    }

    public Semaphore getSem3() {
        return sem3;
    }

    public Semaphore getSem4() {
        return sem4;
    }
    
    
}
