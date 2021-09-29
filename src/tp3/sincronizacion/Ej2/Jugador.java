/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.sincronizacion.Ej2;

/**
 *
 * @author user-
 */
public class Jugador {
    private String nombre;
    private int vida;
    
    public Jugador(String nombre){
        this.nombre = nombre;
        this.vida = 10;
    }
    
    public synchronized void modificarVida(int valor){
        this.vida = this.vida + valor;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public int getVida(){
        return this.vida;
    }
}
