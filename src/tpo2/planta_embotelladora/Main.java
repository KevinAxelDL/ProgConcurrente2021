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
public class Main {
    //El embotellador llena cajas de 10 unidades
    //El empaquetador recibe cajas llenas
    //El empaquetador sella y guarda las cajas
    //El empaquetador deposita una nueva caja para llenar
    //El embotellador no puede llenar una caja hasta que se le de una nueva
    public static void main(String[]args){
        Deposito dep1 = new Deposito();
        Embotellador emb1 = new Embotellador();
        Empaquetador emp1 = new Empaquetador(emb1, dep1);
        
        Thread t1 = new Thread(emb1);
        Thread t2 = new Thread(emp1);
        
        t1.start();
        t2.start();
        
        try{
            t1.join();
            t2.join();
        }catch(Exception exc){
            System.out.println("ERROR EN join()");
        }
        System.out.println("---FIN MAIN---");
    }
}
