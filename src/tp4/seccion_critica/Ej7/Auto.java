/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.seccion_critica.Ej7;

import java.util.concurrent.Semaphore;

/**
 *
 * @author user-
 */
public class Auto{
    private Semaphore semDisponiblePasajero;
    private Semaphore semDisponibleConductor;
    
    public Auto(){
        this.semDisponiblePasajero = new Semaphore(1);
        this.semDisponibleConductor = new Semaphore(0);
    }
    
    public void utilizar(Taxista inst){
        System.out.println(inst.getId()+ " manejando el taxi ...");
        try{
            Thread.sleep(1000);
        }catch(Exception exc){
            System.out.println("ERROR EN HILO");
        }
        System.out.println(inst.getId()+ " paro el taxi, el pasajero se bajo (OUT)");
        System.out.println("---");
        this.semDisponiblePasajero.release();//Libre para otro cliente
    }
    
    public void subir(Pasajero inst){
        System.out.println(inst.getId()+ " subio al taxi (IN)");
        this.semDisponibleConductor.release();//Avisa al taxista
    }

    public Semaphore getSemDisponiblePasajero() {
        return semDisponiblePasajero;
    }

    public Semaphore getSemDisponibleConductor() {
        return semDisponibleConductor;
    }
    
    
    
}
