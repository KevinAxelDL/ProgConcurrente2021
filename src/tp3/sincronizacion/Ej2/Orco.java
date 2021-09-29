/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.sincronizacion.Ej2;

/**
 *
 * @author user-
 */
public class Orco implements Runnable{
    private String nombre;
    private int danio;
    private Jugador objetivo;
    
    public Orco(String nombre){
        this.nombre = "Orco "+ nombre;
        this.danio = -3;
        this.objetivo = null;
    }
    
    public void setObjetivo(Jugador objetivo){
        this.objetivo = objetivo;
    }
    
    public void atacar() throws InterruptedException{
        try{
            while(objetivo.getVida() > 0){
                //Objetivo vivo
                this.objetivo.modificarVida(this.danio);
                System.out.println(this.nombre +" ataco a "+ objetivo.getNombre() 
                +" por "+ this.danio +" puntos.");
                System.out.println("Vida actual de "+ objetivo.getNombre()+ ": "+ objetivo.getVida());
                Thread.sleep(1000);
            }
            System.out.println(this.objetivo.getNombre() +" esta muerto, no es posible atacar");

        }catch(NullPointerException e){
            System.out.println("No hay un objetivo para atacar ... Buscando");
            Thread.sleep(1000);
            this.atacar();
        }
    }
    
    public void run(){
        try{
            this.atacar();
        }catch(InterruptedException e){
            System.out.println("ERROR:");
        }
    }
    
}
