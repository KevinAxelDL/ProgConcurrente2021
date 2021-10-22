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
public class Caja {
    private String idCaja;
    private int cantidadActual;
    private int cantidadLimite;
    private Semaphore semCajaLlena;
    private Semaphore semCajaNuevaDisponible;
    
    public Caja(){
        idCaja = "CAJA-"+ (int)(Math.random()*1000);
        cantidadActual = 0;
        cantidadLimite = 10;
        semCajaLlena = new Semaphore(0);
        semCajaNuevaDisponible = new Semaphore(1);
    }
    
    public void llenar(){
        System.out.println("Llenando "+ idCaja +"...");
        while(cantidadActual != cantidadLimite){
            cantidadActual++;
            System.out.println("Cantidad de "+ idCaja +": ("+ cantidadActual+"/"+ cantidadLimite+")");
            try{
                Thread.sleep(250);
            }catch(InterruptedException exc){
                System.out.println("ERROR en sleep()");
            }
        }
    }
    
    public void empacar(){
        System.out.println("Empacando "+ idCaja +"...");
        try{
                Thread.sleep(500);
            }catch(InterruptedException exc){
                System.out.println("ERROR en sleep()");
            }
    }

    public Semaphore getSemCajaLlena() {
        return semCajaLlena;
    }

    public Semaphore getSemCajaNuevaDisponible() {
        return semCajaNuevaDisponible;
    }
    //Listo
}
