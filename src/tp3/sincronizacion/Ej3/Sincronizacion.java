/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.sincronizacion.Ej3;

/**
 *
 * @author user-
 */
public class Sincronizacion {
    public static void main(String[]args){
        int arr[] = {1,1,1,1,1};//Puede utilizar distintos valores para ver los cambios
        MiHilo mh1 = MiHilo.creaEInicia("#1", arr);
        MiHilo mh2 = MiHilo.creaEInicia("#2", arr);
        
        try{
            mh1.hilo.join();
            mh2.hilo.join();
            System.out.println("---FIN DE MAIN---");
        }catch(InterruptedException exc){
            System.out.println("Hilo principal interrumpido.");
        }
    }
}
