/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.seccion_critica.Ej4;

import java.util.concurrent.Semaphore;

/**
 *
 * @author user-
 */
public class Impresora {
    private Semaphore sem1;
    private Semaphore sem2;
    private Semaphore sem3;
    
    public Impresora(){
        sem1 = new Semaphore(1);
        sem2 = new Semaphore(0);
        sem3 = new Semaphore(0);
    }
    
    public void ocuparImpresora(Letra letra){
        System.out.println(letra.getLetra());
    }       

    public Semaphore getSem1() {
        return sem1;
    }

    public Semaphore getSem2() {
        return sem2;
    }

    public Semaphore getSem3() {
        return sem3;
    }
}
