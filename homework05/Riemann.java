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
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class Riemann{

   public Riemann( String type, int[] coeffs, double lowerbound, double upperBound, double percent){

   }

   // public static int coefficients (int[] coeffs){
   //    if
   // }


   public static void main (String [] args){
      if(args[args.length -1].contains("%")){
         Double.parseDouble(args[args.length - 1]);
         Double.parseDouble(args[args.length -1].substring(0, args.length - 1));
      }
      
      switch(args[0]){
         case "poly": 

      }
   }
 }
