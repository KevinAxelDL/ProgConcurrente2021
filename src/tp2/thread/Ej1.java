/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.thread;

/**
 *
 * @author user-
 */
public class Ej1 {

    public static void main(String[] args) {
        //Test
        //Ej1Cliente es extension de Thread
        Ej1Cliente juan = new Ej1Cliente();
        juan.setName("Juan");
        Ej1Cliente ines = new Ej1Cliente();
        ines.setName("Ines");
        juan.start();
        ines.start();
    }
}
