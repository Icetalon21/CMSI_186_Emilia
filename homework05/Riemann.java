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
 *  @version 1.0.9  2019-04-02  Emilia Huerta Killed constructor, numberOfCoeff()
 *  @version 1.1.0  2019-04-02  Emilia Huerta Fixed handleInitialArguments()
 *  @version 1.1.1  2019-04-03  Emilia Huerta Changed polyCalc() - not correct answer
 *  @version 1.1.2  2019-04-03  Emilia Huerta Fixed isInBounds() - correct
 *  @version 1.1.3  2019-04-03  Emilia Huerta Number of boxes is incorrect - stuck at 1
 *  @version 1.1.4  2019-04-04  Emilia Huerta Deleted n boxes, changed polyIntegrate()
 *  @version 1.1.5  2019-04-04  Emilia Huerta Implemented Math.floor and 0.0
 *  @version 1.1.6  2019-04-04  Emilia Huerta Tried to implement sine - failed
 *  @version 1.1.7  2019-04-04  Emilia Huerta Change of percent was wrong - fixed
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class Riemann{
   // private String type;
    private double[] coeffs;
    private int coeffCount;
    private double lowerBound;
    private double upperBound;
    private double percent = 1;


//    public Riemann(double lowerBound, double upperBound, double[] coeffs, double percent){
//       this.lowerBound = lowerBound;
//       this.upperBound = upperBound;
//       this.coeffs = coeffs;
//       this.percent = percent;
//       this.coeffCount = coeffCount;
//       // coeffs = new double [this.coeffCount];
//       // for(int i = 0; i < coeffCount; i ++){
//       //    coeffs[i] = new double[] coeffs;


//       //handle type
//       //handle coeffs
//       // System.out.println(polyIntegrate(lowerBound, upperBound, coeffs));
//    }

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
            System.out.println("Sorry, you have entered in too few arguments \n");
            System.exit(0);
        }
    }

    public void isInBounds(double lowerBound, double upperBound){
        if(lowerBound > upperBound){
            System.out.println("Sorry, lower bound cannot be greater than upper bound");
            System.exit(1);
        }
    }

    public double getMid(double upperBound, double lowerBound){
        return (upperBound + lowerBound) / 2;
    }

    public void numberOFCoeff(String args[]){
        if (args.length > 0) {
            if (!args[args.length - 1].contains("%")) {
                int numberOFCoeff  = args.length - 3;//poly,ub,lb
                coeffs = new double[numberOFCoeff];
                for(int i=0; i < numberOFCoeff; i++){
                    if (Double.parseDouble(args[i+1]) != 0.0){
                        // System.out.println("Containing " + Double.parseDouble(args[i+1]));
                        coeffs[i] = Double.parseDouble(args[i + 1]);
                    }
                }
            } else {
                int numberOFCoeff  = args.length - 4;//poly,ub,lb,percent
                coeffs = new double[numberOFCoeff];
                for(int i=0; i < numberOFCoeff; i++){
                    if (Double.parseDouble(args[i+1]) != 0.0)
                        coeffs[i] = Double.parseDouble(args[i + 1]);
                }
            }
        }
    }

   // public double[] getCoeffs(){
   //    return this.coeffs;
   // }

    public double polyCalc(double x, double [] localCoeffs){
        // int lastArg = localCoeffs.length -1;
        System.out.println(x);
        double answer = 0;
        // for(int i = lastArg; i >= 0; i--){
        for(int i = 0; i < localCoeffs.length; i++){
            System.out.println("Multiplying " + localCoeffs[i] + " " +  (Math.pow(x, localCoeffs[i])));
            double math = localCoeffs[i] * (Math.pow(x, localCoeffs[i]));
            answer = answer + math;
        }
        return answer;
    }

    public double solvePoly(double x, double[] localCoeffs){
        double solved = 0;
        for(int i=0; i < localCoeffs.length; i++){
            // System.out.println("Multiplying " + localCoeffs[i] + " " +  (Math.pow(x, localCoeffs[i])));
            solved += (localCoeffs[i] * (Math.pow(x, i)));
        }
        // if(solved == 0.0){
        //     // System.out.println("area is 0.0");
        //     System.exit(2);
        // }
        // System.out.println("solved " + solved);
        return solved;
    }

    public double polyIntegrate(/* double lowerBound, double upperBound, double[] coeffs */){
        double width = (upperBound - lowerBound);
        double currentArea = 1;
        double previousArea = 1;
        while((currentArea == 1 || (percent/100) < Math.abs((previousArea - currentArea) / previousArea)) && currentArea != 0.0){
            previousArea = currentArea;
            currentArea = 0;
            width /= 1.5;
            System.out.println("coeffs" + coeffs[0]);
            for( double i = lowerBound; i < upperBound; i += width){
                currentArea += solvePoly(i - width/2, coeffs); //adds all areas
            }
            currentArea *= width;
            System.out.println("current area " + currentArea);
        }
        // System.out.println("current area " + Math.floor(currentArea));
        return Math.floor(currentArea);
    }

    public double sinIntegrate(double lowerBound, double upperBound){
        double currentArea = (upperBound - lowerBound) * (Math.sin((upperBound + lowerBound) / 2));
        double  slice = 2;
        double previousArea = 0;

        while(Math.abs(previousArea - currentArea) > 0.01){
            double width = (upperBound - lowerBound)/2;
            double newLowerBound = lowerBound;
            double newUpperBound = lowerBound + width;
            previousArea = currentArea;
            currentArea = 0;

            for(int i =  (int) slice; i > 0; i --){
                currentArea = currentArea + ((newUpperBound - newLowerBound) * (Math.sin(newUpperBound + newLowerBound) / 2));

                newLowerBound = newLowerBound + width;
                newUpperBound = newUpperBound + width;
            }
            slice = Math.pow(slice, 2.0);
        }
        System.out.print("Current Sine Area" + currentArea);
        return currentArea;
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

        System.out.println(" \n Hello world!!\n");
        Riemann riemann = new Riemann();

    //   double [] coeffs = new double[3];

    //   coeffs[0] =  Double.parseDouble(args[1]);
    //   coeffs[1] =  Double.parseDouble(args[2]);
    //   coeffs[2] =  Double.parseDouble(args[3]);

        double percent = 0;
        double upperBound = 0;
        double lowerBound = 0;

        // riemann.numberOFCoeff(args);


      // Riemann riemann = null;
        try{
            riemann.handleInitialArguments(args);
        }
        catch(IllegalArgumentException illegalArgumentException){
            System.out.println("Please enter in valid arguments");
        }

        riemann.numberOFCoeff(args);

        System.out.println(" \n Hello world, from the Riemann program \n");

        if(args[args.length -1].contains("%")){
            // riemann.percent = Double.parseDouble(args[args.length -1].substring(0, args[args.length -1].length() - 1));
            riemann.percent = Double.parseDouble(args[args.length - 1].replace("%", " ").trim());
            riemann.upperBound = Double.parseDouble((args[args.length - 2]));
            riemann.lowerBound = Double.parseDouble((args[args.length - 3]));
        }
        if(!args[args.length - 1].contains("%")){
            riemann.percent = 0.01;
            riemann.upperBound = Double.parseDouble((args[args.length - 1]));
            riemann.lowerBound = Double.parseDouble((args[args.length - 2]));
        }
        // if(args[args.length - 1].contains("%")){
        //     percent = Double.parseDouble(args[args.length - 1].replace("%", " ").trim());
        //     upperBound = Double.parseDouble(args[args.length -2]);
        //     lowerBound = Double.parseDouble(args[args.length -3]); //need to adjust when upperbound is smaller?
        //     for(int i = 1; i < (args.length - 3); i++ ){
        //         riemann.coeffs.add(Double.parseDouble(args[i])); 
        //     }
        // }else{ //percent is required 
        //     upperBound = Double.parseDouble(args[args.length -1]);
        //     lowerBound = Double.parseDouble(args[args.length -2]);
        //     for(int i = 1; i < (args.length - 2); i++ ){
        //         inputs.add(Double.parseDouble(args[i])); 
        //     }

        try{
        riemann.isInBounds(riemann.lowerBound, riemann.upperBound);
        }
        catch(IllegalArgumentException illegalArgumentException){
            System.out.println("less");
        }

        if(args[0].equals("poly")){
            riemann.polyIntegrate();
         // riemann = new Riemann(lowerBound, upperBound, coeffs, percent);
        }
        else if(args[0].equals("sin")){
            riemann.sinIntegrate(lowerBound, upperBound);
         /* riemann = new Riemann(lowerBound, upperBound, args); */
        }
        else{
            throw new IllegalArgumentException("not an option");
        }

        // double result = riemann.polyIntegrate();

      // int x = 1;
      // for(int i = 0; i < args.length; i++){

      // }

      //make a riemann(blah blah blah, percent)

      // switch(args[0]){
      //    case "poly":

      // }
    }
}
