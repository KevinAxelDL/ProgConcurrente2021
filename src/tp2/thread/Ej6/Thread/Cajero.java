/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.thread.Ej6.Thread;

/**
 *
 * @author user-
 */
public class Cajero extends Thread{
    private Cliente cliente;
    private String nombre;
    private long initialTime;
    
    public Cajero(Cliente cliente, String nombre, long initialTime){
        this.cliente = cliente; //Asociacion con Cliente
        this.nombre = nombre;
        this.initialTime = initialTime;
    }
    
    public void run(){
        //Metodo
        //timeStamp marca el momento en el que empezo el proceso
        System.out.println("El cajero "+ this.nombre + " COMIENZA A PROCESAR LA"
                + " COMPRA DEL CLIENTE "+ cliente.getNombre() +" EN EL TIEMPO: "
                        + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
        
        for(int i = 0; i < cliente.getCarroCompra().length; i++){
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println(this.nombre+" procesando producto "+ (i + 1) +" (de tipo "
                    +cliente.getCarroCompra()[i] +") -> Tiempo: "+ 
                    (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");          
        }
        
        System.out.println("El cajero "+ this.nombre +" HA TERMINADO DE PROCESAR "
        + cliente.getNombre()+ " EN EL TIEMPO: " + (System.currentTimeMillis()
                - this.initialTime) / 1000 + "seg");
    }
    
    private void esperarXsegundos(int carroCompra){
        //Espera cierto tiempo por cada elemento
        int tiempoEspera = (carroCompra * 1000);
        
        try{
            System.out.println("...Procesando...");
            Thread.sleep(tiempoEspera);
        }catch(InterruptedException e){
            
        }
    }

    public String getNombre() {
        return nombre;
    }
    
    
}
