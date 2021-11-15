/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.seccion_critica.Ej6;

/**
 *
 * @author user-
 */
public class Carrera {
    public static void main(String[]args){
        long contadorTiempoCarrera;
        Testigo testigo1 = new Testigo(4);
        Atleta.setTestigo(testigo1);
        
        Atleta atleta1 = new Atleta(0);
        Atleta atleta2 = new Atleta(1);
        Atleta atleta3 = new Atleta(2);
        Atleta atleta4 = new Atleta(3);
        
        Thread t1 = new Thread(atleta1);
        Thread t2 = new Thread(atleta2);
        Thread t3 = new Thread(atleta3);
        Thread t4 = new Thread(atleta4);
        
        Atleta.setContadorTiempo(System.currentTimeMillis());//Tiempo de inicio de Atletas
        contadorTiempoCarrera = System.currentTimeMillis(); //Tiempo de inicio de carrera
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
        try{
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        }catch(Exception exc){
            System.out.println("ERROR EN HILO-3");
        }
        System.out.println("---FIN CARRERA---");
        System.out.println("Tiempo total de la carrera: "+ (Atleta.getContadorTiempo() - contadorTiempoCarrera));
        
    }
}
