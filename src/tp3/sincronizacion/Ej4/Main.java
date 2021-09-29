/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.sincronizacion.Ej4;

/**
 *
 * @author user-
 */
public class Main {
    public static void main(String[]args){
        Hamster ham1 = new Hamster("Diego");
        Hamster ham2 = new Hamster("Pepe");
        Hamster ham3 = new Hamster("Marco");
        
        Comida com1 = new Comida("lechuga");
        Rueda rueda1 = new Rueda("rueda roja");
        Hamaca hamaca1 = new Hamaca("hamaca azul");
        
        //Coleccion de recursos compartidos
        Actividad[] interactuables = {com1, rueda1, hamaca1};
        
        //Asignacion de recursos compartidos a cada instancia de Hamster
        ham1.setInteractuables(interactuables);
        ham2.setInteractuables(interactuables);
        ham3.setInteractuables(interactuables);
        
        //Creacion e inicializacion de hilos
        ham1.crearIniciarHiloHamster();
        ham2.crearIniciarHiloHamster();
        ham3.crearIniciarHiloHamster();
        
        
    }
}
