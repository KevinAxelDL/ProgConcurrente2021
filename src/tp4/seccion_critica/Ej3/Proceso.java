/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.seccion_critica.Ej3;

/**
 *
 * @author user-
 */
public class Proceso implements Runnable {
    private int tipoEjecucion;
    private Recurso recurso;
    private String nombre;
    
    public Proceso(int tipo, Recurso recurso){
        nombre = Integer.toString(tipo);
        tipoEjecucion = tipo;
        this.recurso = recurso;
    }
    
    public void run(){
        while(true){
            switch(tipoEjecucion){
            case 1:
                //Tipo de proceso 1
                try{
                    recurso.getSem1().acquire();
                }catch(InterruptedException exc){
                    System.out.println("ERROR EN ACQUIRE");
                }
                recurso.accion(this);
                recurso.getSem2().release();
                break;
            case 2:
                //Tipo de proceso 2
                try{
                    recurso.getSem2().acquire();
                }catch(InterruptedException exc){
                    System.out.println("ERROR EN ACQUIRE");
                }
                recurso.accion(this);
                recurso.getSem3().release();
                break;
            case 3:
                //Tipo de proceso 3
                try{
                    recurso.getSem3().acquire();
                }catch(InterruptedException exc){
                    System.out.println("ERROR EN ACQUIRE");
                }
                recurso.accion(this);
                recurso.getSem1().release();
                break;
            default:
                System.out.println("ERROR: PROCESO CON ACCION NO VALIDA");
                try{
                    Thread.sleep(500);
                }catch(InterruptedException exc){
                    System.out.println("ERROR EN HILO");
                }
                break;
            }   
        }
    }

    public String getNombre() {
        return nombre;
    }
    
    
}
