/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Riemann.java
 *  Purpose       :  Provides a class describing a single soccer ball.
 *  @author       :  Emilia Huerta
 *  Date          :  2019-03-20
 *  Description   :  This class computes definite integrals using Riemann integration.
 *
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None Yet
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2019-03-20  Emilia Huerta Created basic constructor
 *  @version 1.0.1  2019-03-25  Emilia Huerta Attempted to deal with "%"
 *  @version 1.0.2  2019-03-25  Emilia Huerta Wrote fields; tried to find roots
 *  @version 1.0.3  2019-03-27  Emilia Huerta Wrote for if % or no %
 *  @version 1.0.4  2019-03-31  Emilia Huerta Wrote method for getMid() and polyCalc()
 *  @version 1.0.5  2019-03-31  Emilia Huerta Changed type switch to if statements
 *  @version 1.0.6  2019-04-01  Emilia huerta Wrote polyIntegrate
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class Riemann{
   // private String type;
   // private double[] coeffs;
   // private double lowerBound;
   // private double upperBound;
   // private double percent;

   public Riemann(double lowerBound, double upperBound, double[] coeffs, double percent){
      //handle type
      //handle coeffs
   }

   // public static int coefficients (double[] args){
   //    if()
   // }

   // public void type( String args[]){
   //    switch(args[0]){
   //       case "poly":
   //    }
   // }

   // public void getHeight(){

   // }

   public static double getMid(Double upperBound, Double lowerBound){
      return (upperBound + lowerBound) / 2;
   }

   public static double polyCalc(Double x, Double [] args){
      int lastArg = args.length -1;
      double answer = 0;
      for(int i = lastArg; i >= 0; i--){
         double math = args[0] * (Math.pow(x, i));
         answer = answer + math;
      }
      return answer;
   }

   public static double polyIntegrate(Double lowerBound, Double upperBound, Double[] coeffs){
      double previous = 0;
      double area = (upperBound - lowerBound) * polyCalc((upperBound + lowerBound) / 2, coeffs);

      while (Math.abs(previous - area) > 0.01){
         double width = Math.abs((upperBound - lowerBound) / 2);
         double newLowerBound = lowerBound;
         double newUpperBound = upperBound;
         previous = area;
         area = 0;

         for(int i = 2; i > 0; i--){
            area = area + ((newUpperBound - newLowerBound) * polyCalc((newUpperBound + newLowerBound) / 2, coeffs));
            newLowerBound = newLowerBound + width;
            newUpperBound = newUpperBound + width;
         }
      }
      return area;
   }

   // static void bisectionMethod(double a, double b){
   //    double c = a;
   //    while ((b-a) >= 0.01){
   //       c = (a + b) / 2;
   //    }
   // }

   // public static findRoots(double coefficients){
   //    int N = coefficients.length -1;
   //    test c = new test (N,N);
   //    double a = coefficients[N];
   //    for(int i = 0; i < N; i++){
   //       c.set(i, N-1, -coefficients[i]/a);
   //    }
   //    for(int i = 1; i < N; i++){
   //       c.set(i,i-1,1);
   //    }
   // }

   public static void main (String [] args){
      System.out.println(" \n Hello world, from the Riemann program \n");
      if(args[args.length -1].contains("%")){
         double percent = Double.parseDouble(args[args.length -1].substring(0, args[args.length -1].length() - 1));
         double upperBound = Double.parseDouble((args[args.length - 2]));
         double lowerBound = Double.parseDouble((args[args.length - 3]));
      }
      if(!args[args.length - 1].contains("%")){
         double percent = 0.01;
         double upperBound = Double.parseDouble((args[args.length - 1]));
         double lowerBound = Double.parseDouble((args[args.length - 2]));
      }

      if(args[0].equals("poly")){
         Riemann riemann = new Riemann(lowerBound,upperBound, args)
      }
      else if(args[0].equals("sin")){
         Riemann riemann = new Riemann(lowerBound, upperBound, args)
      }
      else{
         throw new IllegalArgumentException("not an option")
      }
      // int x = 1;
      // for(int i = 0; i < args.length; i++){

      // }

      //make a riemann(blah blah blah, percent)

      // switch(args[0]){
      //    case "poly":

      // }
   }
 }
