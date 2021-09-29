/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1.excepciones;

/**
 *
 * @author user-
 */
public class Ej6 {
    
    // Desde el siguiente cliente “main”:

    public static void main(String[] args) throws RuntimeException {
        double[] v = new double[15];
        acceso_por_indice(v, 16);
    }

    public static double acceso_por_indice(double[] v, int j) throws RuntimeException{
        double resultado;
        try {
            System.out.println("En TRY");
            if ((0 <= j) && (j <= v.length)){
                resultado = v[j];
            }else {
                throw new RuntimeException ("El indice " + j + " no existe en el vector");
            }
        } catch (RuntimeException exc) {
            System.out.println("En CATCH");
            throw exc;
        }
        System.out.println("Sigue la ejecucion");
        return resultado;
    }
}
