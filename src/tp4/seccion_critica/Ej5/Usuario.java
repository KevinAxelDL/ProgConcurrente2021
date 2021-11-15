/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.seccion_critica.Ej5;

/**
 *
 * @author user-
 */
public class Usuario implements Runnable{
    private String idUsuario;
    private static Impresora[] colImpresoras;
    private String tipoUsuario;
    
    public Usuario(String tipoUsuario){
        idUsuario = "USUARIO '"+ tipoUsuario +"'-"+ (int)(Math.random()*1000);
        this.tipoUsuario = tipoUsuario;
    }
    
    private void buscarImpresora(){
        int i=0;//Desplazamiento en arreglo
        boolean encontrada = false;
        Impresora impActual;
        while(!encontrada){
            impActual = colImpresoras[i];
            if(impActual != null){
                //Impresora en posicion del arreglo
                if(tipoUsuario.equalsIgnoreCase(impActual.getTipoImpresora())){
                    //Mismo tipo de impresora y tipo de usuario
                    try{
                        impActual.getSemPermiso().acquire();
                    }catch(Exception exc){
                        System.out.println("ERROR EN HILO");
                    }
                    encontrada = true;
                    impActual.imprimir(this);
                }else{
                    //Fallo al adquirir el recurso, sigue buscando
                    System.out.println("(X)"+ idUsuario +" intento adquir "+ colImpresoras[i].getIdImpresora());
                }
            }
            i++;
            i = i % colImpresoras.length;
            this.dormirHilo(100);
        }
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public static Impresora[] getColImpresoras() {
        return colImpresoras;
    }
    
    public static void setColImpresoras(Impresora[] imp){
        Usuario.colImpresoras = imp;
    }
    
    public void dormirHilo(int t){
        try{
            Thread.sleep(t);
        }catch(Exception exc){
            System.out.println("ERROR EN HILO");
        }
    }
    
    public void run(){
        while(true){
            buscarImpresora();
        }
    } 
}
