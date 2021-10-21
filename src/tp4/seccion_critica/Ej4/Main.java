/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.seccion_critica.Ej4;

/**
 *
 * @author user-
 */
public class Main {
    public static void main(String[]args){
        Impresora impresora = new Impresora();
        
        Letra letra1 = new Letra('A', impresora);
        Letra letra2 = new Letra('B', impresora);
        Letra letra3 = new Letra('C', impresora);
        char[] orden = {'A','B','B','C','C','C',};
        
        letra1.crearIniciarHilo();
        letra2.crearIniciarHilo();
        letra3.crearIniciarHilo();
        
        try{
            letra1.getHilo().join();
            letra2.getHilo().join();
            letra3.getHilo().join();
        }catch(Exception exc){
            System.out.println("ERROR: join");
        }
        
        System.out.println("---FIN MAIN---");
    }
}
