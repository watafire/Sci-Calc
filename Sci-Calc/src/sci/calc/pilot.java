/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sci.calc;
import java.util.*;
import java.lang.reflect.*;
import java.io.InputStream;


/**
 *
 * @author Sean Garnett, Jacob Ogden
 */
public class pilot {
    
    public static void main2() {
        String command;
        Scanner in = new Scanner(System.in);
        
        
        System.out.print("Input command: ");
        
        while(!in.hasNext("exit")) {
            command = in.next();
            System.out.println(command);
            
            Scanner scanner = new Scanner(command);
            
            scanner.close();
        }

        
        
        in.close();
        }
    
    public static void main() {
        int iNum1, iNum2;
        double dNum1, dNum2;
        String oper, end = "";
        String compare = null;
        Scanner in = new Scanner(System.in);
        
        /* 
            Trying to set up a way to compare an operator to a 
            method in the lib.java
        */
        Map<String, Double> operator = new HashMap<String, Double>();
        
        
        while(!end.equals("1"))
        {
            /*
                Setting variables to zero so that the prgram doesn't use
                the last iterations numbers.
            */
            iNum1 = 0; iNum2 = 0; dNum1 = 0.0; dNum2 = 0.0;
            
            //Determining whether its an int or double for num1
            System.out.print("Input num 1: ");
            if(in.hasNextInt())
            {
                iNum1 = in.nextInt();
            } else if(in.hasNextDouble())
            {
                dNum1 = in.nextDouble();
            } else //Incase a int or double wasn't entered. Acts weird.
            {
                System.out.println("Please enter a number.");
            }
            
            //Determining whether its an int or double for num2
            System.out.print("Input num 2: ");
            if(in.hasNextInt())
            {
                iNum2 = in.nextInt();
            } else if(in.hasNextDouble())
            {
                dNum2 = in.nextDouble();
            } else //Incase a int or double wasn't entered. Acts weird.
            {
                System.out.println("Please enter a number.");
            }
            System.out.print("Operator: ");
            oper = in.next();
            
            /*
                Trying to set up so that when a int or double is 
                entered the correct method is called without an error.
            */
            
            if ((iNum1 != 0 && iNum2 != 0) || (iNum1 == 0 || iNum2 == 0))
            {
                System.out.println(lib.add(iNum1, iNum2));
            }
            
            if (dNum1 != 0.0 && dNum2 != 0.0)
            {
                System.out.println(lib.add(dNum1, dNum2));
            }
            System.out.println("press 1 to exit");
            end = in.next();
        }
        
        /*Trying to set up a HashMap so we can compare an inputted
          operator to a method in the library. ie "+" will call the
          lib.add() method with out us typing it in.*/
        /*operator.put("+", lib.add(num1, num2));
        operator.put("-", lib.subtract(num1, num2));
        operator.put("*", lib.multiply(num1, num2));
        operator.put("/", lib.divide(num1, num2));*/
        
       in.close();
    }
    
}
