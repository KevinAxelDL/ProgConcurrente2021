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
public class Main {
    public static void main(String[]args) throws InterruptedException{
        Auto auto1 = new Auto("AU-1");
        Auto auto2 = new Auto("AU-2");
        Auto auto3 = new Auto("AU-3");
        
        Surtidor surtidor1 = new Surtidor("SUR-1");
        
        auto1.creaIniciaHilo();
        auto2.creaIniciaHilo();
        auto3.creaIniciaHilo();
        
        auto1.setSurtidorObjetivo(surtidor1);
        auto2.setSurtidorObjetivo(surtidor1);
        auto3.setSurtidorObjetivo(surtidor1);
        
        try{
            auto1.getHilo().join();
            auto2.getHilo().join();
            auto3.getHilo().join();
        }catch(Exception exp){
            System.out.println("ERROR en hilo");
        }
        
        System.out.println("---FIN MAIN---");
    }
}
