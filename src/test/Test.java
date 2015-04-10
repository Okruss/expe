/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Okruss
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NumeroLetra nl = new NumeroLetra();
        String num="10055.00";
        System.out.println(num+" = "+nl.Convertir(num, true));
        // TODO code application logic here
    }
    
}
