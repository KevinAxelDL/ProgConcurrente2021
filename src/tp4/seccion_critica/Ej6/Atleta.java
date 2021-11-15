/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.seccion_critica.Ej6;

/**
 *
 * @author user-
 */
public class Atleta implements Runnable{
    private String atletaId;
    private static Testigo testigo;
    private int identSemTestigo;//Indica que semaforo se adquiere
    private static long contadorTiempo = 0;
    
    public Atleta(int identSemTestigo){
        this.atletaId = "ATLETA-"+ (int)(Math.random()*100);
        this.identSemTestigo = identSemTestigo;
    }
    
    public void run(){
        this.correr();
    }

    public static void setContadorTiempo(long contadorTiempo) {
        Atleta.contadorTiempo = contadorTiempo;
    }   

    public String getAtletaId() {
        return this.atletaId;
    }

    public static void setTestigo(Testigo testigo) {
        Atleta.testigo = testigo;
    }

    public static long getContadorTiempo() {
        return contadorTiempo;
    }
    
    public void correr(){
        int tiempo = (int)((Math.random() * 5000)%5000);
        long contadorTiempoLocal = System.currentTimeMillis();
                
        testigo.tomarTestigo(identSemTestigo, this);//Adquiere semaforo
        System.out.println(this.atletaId+ " corriendo...");
        this.dormirHilo(tiempo);
        System.out.println("Tiempo de atleta: "+ (contadorTiempoLocal - Atleta.contadorTiempo));
        Atleta.contadorTiempo = contadorTiempoLocal;
        testigo.soltarTestigo(identSemTestigo, this);//Libera semaforo
        
    }
    
    public void dormirHilo(int t){
        try{
            Thread.sleep(t);
        }catch(Exception exc){
            System.out.println("ERROR EN HILO-1");
        }
    }
}
