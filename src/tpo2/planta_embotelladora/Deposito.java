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
public class Deposito {
    private Caja[] deposito;
    private int pos;
    private int tamanio;
    
    public Deposito(){
        tamanio = 5;
        pos = 0;
        deposito = new Caja[tamanio];
    }
    
    public synchronized boolean depositar(Caja caja){
        boolean exito = true;
        
        if(pos > tamanio-1){
            //No hay mas espacio en el deposito
            exito = false;
        }else{
            deposito[pos] = caja;
            System.out.println("Caja depositada");
            pos++;
            System.out.println("Espacio en el deposito: ("+ pos +"/"+ tamanio +")");
        }
        return exito;
    }
    //Listo
}
