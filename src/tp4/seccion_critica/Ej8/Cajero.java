/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.seccion_critica.Ej8;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author user-
 */
public class Cajero{
    private ReentrantLock lockCajero;
    private String id;
    
    public Cajero(){
        this.id = "CAJERO-"+ (int)Math.random()*100;
        this.lockCajero = new ReentrantLock();
    }
    
    public void cobrarProductos(Cliente cliente){
        System.out.println(cliente.getId() +" en cajero "+ this.id +"(IN)");
        for(int i = 0; i < cliente.getCarrito().length; i++){
            int tiempo = cliente.getCarrito()[i];
            System.out.println("Cobrando producto "+ tiempo +" ...");
            try{
                Thread.sleep(tiempo * 300);
            }catch(Exception exc){
                System.out.println("ERROR");
            }
        }
        System.out.println("Cajero liberado (OUT)");
        System.out.println("---");
        this.lockCajero.unlock();
    }

    public ReentrantLock getLockCajero() {
        return lockCajero;
    }

    public String getId() {
        return id;
    }
    
    
}
