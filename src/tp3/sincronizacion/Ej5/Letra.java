/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.sincronizacion.Ej5;

/**
 *
 * @author user-
 */
public class Letra {
    private char letra;
    private Impresora impresora;
    private Thread hiloInst;
    
    public Letra(char letra){
        this.letra = letra;
    }
    
    public void run(){
        try{
            this.imprimirLetra();
            Thread.sleep(100);
        }catch(InterruptedException exc){
            System.out.println("ERROR:");
        }
    }
    
    public void imprimirLetra(){
        this.impresora.ocuparImpresora(this);
    }
    
    public void crearIniciarHilo(){
        Thread hilo = new Thread();
        hiloInst = hilo;
        hiloInst.start();
    }
    
    public Thread getHilo(){
        return hiloInst;
    }
    
    public char getLetra(){
        return this.letra;
    }
    
    public void setImpresora(Impresora impresor){
        this.impresora = impresor;
    }
}
