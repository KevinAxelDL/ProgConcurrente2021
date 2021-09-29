/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.thread;

/**
 *
 * @author user-
 */
public class Ej1Cliente extends Thread {

    public void run() {
        while (true) {
            System.out.println("Soy" + Thread.currentThread().getName());
            Ej1Recurso.uso();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
        }
    }
}
