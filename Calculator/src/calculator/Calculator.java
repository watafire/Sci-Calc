package calculator;
import java.util.*;
public class Calculator {
  static double x, y;
  static int trn = 3;
  static String s, op="";
  public static void main(String[] args) {
    Scanner console = new Scanner(System.in);
    
    System.out.println("For a list of commands and features type 'HELP'");
    
    while (op.equals("EXIT") != true) {
      System.out.print("Perform: ");
      s = console.nextLine();
      setVars(s);
      perform();
    }
    console.close();
  }
  
  static void setVars(String s1) {
    Scanner scanner = new Scanner(s1);
    if (scanner.hasNextDouble()) {
      x = scanner.nextDouble();
    } else { 
      x = 0;
    }
    
    if (scanner.hasNext()) {
      op = scanner.next();
    } else {
      op = "";
    }
    
    if (scanner.hasNextDouble()) {
      y = scanner.nextDouble();
    } else { 
      y = 0;
    }
    scanner.close();
  }
  
  static void perform () {
    switch(op) {
      case "EXIT":
        break;
      case "HELP":
        help();
        break;
      case "TRUNCATE":
        trn = (int) y;
        break;
      case "+":
        System.out.print(x + " + " + y + " = ");
        System.out.println(Operator.truncate(x + y, trn));
        break;
      case "-":
        System.out.print(x + " - " + y + " = ");
        System.out.println(Operator.truncate(x - y, trn));
        break;
      case "*":
        System.out.print(x + " * " + y + " = ");
        System.out.println(Operator.truncate((x * y), trn));
        break;
      case "/":
        System.out.print(x + " / " + y + " = ");
        System.out.println(Operator.truncate(x / y, trn));
        break;
      case "^":
        System.out.print(x + " ^ " + y + " = ");
        System.out.println(Operator.truncate(Operator.power(x, y), trn));
        break;
      case "Radians":
        System.out.print(x + " Degrees = ");
        System.out.println(Operator.truncate(Operator.toRad(x), trn));
        break;
      case "Degrees":
        System.out.print(x + " Radians = ");
        System.out.println(Operator.truncate(Operator.toDeg(x), trn));
        break;
      case "sin":
        System.out.print("sin " + y + " = ");
        System.out.println(Operator.truncate(Operator.sin(y), trn));
        break;
      case "cos":
        System.out.print("cos " + y + " = ");
        System.out.println(Operator.truncate(Operator.cos(y), trn));
        break;
      case "tan":
        System.out.print("tan " + y + " = ");
        System.out.println(Operator.truncate(Operator.tan(y), trn));
        break;
      case "sec":
        System.out.print("sec " + y + " = ");
        System.out.println(Operator.truncate(Operator.sec(y), trn));
        break;
      case "csc":
        System.out.print("csc " + y + " = ");
        System.out.println(Operator.truncate(Operator.csc(y), trn));
        break;
      case "cot":
        System.out.print("cot " + y + " = ");
        System.out.println(Operator.truncate(Operator.cot(y), trn));
        break;
      case "log":
        System.out.print("log base: " + y + " of " + x + "= ");
        System.out.println(Operator.truncate(Operator.logB(x, y), trn));
        break;
      case "ln":
        System.out.print("ln " + y + " = ");
        System.out.println(Operator.truncate(Operator.toln(y), trn));
        break;
      case "e^":
        System.out.print("e^ " + y + " = ");
        System.out.println(Operator.truncate(Operator.eTo(y), trn));
        break;
      case "arcsin":
        System.out.println("Currently unsupported");
      case "arccos":
        System.out.println("Currently unsupported");
      case "arctan":
        System.out.println("Currently unsupported");
      case "arcsec":
        System.out.println("Currently unsupported");
      case "arccsc":
        System.out.println("Currently unsupported");
      case "arccot":
        System.out.println("Currently unsupported");
      default:
        System.out.println("ERROR: refer to the help content Below");
        System.out.println();
        help();
        break;
    }
  }
  
  static void help() {
    System.out.println();
    System.out.println("EXIT: exit the program");
    System.out.println("TRUNCATE a: sets the number of decimal places to truncate to by (Default 3)");
    System.out.println("Basic Operators (+, -, *, /, ^) follow the format: 'A_OPERATOR_B'");
    System.out.println("Trig Operators (sin, arcsin) format: sin(a) or arcsin(a)");
    System.out.println("Converting between degrees and radians, format: '180 Radians' gives pi, while '3.14... Degrees' gives 180");
    System.out.println("Logrithmic Operators: 'e^_A',  'ln_A', base_log_A");
    System.out.println();
  }
}
