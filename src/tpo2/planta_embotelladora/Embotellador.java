/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpo2.planta_embotelladora;

import java.util.concurrent.Semaphore;

/**
 *
 * @author user-
 */
public class Embotellador implements Runnable{
    private Caja caja;

    public Embotellador(){
        caja = null;
    }
    
    public void run(){
        while(true){
            embotellar();
        }
    }
    
    private void embotellar(){
        if(caja != null){
            System.out.println("Caja asignada a embotellador");
            try{
                caja.getSemCajaNuevaDisponible().acquire();//Adquiere permiso            
            }catch(Exception exc){
                System.out.println("ERROR EN acquire()");
            }
            caja.llenar();
            caja.getSemCajaLlena().release();//Se indica que la caja ya esta llena
            caja = null;//Evita hacer un acquire() a la caja ya llena
        }else{
            System.out.println("No hay cajas disponibles para el embotellador");
            try{
                Thread.sleep(1000);
            }catch(Exception exc){
                System.out.println("ERROR EN HILO");
            }
        }
    }
    
    public void asignarNuevaCaja(Caja caja){
        this.caja = caja;
    }
}
