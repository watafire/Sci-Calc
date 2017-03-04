/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

/**
 *
 * @author Sean Garnett, Jacob Ogden
 */
public class Lib {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(multiply(1.0, 3));
        // TODO code application logic here
    }
    
    public static int add(int a, int b) {
        return a+b ;
    }
    
    public static double add(double a, double b) {
        return a+b;
    }
    
    public static int subtract(int a, int b) {
        return a-b;
    }
    
    public static double subtract(double a, double b) {
        return a-b;
    }
    
    public static int multiply(int a, int b) {
        return a*b;
    }
    
    public static double multiply(double a, double b) {
        return a*b;
    }
    
}
