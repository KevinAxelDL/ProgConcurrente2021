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
public class Ej4 implements Runnable{
    private String nombre;
    public Ej4(String str){
        this.nombre = str;
    }
    public void run(){
        for(int i = 0; i < 10; i++){
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){}
            System.out.println(i +" "+ this.nombre);
            System.out.println("Termina thread "+ this.nombre);
        }
    }
    public static void main (String [] args){
        //Se crean las instancias de Ej4
        Ej4 objeto1 = new Ej4("Pepe");
        Ej4 objeto2 = new Ej4("Daniel");
        //Se crean instancias de Thread
        //El metdo run() de las instancias de Ej4 es usado por las intacias
        //de Thread
        Thread thread1 = new Thread(objeto1);
        Thread thread2 = new Thread(objeto2);
        
        thread1.start();
        thread2.start();
        
        System.out.println("Termina thread main");
    }
}
