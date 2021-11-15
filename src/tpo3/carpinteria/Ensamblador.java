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
public class Ensamblador {

    //Monitor
    private int maxMuebles;
    private int parte1Lista;
    private int parte2Lista;
    private int parte3Lista;

    public Ensamblador() {
        this.parte1Lista = 0;
        this.parte2Lista = 0;
        this.parte3Lista = 0;
    }

    public synchronized void entregarParte1(Carpintero carp) {
        try {
            while (parte1Lista > 0) {
                System.out.println(carp.getId() + " no puede entregar una P1 todavia, espera...(WAIT)");
                this.wait();//Libera el lock y espera un notify
            }
        }catch(Exception exc){
            System.out.println("ERROR");
        }
        this.parte1Lista++;//Se asigna una parte
        System.out.println("Parte 1 entregada (>>)");
        this.notifyAll();//Avisa a los demas hilos para que se actualicen
    }
    
    public synchronized void entregarParte2(Carpintero carp) {
        try {
            while (parte2Lista > 0) {
                System.out.println(carp.getId() + " no puede entregar una P2 todavia, espera...(WAIT)");
                this.wait();//Libera el lock y espera un notify
            }
        }catch(Exception exc){
            System.out.println("ERROR");
        }
        this.parte2Lista++;//Se asigna una parte
        System.out.println("Parte 2 entregada (>>)");
        this.notifyAll();//Avisa a los demas hilos para que se actualicen
    }
    
    public synchronized void entregarParte3(Carpintero carp) {
        try {
            while (parte3Lista > 0) {
                System.out.println(carp.getId() + " no puede entregar una P3 todavia, espera...(WAIT)");
                this.wait();//Libera el lock y espera un notify
            }
        }catch(Exception exc){
            System.out.println("ERROR");
        }
        this.parte3Lista++;//Se asigna una parte
        System.out.println("Parte 3 entregada (>>)");
        this.notifyAll();//Avisa a los demas hilos para que se actualicen
    }
    
    public synchronized void armarMueble(Carpintero carp){
        try{
            while(this.parte1Lista == 0 || this.parte2Lista == 0 || this.parte3Lista == 0){
                System.out.println(carp.getId() + " faltan partes para armar el mueble, espera ... (WAIT)");
                this.wait();
            }
        }catch(Exception exc){
            System.out.println("ERROR");
        }
        System.out.println(carp.getId() +" ensamblando mueble ...");
        try{
            Thread.sleep(1000);
        }catch(Exception exc){
            System.out.println("ERROR");
        }
        this.parte1Lista--;
        this.parte2Lista--;
        this.parte3Lista--;
        System.out.println("Mueble LISTO (!!!)");
        System.out.println("---");
        this.notifyAll();//Avisa a los demas hilos para que se actualicen
    }
}
