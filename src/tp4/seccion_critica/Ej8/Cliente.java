/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.seccion_critica.Ej8;

/**
 *
 * @author user-
 */
public class Cliente implements Runnable {

    private int[] carrito;
    private String id;
    private Cajero cajeroConocido;
    private static int tamanio = 3;

    public Cliente(Cajero cajero) {
        this.id = "CLIENTE-" + (int) (Math.random() * 100);
        this.cajeroConocido = cajero;
        this.carrito = new int[tamanio];
        for (int i = 0; i < tamanio; i++) {
            int producto = (int) (Math.random() * 5) % 5;
            carrito[i] = producto;
        }
    }

    public void run() {
        while (true) {
            colocarProductos();
        }
    }

    public void colocarProductos() {
        boolean exito;
        exito = cajeroConocido.getLockCajero().tryLock();//Intenta adquirir el lock
        if (exito == false) {
            System.out.println("Cajero ocupado, " + this.id + " espera...");
            this.cajeroConocido.getLockCajero().lock();
        } else {
            this.cajeroConocido.cobrarProductos(this);
        }
    }

    public int[] getCarrito() {
        return carrito;
    }

    public String getId() {
        return id;
    }

}
