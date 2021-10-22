/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpo2.semaforos_de_paso;

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
    private Semaphore sem5;
    
    public Recurso(){
        sem1 = new Semaphore(1);
        sem2 = new Semaphore(1);
        sem3 = new Semaphore(0);
        sem4 = new Semaphore(0);
        sem5 = new Semaphore(0);
    }
    
    public void hacerS1(){
        System.out.println("S1 en ejecucion");
        try{
            Thread.sleep(500);
        }catch(InterruptedException exc){
            System.out.println("ERROR EN HILO");
        }
    }
    
    public void hacerS2(){
        System.out.println("S2 en ejecucion");
        try{
            Thread.sleep(500);
        }catch(InterruptedException exc){
            System.out.println("ERROR EN HILO");
        }
    }
    
    public void hacerS3(){
        System.out.println("S3 en ejecucion");
        try{
            Thread.sleep(500);
        }catch(InterruptedException exc){
            System.out.println("ERROR EN HILO");
        }
    }
    
    public void hacerS4(){
        System.out.println("S4 en ejecucion");
        System.out.println("---");
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

    public Semaphore getSem5() {
        return sem5;
    }
}
