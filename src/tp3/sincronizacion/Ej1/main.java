/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.sincronizacion.Ej1;

/**
 *
 * @author user-
 */
public class main {
    public static void main(String[] args){
        VerificarCuenta vc = new VerificarCuenta();
        
        //Los dos threads compartiran la misma instancia de VerificarCuenta
        //la misma instancia de VerificarCuenta
        Thread Luis = new Thread(vc, "Luis");
        Thread Manuel = new Thread(vc, "Manuel");
        Luis.start();
        Manuel.start();
    }
}
