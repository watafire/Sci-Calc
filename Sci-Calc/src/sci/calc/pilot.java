/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sci.calc;
import java.util.Scanner;
import java.io.InputStream;

/**
 *
 * @author Sean Garnett, Jacob Ogden
 */
public class pilot {
    
    public static void main() {
        int num1, num2, num3 = 0;
        String end = " ";
        String compare = null;        Scanner in = new Scanner(System.in);
        
       
        while(end.equals(" ")) {
            System.out.print("Input first number: ");
            num1 = in.nextInt();
            System.out.print("Input num 2: ");
            num2 = in.nextInt();
            System.out.print("Operator: ");
            num3 = in.nextInt();
            System.out.println(lib.add(num1, num2));
            System.out.println("press 1 to exit");
            end = in.next();
        }
        
    }
    
}
