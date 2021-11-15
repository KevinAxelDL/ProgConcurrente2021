/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.seccion_critica.Ej5;

/**
 *
 * @author user-
 */
public class Main {
    public static void main(String[]args){
        /*
        Como restricción: dos hilos no pueden
        ejecutar simultáneamente las operaciones de impresión (Imprimir A o 
        Imprimir B) sobre una misma impresora.
        Cuando un usuario quiera imprimir un trabajo deberá hacerlo sobre una 
        impresora compatible con él y que no esté siendo utilizada por otro 
        usuario. En otro caso el proceso deberá esperar.
        */
        
        //Usuarios
        Usuario us1 = new Usuario("A");
        Usuario us2 = new Usuario("B");
        UsuarioGenerico us3 = new UsuarioGenerico();

        //Impresoras
        Impresora impA = new Impresora("A");
        Impresora impB = new Impresora("B");
        
        //Coleccion de impresoras
        Impresora[] colImpresoras = {impA, impB};
        //Se asignan las impresoras a los usuarios
        Usuario.setColImpresoras(colImpresoras);
        //
        Thread t1 = new Thread(us1);
        Thread t2 = new Thread(us2);
        Thread t3 = new Thread(us3);

        
        t1.start();
        t2.start();
        t3.start();

        
        try{
            t1.join();
            t2.join();
            t3.join();
        }catch(Exception exc){
            System.out.println("ERROR EN HILO");
        }
        System.out.println("---FIN MAIN---");
    }
    
}
