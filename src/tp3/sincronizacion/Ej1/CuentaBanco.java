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
public class CuentaBanco {
    //Recurso compartido
    private int balance = 50;
    private int idCuenta;
    
    public CuentaBanco(int idCuenta){
        //Constructor
        this.idCuenta = idCuenta;
    }
    
    public int getBalance(){
        return balance;
    }
    
    public int getIdCuenta(){
        return idCuenta;
    }
    
    public void retiroBancario(int retiro){
        //El synchronized aqui no es necesario ya que el metodo en
        //VerificarCuenta que lo invoca ya es synchronized
        balance = balance - retiro;
    }
}
