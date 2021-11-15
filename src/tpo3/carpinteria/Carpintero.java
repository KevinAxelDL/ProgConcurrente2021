/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpo3.carpinteria;

/**
 *
 * @author user-
 */
public class Carpintero implements Runnable{
    private static int cantMuebles = 5;
    private String id;
    private int tipoCarptintero;
    private Ensamblador ensamblador1;
    
    public Carpintero(int tipoCarp, Ensamblador ens ){
        this.id = "CARPINTERO T"+ tipoCarp +"-"+(int)(Math.random()*100);
        this.tipoCarptintero= tipoCarp;
        this.ensamblador1 = ens;
    }
    
    public void run(){
        int iteraciones = 1;
        while(iteraciones <= Carpintero.cantMuebles){
            switch(this.tipoCarptintero){
                case 1:
                    this.fabricarParte(1);
                    this.ensamblador1.entregarParte1(this);
                    break;
                case 2:
                    this.fabricarParte(2);
                    this.ensamblador1.entregarParte2(this);
                    break;
                case 3:
                    this.fabricarParte(3);
                    this.ensamblador1.entregarParte3(this);
                    break;
                case 4:
                    this.ensamblador1.armarMueble(this);
                    break;
                default:
                    System.out.println("ERROR: TIPO DE CARPINTERO NO VALIDO");
                    break;
            }
            iteraciones++;
        }  
    }
    
    public void fabricarParte(int tipo){
        System.out.println(this.id+ " fabricando parte "+ tipo +" ...");
        try{
            Thread.sleep(1);
        }catch(Exception exc){
            System.out.println("ERROR");
        }
        System.out.println("Parte "+ tipo +" lista (!)");
    }

    public String getId() {
        return id;
    }

    public int getTipoCarptintero() {
        return tipoCarptintero;
    }
    
    
    
}
