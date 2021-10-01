/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.sincronizacion.Ej6;

/**
 *
 * @author user-
 */
public abstract class Vehiculo {
    private String patente;
    private int kmFaltantesService;
    private int capacidadLitros;
    private int litrosActual;
    private Surtidor surtidorObjetivo;
    
    public void run(){
        int accion;
        try{
            while(true){
                accion = (int)(Math.random()*10)%3;
                switch(accion){
                        case 0: andar(); break;
                        case 1: andar(); break;
                        case 2: parar(); break;
                }
            }
        }catch(Exception exc){}
    }
    
    public void andar(){
        try{
            System.out.println("Vehiculo "+ this.getPatente()+ " andando ...");
            while(this.litrosActual != 10){
                this.litrosActual = this.litrosActual - 1;
                Thread.sleep(100);
            }
            System.out.println("Vehiculo "+ this.getPatente()+ " bajo en combustible ...");
            this.llenarTanque();
        }catch(Exception exc){
            System.out.println("ERROR en hilo");
        }
    }
    
    public void parar(){
        try{
            System.out.println("Vehiculo "+ this.getPatente()+ " ha parado ...");
            Thread.sleep(2000);
            System.out.println("Vehiculo "+ this.getPatente()+ " ha arrancado ...");
        }catch(Exception exc){
            System.out.println("ERROR en hilo");
        }
    }
    
    public void llenarTanque(){
        try{
            System.out.println("Vehiculo "+ this.getPatente()+ " esperando por surtidor...");
            this.surtidorObjetivo.usar(this);
            System.out.println("Vehiculo "+ this.getPatente()+ "termino de usar el surtidor.");
        }catch(Exception exc){
            System.out.println("ERROR: El vehiculo no tiene un surtidor para usar");
        }
    }

    public String getPatente() {
        return patente;
    }

    public int getKmFaltantesService() {
        return kmFaltantesService;
    }

    public int getCapacidadLitros() {
        return capacidadLitros;
    }

    public int getLitrosActual() {
        return litrosActual;
    }

    public void setLitrosActual(int litrosActual) {
        this.litrosActual = litrosActual;
    }

    public void setSurtidorObjetivo(Surtidor surtidorObjetivo) {
        this.surtidorObjetivo = surtidorObjetivo;
    }
    
    
}
