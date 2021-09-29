/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.thread.Ej6.Runnable;


/**
 *
 * @author user-
 */
public class Cliente {
    private String nombre;
    private int[] carroCompra;
    
    public Cliente(String nombre, int[] carroCompra){
        //Constructor
        this.nombre = nombre;
        this.carroCompra = carroCompra;
    }

    public String getNombre() {
        return nombre;
    }

    public int[] getCarroCompra() {
        return carroCompra;
    }
    
}
