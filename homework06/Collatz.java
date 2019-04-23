/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  Collatz.java
 * Purpose    :  Write a script that takes in a BrobInt and reports the number of steps required in the Collatz sequence to reach the value 1.

 * @author    :  Emilia Huerta
 * Date       :  2019-04-22
 * Description:  @see <a href='http://bjohnson.lmu.build/cmsi186web/homework06.html'>Assignment Page</a>
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:   Reason for change or modification
 *  -----  ----------  ------------   ---------------------------------------------------------------------
 *  1.0.0  2019-04-22  Emilia Huerta  Initial writing and begin coding
 *  1.0.1  2019-04-22  Emilia Huerta  Returns numbers yet incorrect
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */


public class Collatz{
   public double n;

   public Collatz(){

   }

   public double GetCollatzSequenceSteps(double n) {
   double steps = 0;
   double n1 = Double.valueOf(n);
   while (n != 1) {
      double number = Math.floor((n1%2==0)?n1/2:3*n1+1);
      steps++;
   }
   System.out.println(steps + " steps were necessary");
   return steps;
}
// public double GetCollatzSequenceSteps() {
//    double steps = 0;
//    // double n1 = Double.valueOf(n);
//    while (n != 1) {
//       double number = Math.floor((n%2==0)?n/2:3*n+1);
//       steps++;
//    }
//    System.out.println(steps + " steps were necessary");
//    return steps;
// }

   // public String toString() {
   //    return steps;
   // }
   public static void main( String[] args ){
      System.out.println( "\n  Hello, world, from the Collatz program!!\n" );
      Collatz collatz = new Collatz();
      double number = 0;
      BrobInt b = new BrobInt(args[0]);
      while(!b.equals(BrobInt.ONE));
      try{
         number = Double.parseDouble(args[0]);
      }
      catch(NumberFormatException nfe){System.out.println("Bad input");}
      collatz.GetCollatzSequenceSteps(Double.parseDouble(args[0]));
   }

//  let input = 0;
//  while (input < 1 || input > 10000) {
//     input = parseInt(prompt("Enter an integer in the range [1,10000]"));
//  }
//  alert(GetCollatzSequenceSteps(input));
}
