/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.thread.Ej6;

/**
 *
 * @author user-
 */
public class Cajero{
    private String nombre;
    
    public Cajero(String nombre){
        //Constructor
        this.nombre = nombre;
    }
    
    public void procesarCompra(Cliente cliente, long timeStamp){
        //Metodo
        //timeStamp marca el momento en el que empezo el proceso
        System.out.println("El cajero "+ this.nombre + " COMIENZA A PROCESAR LA"
                + " COMPRA DEL CLIENTE "+ cliente.getNombre() +" EN EL TIEMPO: "
                        + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
        
        for(int i = 0; i < cliente.getCarroCompra().length; i++){
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesando producto "+ (i + 1) +" (de tipo "
                    +cliente.getCarroCompra()[i] +") -> Tiempo: "+ 
                    (System.currentTimeMillis() - timeStamp) / 1000 + "seg");          
        }
        
        System.out.println("El cajero "+ this.nombre +" HA TERMINADO DE PROCESAR "
        + cliente.getNombre()+ " EN EL TIEMPO: " + (System.currentTimeMillis()
                - timeStamp) / 1000 + "seg");
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
    
    public String getNombre(){
        return this.nombre;
    }
}
