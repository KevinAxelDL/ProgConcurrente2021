/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.sincronizacion.Ej5;

/**
 *
 * @author user-
 */
public class Impresora {
    private char[] ordenLetras;
    private int pos;
    
    public Impresora(char[] cadena){
        this.ordenLetras = cadena;
        this.pos = 0;
    }
    
    public synchronized void ocuparImpresora(Letra letra){
        /*
        Los hilos toman el lock para intentar utilizar el recurso e imprimir,
        si la letra no es la siguiente en el arreglo no se imprime
        */
        if(letra.getLetra() == ordenLetras[this.pos]){
            //Letra valida en la sucesion
            System.out.println(letra.getLetra());
           this.pos = (int)(this.pos++ % ordenLetras.length);
        }else{
            System.out.println(letra.getLetra() +" no sigue en el orden.");
        }
    }       
}
