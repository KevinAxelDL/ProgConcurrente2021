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
class MiHilo implements Runnable{
        Thread hilo;
        //Todos los hilos comparten la misma instancia de sumaMatriz
        static sumaMatriz sumaM = new sumaMatriz();
        int arr[];
        int resp;
        
        //Construye un nuevo hilo
        MiHilo(String nombre, int nums[]){
            hilo = new Thread(this, nombre);
            arr = nums;
        }
        
        //Un metodo que crea e inicia un hilo
        public static MiHilo creaEInicia(String nombre, int nums[]){
            MiHilo miHilo = new MiHilo(nombre, nums);
            miHilo.hilo.start();//Inicia el hilo
            return miHilo;
        }
        
        //Punto de entrada al hilo
        public void run(){
            System.out.println(hilo.getName()+ " iniciando.");
            resp = sumaM.sumMatriz(arr);
            System.out.println("Suma para "+ hilo.getName() +" es "+ resp);
            System.out.println(hilo.getName()+ " terminado.");
        }
}
