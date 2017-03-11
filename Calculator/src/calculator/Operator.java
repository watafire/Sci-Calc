package calculator;
// Sean Garnett Term Project
public class Operator {
  static final double lnTen =  2.302585092994045;
  static final double pi = 3.14159265359;
  static double tenExponent;
  
  // default truncate method, to 3 decimal places
  public static double truncate(double x) {
    x = (int) (x * 1000);
    return x / 1000;
  }
  
  // truncates the given vale to y decimal places
  public static double truncate(double x, int y) {
    double factor = 1;
    for (int i = 0; i < y; i++) {
      factor *= 10;
    }
    x = (int) (x * factor);
    return x / factor;
  }
  
  // uses the change of base formula log b x = ln x / ln y
  public static double logB(double x, double y) {
    return (toln(y)/toln(x));
  }
  
  // uses the nat_log(x)(converges for x < 1) function to find ln(x)
  public static double toln(double x) {
    tenExponent = 0.0;
    
    while(x > 1) {
      x /= 10;
      tenExponent++;
    }  
    return tenExponent * lnTen + nat_log(x);
  }
  
  //returns x! (x*(x-1)*(x-2)...Till x=1)
  //utilises the float data type becase it occasionaly
  //rounds slightly up and provides a more accurate result for int like types
  public static float factorial (int x) {
    if (x == 1){
      return 1;
    }
    return x*factorial(x-1);
  }
  
  //x^y = e^(y*ln(x)
  // uses 3 different functions to compute the value of x to the y
  public static double power(double x, double y) {
    return eTo(y * toln(x));
  }
  
  // finds x^y for integer values of y
  // uses an if loop in case y=0, which should return 1.
  // can handle cases of y<0.
  public static double power(double x, int y) {
    if(y < 1) {
      return 1;
    }
    return x*power(x, y - 1);
  }
  
  // Using a Taylor Expansion to approximate the natural logrithm of x
  //  ln(x) = sum from 1 to infinity of ((-1)^(n+1)) * ((x-1)^n)/n
  public static double nat_log(double x) {
    double result = 0.0;
    for (int n = 1; n < 1000; n++) {
      double a = x - 1;
      int b = 1;
      for (int j = 1; j < n; j++) {
        a *= (x - 1);
        b *= -1;
      }
      result += b * a / n;
    }
    return result;
  }
  
  /* Uses a Taylor Polynomial to find e^x
   * e^x = sum 0-infi (x^n)/(n!)
   * at n = 0, (x^n)/(n!) = 1, solved by initializing result as 1
   */
  public static double eTo(double q) {
    double result = 1.0;
    for (int n = 1; n < 100; n++) {
      result += power(q, n) / factorial(n);
    }
    return result;
  }

    // converts x to radians
  public static double toRad(double x) {
    return x * (pi / 180);
  }
  
  // converts x to degrees
  public static double toDeg(double x) {
    return x * (180 / pi);
  }
  
  // finds sin(x) (in rads) using a Taylor Polynomial
  // sum from 0 to infinity of (-1)^(n-1) *((x^(2*n-1))/(2*n-1)!)
  public static double sin(double x) {
    double result = 0.0;
    for (int n = 1; n  < 100; n++){
      result += power(-1, n-1) * power(x, 2*n-1) / factorial(2*n-1);
    }
    return result;
  }
  
  // uses the trig identity cscx = 1/sinx
  public static double csc(double x){
    return 1 / sin(x);
  }

    // finds cos(x) (in rads) using a Taylor Polynomial
  // sum from 0 to infinity of (-1)^n *((x^(2*n))/(2*n)!)
  public static double cos(double x) {
    double result = 1.0;
    for (int n = 1; n  < 100; n++){
      result += power(-1, n) * power(x, 2*n) / factorial(2*n);
    }
    return result;
  }
  
  // uses the trig identity secx = 1 / cosx
  public static double sec(double x) {
    return 1 / cos(x);
  }
  
  //finds tan x using the identity tanx = sinx / cosx
  public static double tan(double x) {
    return sin(x) / cos(x);
  }
  
  //uses the trig identity secx = 1 / tanx
  public static double cot(double x) {
    return 1 / tan(x);
  }
  
  // Supposed to find the arcsin of x using a malcom series polynomial currently bugged
  public static double arcsin(double x) {
    double result = 0.0;
    for (int n = 0; n < 100; n++) {
      result += (((factorial(2*n)/(factorial(n)*factorial(2*n-n)))*power(x, (2*n+1)))/(power(4, n) *(2*n+1)));
    }
    return result;
  }
  
  // finds the artan of x using a malcum series polynomial, given that |x| < 1
  public static double arctan(double x) {
    double result = 0.0;
    for (int n = 0; n < 100; n++) {
    result += ((power(-1, n) * power (x, (2*n+1)) ) / (2*n +1));
    }
    return result;
  }
}
