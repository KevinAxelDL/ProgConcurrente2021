/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpo2.planta_embotelladora;

/**
 *
 * @author user-
 */
public class Empaquetador implements Runnable{
    private Caja caja;
    private Embotellador embotellador;
    private Deposito deposito;
    
    public Empaquetador(Embotellador embotellador, Deposito deposito){
        this.embotellador = embotellador;
        this.deposito = deposito;
        this.caja = new Caja();
    }
    
    public void run(){
        boolean depDisponible = true;
        
        embotellador.asignarNuevaCaja(this.caja);//Asigna inicialmente una caja vacia al embotellador
        while(depDisponible){
            try{
                caja.getSemCajaLlena().acquire();//Adquiere permiso
            }catch(InterruptedException exc){
                System.out.println("ERROR EN acquire()");
            }
            caja.empacar();
            if(deposito.depositar(caja)){
                //Exito, caja depositada
                Caja newCaja = new Caja();
                caja = newCaja;//Se asigna una nueva caja al empaquetador
                embotellador.asignarNuevaCaja(newCaja);
                caja.getSemCajaNuevaDisponible().release();//Se indica que hay una nueva caja vacia
            }else{
                //No hay espacio en el deposito
                System.out.println("YA NO HAY MAS ESPACIO EN EL DEPOSITO, CAJA NO DEPOSITADA!");
                depDisponible = false;
            }
        }
    }
    
   
}
