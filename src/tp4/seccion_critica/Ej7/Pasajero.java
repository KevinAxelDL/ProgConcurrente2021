/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.seccion_critica.Ej7;

/**
 *
 * @author user-
 */
public class Pasajero implements Runnable {

    private String id;
    private Auto auto;

    public Pasajero(Auto auto) {
        this.id = "PASAJERO-" + (int) (Math.random() * (100));
        this.auto = auto;
    }

    public void run() {
        while (true) {
            this.utilizarAuto();
        }
    }

    public void utilizarAuto() {
        boolean adquirido = true;
        try {
            adquirido = auto.getSemDisponiblePasajero().tryAcquire();//Adquiere el auto
        } catch (Exception exc) {
            System.out.println("ERROR");
        }
        if (adquirido == false) {
            System.out.println("Taxi no disponible, " + this.id + " espera...");
            try {
                auto.getSemDisponiblePasajero().acquire();//Adquiere el auto
            } catch (Exception exc) {
                System.out.println("ERROR");
            }
        }
    }

    public String getId() {
        return id;
    }

}
