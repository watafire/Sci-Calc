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
    
    
    /*
    * Using main2 in SciCalc
    */
    public static void main2() {
        String command;
        Scanner in = new Scanner(System.in);
        
        System.out.print("Input command: ");
        
        /*
        *   Used a do while so that it can check the "in" scanner after the first input is ented
        *   This way the while loop can check to scanner directly.
        */
        
        do {
            /*
            *   command is used to store the command inputed so it can be parsed into multiple arrays.
            *   This way the we can parse only the numbers or only the operations.
            *   We also keep the order of both by their entry in the given arrays. 
            *
            *   Currently I need to write a TRY and Catch loop to deal with non-digit non-operator input
            */
            
            command = in.nextLine();
            
            if (command.equals("exit")) {
            break;
            }
            
            System.out.println(command);
            String[] strngDigits = command.split("[+\\-*/\\^ ]+");
            String[] operators = command.split("\\d");
            Double[] digits = new Double[strngDigits.length];
            
            for (int i = 0; i < strngDigits.length; i++) {
                digits[i] = Double.parseDouble(strngDigits[i]);
            }
            
            for (int i = 0; i < digits.length; i++) {
                System.out.println(digits[i]);   
            }
            
            for (int i = 0; i < operators.length; i++){
                System.out.println(operators[i]);
            }
        } while(!in.hasNext("exit"));

        
        
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
