/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.seccion_critica.Ej5;

import java.util.concurrent.Semaphore;

/**
 *
 * @author user-
 */
public class Impresora {
    private Semaphore semPermiso;
    private String idImpresora;
    private String tipoImpresora;
    
    public Impresora(String tipoImp){
        tipoImpresora = tipoImp;
        semPermiso = new Semaphore(1);
        idImpresora = "IMPRESORA '"+ tipoImpresora +"'-" + (int)(Math.random()*100);
    }
    
    public void imprimir(Usuario usuario){
        System.out.println("(-)"+ usuario.getIdUsuario()+ " USANDO "+ idImpresora);
        try{
            Thread.sleep(1000);
        }catch(InterruptedException exc){
            System.out.println("ERROR EN HILO");
        }
        System.out.println("(+)"+ idImpresora +" LIBERADA");
        semPermiso.release();
    }

    public Semaphore getSemPermiso() {
        return semPermiso;
    }

    public String getTipoImpresora() {
        return tipoImpresora;
    }

    public String getIdImpresora() {
        return idImpresora;
    }
    
    
}
