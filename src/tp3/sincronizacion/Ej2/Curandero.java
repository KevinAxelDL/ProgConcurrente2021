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
public class Curandero implements Runnable{
    private String nombre;
    private int curacion;
    private Jugador objetivo;
    
    public Curandero(String nombre){
        this.nombre = "Curandero "+ nombre;
        this.curacion = 3;
        this.objetivo = null;
    }
    
    public void setObjetivo(Jugador objetivo){
        this.objetivo = objetivo;
    }
    
    public void curar() throws InterruptedException{
        try{
            while(objetivo.getVida() > 0){
                //Objetivo vivo
                this.objetivo.modificarVida(this.curacion);
                System.out.println(this.nombre +" curo a "+ objetivo.getNombre() 
                +" por "+ this.curacion +" puntos.");
            System.out.println("Vida actual de "+ objetivo.getNombre()+ ": "+ objetivo.getVida());
                Thread.sleep(2000);
            }
            System.out.println(this.objetivo.getNombre() +" esta muerto, no es posible curar");

        }catch(NullPointerException e){
            System.out.println("No hay un objetivo para curar ... Buscando");
            Thread.sleep(1000);
            this.curar();
        }
    }
    
    public void run(){
        try{
            this.curar();
        }catch(InterruptedException e){
            System.out.println("ERROR:");
        }
    }
    
}
