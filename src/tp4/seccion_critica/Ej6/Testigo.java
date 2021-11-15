/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.seccion_critica.Ej6;

import java.util.concurrent.Semaphore;

/**
 *
 * @author user-
 */
public class Testigo {
    private Semaphore[] semTestigo;
    private String testigoId;
    
    public Testigo(int semaforos){
        if(semaforos < 1){
            //Condicion para el arreglo
            semaforos = 1;
        }
        semTestigo = new Semaphore[semaforos];
        for(int i = 0; i <= semTestigo.length-1; i++){
            semTestigo[i] = new Semaphore(0);
        }
        semTestigo[0] = new Semaphore(1);//Primer semaforo con permiso
        testigoId = "TESTIGO";
    }

    public Semaphore[] getSemTestigo() {
        return semTestigo;
    }    
    
    public void tomarTestigo(int sem, Atleta at){
        try{
            this.semTestigo[sem].acquire();
        }catch(Exception exc){
            System.out.println("ERROR EN HILO-2");
        }
        System.out.println(at.getAtletaId() +" ha adquirido "+ testigoId);
    }
    
    public void soltarTestigo(int sem, Atleta at){
        System.out.println(at.getAtletaId() +" ha soltado "+ testigoId);
        System.out.println((sem+1) % semTestigo.length);
        semTestigo[(sem+1) % semTestigo.length].release();
    }
    
    
    
}
