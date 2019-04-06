/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Riemann.java
 *  Purpose       :
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
 *  @version 1.1.8  2019-04-05  Emilia Huerta Commented out unecessary prints
 *  @version 1.1.9  2019-04-05  Emilia Huerta Implemented sine - fixed percent change
 *  @version 1.2.0  2019-04-05  Emilia Huerta Cleaned up code
 *  @version 1.2.1  2019-04-05  Emilia Huerta Cleaned up code 2.0
 *  @version 1.2.2  2019-04-06  Emilia Huerta Tried to implement cosine for fun
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class Riemann{
    // private static final String poly = null; //for tester
    private double[] coeffs;
    private int coeffCount;
    private double lowerBound;
    private double upperBound;
    private double percent = 1;


    public Riemann(){

    }

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
            width /= 2;
            // System.out.println("coeffs" + coeffs[0]);
            for( double i = lowerBound; i < upperBound; i += width){
                currentArea += solvePoly(i - width/2, coeffs); //adds all areas
            }
            currentArea *= width;
            // System.out.println("current area " + currentArea);
        }
        System.out.println("current area is " + Math.floor(currentArea));
        return Math.floor(currentArea);
    }

    public double solveSin(double y){
        double solved = 0.0; // if inputs.length == 0
        double x = 0.0;

        if (coeffs.length == 0){
            solved = Math.sin(x);
        }else{
            x = solvePoly(y, coeffs); //getting whatever that y value is?
            solved = Math.sin(x);
        }

        return solved;
    }

    public double sinIntegrate(){
        double currentArea = (upperBound - lowerBound) * (Math.sin((upperBound + lowerBound) / 2));
        double  slice = 2;
        double previousArea = 0;

        while(Math.abs(previousArea - currentArea)/previousArea > percent/100){
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
        System.out.print("Current Sine Area is " + currentArea);
        return currentArea;
    }

    public double solveCos(double y){
        double solved = 0.0; // if inputs.length == 0
        double x = 0.0;

        if (coeffs.length == 0){
            solved = Math.cos(x);
        }else{
            x = solvePoly(y, coeffs); //getting whatever that y value is?
            solved = Math.cos(x);
        }

        return solved;
    }

    public double cosIntegrate(){

		double previousArea = 0;
		double slice = 2;
		double currentArea = (upperBound - lowerBound) * (Math.cos((upperBound + lowerBound) / 2));

		while (Math.abs(previousArea - currentArea) / previousArea > percent/100) {

			double width =  Math.abs((upperBound - lowerBound) / slice);
			double newLowBound = lowerBound;
		    double newUpBound = lowerBound + width;
			previousArea = currentArea;
			currentArea = 0;

			for(int i = (int) slice; i > 0; i-- ) {

				currentArea = currentArea + ((newUpBound - newLowBound) * (Math.cos((newUpBound + newLowBound) / 2)));

				newLowBound = newLowBound + width;
				newUpBound = newUpBound + width;

			}
			slice = Math.pow(slice, 2.0);

		}
        System.out.println("Current Cosine Area is " + currentArea);
		return currentArea;
	}


    public static void main (String [] args){

        // System.out.println(" \n Hello world!!\n");
        Riemann riemann = new Riemann();
        // Riemann tester = new Riemann(poly, 0, 1, 2);
        // System.out.println("Tester area is " + tester.polyIntegrate());

        double percent = 0;
        double upperBound = 0;
        double lowerBound = 0;

        try{
            riemann.handleInitialArguments(args);
        }
        catch(IllegalArgumentException illegalArgumentException){
            System.out.println("Please enter in valid arguments");
        }

        riemann.numberOFCoeff(args);

        // System.out.println(" \n Hello world, from the Riemann program \n");

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

        try{
        riemann.isInBounds(riemann.lowerBound, riemann.upperBound);
        }
        catch(IllegalArgumentException illegalArgumentException){
            System.out.println("less");
        }

        if(args[0].equals("poly")){
            riemann.polyIntegrate();
        }
        else if(args[0].equals("sin")){
            riemann.sinIntegrate();
        }
        else if(args[0].equals("cos")){
            riemann.cosIntegrate();
        }
        else{
            throw new IllegalArgumentException("not an option");
        }
    }
}
