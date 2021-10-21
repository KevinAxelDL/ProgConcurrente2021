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
public class Surtidor {
    private String idSurtidor;
    
    public Surtidor(String id){
        this.idSurtidor = id;
    }
    
    public synchronized void usar(Vehiculo veh){
        //Recurso compartido
        int litros = 1;
        try{
            System.out.println("Llenando vehiculo "+ veh.getPatente()+ " en surtidor " +this.idSurtidor+" ... (IN)");
            while(veh.getLitrosActual()+ litros <= veh.getCapacidadLitros()){
                //No rebalsa el tanque, se puede llenar
                veh.setLitrosActual(veh.getLitrosActual() + litros);
                Thread.sleep(100);
            }
            System.out.println("Vehiculo "+ veh.getPatente()+ " termino de usar el surtidor. (OUT)");
        }catch(InterruptedException exc){
            System.out.println("ERROR en hilo");
        }
    }
}
