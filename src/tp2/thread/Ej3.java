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
public class Ej3 extends Thread{
    public Ej3(String str){
        //Constructor
        //Super hace referencia a la super clase Thread
        //Se crea un nuevo thread mediante "super(str)"
        super(str);
    }
    public void run(){
        for(int i = 0; i < 10; i++){
            System.out.println(i +" "+ getName());
            System.out.println("Termina thread "+ getName());
        }
    }
    public static void main (String [] args){
        new Ej3("Maria Jose").start();
        new Ej3("Carlos Daniel").start();
        System.out.println("Termina thread main");
    }
}
