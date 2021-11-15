/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.seccion_critica.Ej7;

/**
 *
 * @author user-
 */
public class Taxista implements Runnable{
    private String id;
    private Auto auto;
    
    public Taxista(Auto auto){
        this.id = "TAXISTA-"+ (int)(Math.random()*100);
        this.auto = auto;
    }
    
    public void run(){
        while(true){
            this.utilizarAuto();
        }
    }
    
    public void utilizarAuto(){
        boolean adquirido = true;
        try{
            adquirido = auto.getSemDisponibleConductor().tryAcquire();//Adquiere el auto
        }catch(Exception exc){
            System.out.println("ERROR");
        }
        if(adquirido == false){
            try{
            auto.getSemDisponibleConductor().acquire();//Adquiere el auto
        }catch(Exception exc){
            System.out.println("ERROR");
        }
        }
        auto.utilizar(this);
    }

    public String getId() {
        return id;
    } 
}
