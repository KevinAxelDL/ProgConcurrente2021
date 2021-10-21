/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpo2.semaforos_de_paso;

/**
 *
 * @author user-
 */
public class Hilo implements Runnable{
    private String id;
    private int instruccion;
    private Recurso recurso;
    
    public Hilo(String id, int instruccion, Recurso recurso){
        this.id = id;
        this.instruccion = instruccion;
        this.recurso = recurso;
    }
    
    public void run(){
        while(true){
            switch(instruccion){
                case 0:
                    //S1
                    try{
                        recurso.getSem1().acquire();
                    }catch(Exception exc){
                        System.out.println("ERROR EN acquire() case: 0");
                    }
                    recurso.hacerS1();
                    recurso.getSem3().release();
                    break;
                    
                case 1:
                    //S2
                    try{
                        recurso.getSem2().acquire();
                    }catch(Exception exc){
                        System.out.println("ERROR EN acquire() case: 1");
                    }
                    recurso.hacerS2();
                    recurso.getSem4().release();
                    break;
                    
                case 2:
                    /*La ejecucion de S3 y S4 es secuencial, por lo que un mismo
                    hilo puede ejecutar ambas operaciones
                    */
                    try{
                        //S3
                        recurso.getSem4().acquire();
                        recurso.getSem3().acquire();
                        recurso.hacerS3();
                        recurso.getSem5().release();
                        //S4
                        recurso.getSem5().acquire();
                        recurso.hacerS4();
                        recurso.getSem1().release();
                        recurso.getSem2().release();
                    }catch(InterruptedException exc){
                        System.out.println("ERROR EN acquire() case: 2");
                    }
                    break;
                default:
                    System.out.println("INSTRUCCION NO VALIDA");
            }   
        }
    }
    
}
