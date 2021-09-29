/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.sincronizacion.Ej1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user-
 */
public class VerificarCuenta implements Runnable{
    private CuentaBanco cb = new CuentaBanco(999);
    
    private synchronized void HacerRetiro(int cantidad) throws InterruptedException{
        //La operacion es atomica para evitar inconsistencias
        if(cb.getBalance() >= cantidad){
            System.out.println(Thread.currentThread().getName()+": Monto actual de la cuenta "+ cb.getIdCuenta()+": "+ cb.getBalance());
            System.out.println(Thread.currentThread().getName() + " esta"
                    + " realizando un retiro de: "+ cantidad +"; de la cuenta: "+ cb.getIdCuenta());
            Thread.sleep(1000);
            cb.retiroBancario(cantidad);//CuentaBanco es un recurso compartido
            System.out.println(Thread.currentThread().getName() +": Retiro"
                    + " realizado.");
            System.out.println(Thread.currentThread().getName() +": Los fondos"
                    + " son de: " + cb.getBalance());
        }else{
            System.out.println("No hay suficiente dinero en la cuenta para"
                    + " realizar el retiro Sr." + Thread.currentThread().getName());
            System.out.println("Su saldo actual es de: " + cb.getBalance());
            Thread.sleep(1000);
        }
    }// de hacer retiro
    
    public void run(){
        for(int i = 1; i<= 4; i++){
            try{
                this.HacerRetiro(10);
                if(cb.getBalance() < 0){
                    System.out.println("La cuenta esta sobregirada.");
                }
            }catch(InterruptedException ex){
                Logger.getLogger(VerificarCuenta.class.getName()).log(Level.SEVERE, null, ex);}
        }
    }
}
