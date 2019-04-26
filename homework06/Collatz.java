/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  Collatz.java
 * Purpose    :  Write a script that takes in a BrobInt and reports the number of steps required in the Collatz sequence to reach the value 1.

 * @author    :  Emilia Huerta
 * Date       :  2019-04-22
 * Description:  @see <a href='http://bjohnson.lmu.build/cmsi186web/homework06.html'>Assignment Page</a>
 * Notes      :  If a number in the sequence, n, is even, then the next number in the sequence is n / 2
 *               If a number in the sequence, n, is odd, then the next number in the sequence is 3n +

 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:   Reason for change or modification
 *  -----  ----------  ------------   ---------------------------------------------------------------------
 *  1.0.0  2019-04-22  Emilia Huerta  Initial writing and begin coding
 *  1.0.1  2019-04-22  Emilia Huerta  Returns numbers yet incorrect
 *  1.0.2  2019-04-23  Emilia Huerta  First test works
 *  1.0.3  2019-04-23  Emilia Huerta  Works for most
 *  1.0.4  2019-04-26  Emilia Huerta  Cleaned up code
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */


public class Collatz{
   public double n;

   public Collatz(){

   }

   public static void main( String[] args ){
      System.out.println( "\n  Hello, world, from the Collatz program!!\n" );
      // Collatz collatz = new Collatz();
      int steps = 0;
      // int number = Integer.parseInt(args[0]);
      long number = Long.parseLong(args[0]);
      // System.out.print("this is the number " + number);
      BrobInt b = new BrobInt(args[0]);
      // while(!b.equals(BrobInt.ONE)){
      while(number != 1){
         // System.out.println("one " + BrobInt.ONE);
         if(number % 2 == 0){
            number = number/2;
         }else {
            number = (3 * number) + 1;
         }
         // Math.floor((number%2==0)?number/2:3*number+1);
         // System.out.println("after math " + number);
         steps++;
         // System.out.println("Total number of steps is " + steps);
      }
      System.out.println("Total number of steps is " + steps);
   }


}
