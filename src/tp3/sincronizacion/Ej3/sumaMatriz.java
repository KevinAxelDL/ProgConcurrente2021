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
public class sumaMatriz {

    private int sum;

    int sumMatriz(int nums[]) {
        sum = 0;

        for (int i = 0; i < nums.length; i++) {
            System.out.println(i);
            synchronized(this){//Operacion atomica
                sum += nums[i];
                System.out.println("Total acumulado de "
                + Thread.currentThread().getName() + " es " + sum);
            }    
            try {
                Thread.sleep(10);//Permitir el cambio de tarea
            } catch (InterruptedException exc) {
                System.out.println("Hilo interrumpido.");
            }    
                
            

        }

        return sum;
    }
}
