/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.seccion_critica.Ej4;

/**
 *
 * @author user-
 */
public class Letra implements Runnable{
    private char letra;
    private Impresora impresora;
    private Thread hiloInst;
    
    public Letra(char letra, Impresora imp){
        this.letra = Character.toUpperCase(letra);
        impresora = imp;
    }
    
    public void run(){
        int i;
        try{
            while(true){
                switch(Character.toLowerCase(letra)){
                    case 'a':
                        impresora.getSem1().acquire();
                        this.imprimirLetra();
                        impresora.getSem2().release();
                        break;
                    case 'b':
                        impresora.getSem2().acquire();
                        for(i=0; i < 2; i++){
                            this.imprimirLetra();
                        }
                        i = 0;
                        impresora.getSem3().release();
                        break;
                    case 'c':
                        impresora.getSem3().acquire();
                        for(i=0; i < 3; i++){
                            this.imprimirLetra();
                        }
                        i = 0;
                        impresora.getSem1().release();
                        break;
                    default:
                        System.out.println("ERROR: CARACTER NO VALIDO");
                }
                Thread.sleep(1000);
            }
        }catch(InterruptedException exc){
            System.out.println("ERROR EN HILO");
        }
    }
    
    public void imprimirLetra(){
        this.impresora.ocuparImpresora(this);
    }
    
    public void crearIniciarHilo(){
        Thread hilo = new Thread(this);
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
