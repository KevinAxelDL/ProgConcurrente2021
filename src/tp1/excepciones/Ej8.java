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
public class Ej8 {
    public static void main (String[] args) throws Exception{
        //revisaEdad(6);
        revisaNumero(2);
    }
    
    public static void revisaEdad(int edad) throws Exception{
        /*
        Ingresa la edad y dispara una
        excepción si la persona es menor de edad.
        */
        
        try{
            System.out.println("En TRY");
            if(edad < 18){
                throw new Exception ("La edad no es valida");
            }
        }
        catch(Exception exc){
            System.out.println("Entro en CATCH");
            throw exc;
        }
        System.out.println("Sigue la ejecucion");
    }
    
    //
    
    public static void revisaNumero(int numIn) throws Exception {
        /*
        Ingresa un numero y dispara una
        excepción cuando al jugar no salga dicho número.
        */
        int numRes;
        
        numRes = (int)(Math.random() * 3);   
        try{
            System.out.println("En TRY");
            if(numRes != numIn){
                throw new Exception("El numero ingresado no coincide con el generado ("+numIn+", "+numRes+")");
            }
        }
        catch(Exception exc){
            System.out.println("En CATCH");
            throw exc;
        }
        System.out.println("Sigue la ejecucion, el resultado fue ("+numIn+", "+numRes+")");
    }
    
}
