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
public class UsuarioGenerico extends Usuario {

    public UsuarioGenerico() {
        super("GEN");
    }

    private void buscarImpresora() {
        int i = 0;//Desplazamiento en arreglo
        int limiteJ = 2;//Limite de iteraciones para la espera activa
        int j = limiteJ;//Contador de iteraciones de espera activa
        boolean encontrada = false;
        boolean semAdquirido = false;
        Impresora impActual;
        while (!encontrada) {
            impActual = Usuario.getColImpresoras()[i];
            if (impActual != null) {
                //Impresora en posicion del arreglo
                try {
                    semAdquirido = impActual.getSemPermiso().tryAcquire();//Intento de adquisicion
                } catch (Exception exc) {
                    System.out.println("ERROR EN HILO");
                }
                if (semAdquirido == true) {
                    //Semaforo adquirido
                    encontrada = true;
                    impActual.imprimir(this);
                    j = limiteJ;//Se reinicia el contador
                } else {
                    //Fallo al adquirir el recurso, sigue buscando
                    System.out.println("(X)"+ super.getIdUsuario() + " intento adquir " + impActual.getIdImpresora());
                    if (j == 0) {
                        //Se cancela la espera activa despues de 'limiteJ' intentos
                        System.out.println("Se cancela la espera activa para " + super.getIdUsuario());
                        try {
                            impActual.getSemPermiso().acquire();//Intento de adquisicion
                        } catch (Exception exc) {
                            System.out.println("ERROR EN HILO");
                        }
                        encontrada = true;
                        impActual.imprimir(this);
                        j = limiteJ;//Se reinicia el contador
                    }
                }

            }
            j--;
            i++;
            i = i % Usuario.getColImpresoras().length;
            super.dormirHilo(100);
        }
    }
    
    public void run(){
        while(true){
            this.buscarImpresora();
        }
    } 
}
