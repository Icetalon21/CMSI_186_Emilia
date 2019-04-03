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
 *  @version 1.0.6  2019-04-01  Emilia Huerta Wrote polyIntegrate
 *  @version 1.0.7  2019-04-02  Emilia Huerta Handled Arguments
 *  @version 1.0.8  2019-04-02  Emilia Huerta Revived fields and constructor
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class Riemann{
   // private String type;
   private double[] coeffs;
   private double lowerBound;
   private double upperBound;
   private double percent;

   public Riemann(double lowerBound, double upperBound, double[] coeffs, double percent){
      this.lowerBound = lowerBound;
      this.upperBound = upperBound;
      this.coeffs = coeffs;
      this.percent = percent;
      //handle type
      //handle coeffs
      // System.out.println(polyIntegrate(lowerBound, upperBound, coeffs));
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

   public void handleInitialArguments(String args[]){
      if(4 > args.length){
         System.out.println(" Sorry you have entered in too few arguments \n");
         System.exit(0);
      }
   }

   public double getMid(double upperBound, double lowerBound){
      return (upperBound + lowerBound) / 2;
   }

   public double polyCalc(double x, double [] args){
      int lastArg = args.length -1;
      double answer = 0;
      for(int i = lastArg; i >= 0; i--){
         double math = args[0] * (Math.pow(x, i));
         answer = answer + math;
      }
      return answer;
   }

   public double polyIntegrate(/* double lowerBound, double upperBound, double[] coeffs */){
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

      double [] coeffs = new double[3];

      coeffs[0] =  Double.parseDouble(args[1]);
      coeffs[1] =  Double.parseDouble(args[2]);
      coeffs[2] =  Double.parseDouble(args[3]);

      double percent = 0, upperBound = 0, lowerBound = 0;

      Riemann riemann = null;

      System.out.println(" \n Hello world, from the Riemann program \n");

      if(args[args.length -1].contains("%")){
         percent = Double.parseDouble(args[args.length -1].substring(0, args[args.length -1].length() - 1));
         upperBound = Double.parseDouble((args[args.length - 2]));
         lowerBound = Double.parseDouble((args[args.length - 3]));
      }
      if(!args[args.length - 1].contains("%")){
         percent = 0.01;
         upperBound = Double.parseDouble((args[args.length - 1]));
         lowerBound = Double.parseDouble((args[args.length - 2]));
      }

      if(args[0].equals("poly")){
         riemann = new Riemann(lowerBound, upperBound, coeffs, percent);
      }
      else if(args[0].equals("sin")){
         /* riemann = new Riemann(lowerBound, upperBound, args); */
      }
      else{
         throw new IllegalArgumentException("not an option");
      }

      double result = riemann.polyIntegrate();

      // int x = 1;
      // for(int i = 0; i < args.length; i++){

      // }

      //make a riemann(blah blah blah, percent)

      // switch(args[0]){
      //    case "poly":

      // }
   }
 }
