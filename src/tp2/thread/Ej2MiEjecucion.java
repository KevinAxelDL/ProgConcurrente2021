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
public class Ej2MiEjecucion extends Thread{
    public void run(){
        //Corre el codigo del thread
        while(true){
            ir();
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
        }
        }
    }
    public void ir(){
        hacerMas();
    }
    public void hacerMas(){
        System.out.println("En la pila: "+ Thread.currentThread().getName());
    }
    
}
