/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author user-
 */
public class Ej6 {
    //TP1; Ejercicio 6
    
    // Desde el siguiente cliente “main”:

    public static void main(String[] args) {
        double[] v = new double[15];
        acceso_por_indice(v, 16);
    }

    public static double acceso_por_indice(double[] v, int j) throws RuntimeException{
        double resultado;
        try {
            System.out.println("En TRY");
            resultado = v[j];
        } catch (RuntimeException exc) {
            System.out.println("El indice " + j + " no existe en el vector");
            resultado = -1;
        }
        System.out.println("Sigue la ejecucion");
        return resultado;
    }
}
