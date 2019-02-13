/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  DiceSet.java
 *  Purpose       :  Provides a class describing a set of dice
 *  Author        :  B.J. Johnson
 *  Date          :  2017-02-09
 *  Description   :  This class provides everything needed (pretty much) to describe a set of dice.  The
 *                   idea here is to have an implementing class that uses the Die.java class.  Includes
 *                   the following:
 *                   public DiceSet( int k, int n );                  // Constructor for a set of k dice each with n-sides
 *                   public int sum();                                // Returns the present sum of this set of dice
 *                   public void roll();                              // Randomly rolls all of the dice in this set
 *                   public void rollIndividual( int i );             // Randomly rolls only the ith die in this set
 *                   public int getIndividual( int i );               // Gets the value of the ith die in this set
 *                   public String toString();                        // Returns a stringy representation of this set of dice
 *                   public static String toString( DiceSet ds );     // Classwide version of the preceding instance method
 *                   public boolean isIdentical( DiceSet ds );        // Returns true iff this set is identical to the set ds
 *                   public static void main( String[] args );        // The built-in test program for this class
 *
 *  Notes         :  Stolen from Dr. Dorin pretty much verbatim, then modified to show some interesting
 *                   things about Java, and to add this header block and some JavaDoc comments.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-09  B.J. Johnson  Initial writing and release
 *  @version 2.0.0  2019-02-04  Emilia Huerta Copied from the Repo & changed class names
 *  @version 2.1.0  2019-02-11  Emilia Huerta Wrote the first few classes
 *  @version 2.1.1  2019-02-12  Emilia Huerta Added this.
 *  @version 2.1.2  2019-02-13  Emilia Huerta Finalized Code
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.util.stream.IntStream;

 public class DiceSet {

  /**
   * private instance data
   */
   private int count;
   private int sides;
   private Die[] ds = null;

   // public constructor:
  /**
   * constructor
   * @param  count int value containing total dice count
   * @param  sides int value containing the number of sides on each die
   * @throws IllegalArgumentException if one or both arguments don't make sense
   * @note   parameters are checked for validity; invalid values throw "IllegalArgumentException"
   */
   public DiceSet( int count, int sides ) {
      if ( sides < 4){
         throw new IllegalArgumentException();
      }
      ds = new Die[ count ];
      //enter a loop
      for (int i = 0; i < count; i ++){
         ds[i] = new Die(sides);
      }
      this.count = count; //added with help from TA
      this.sides = sides; //My toString did not work without it
   }

  /**
   * @return the sum of all the dice values in the set
   */
   public int sum() {
      //System.out.println("inside of sum");
      //System.out.println(ds);
      //System.out.println(ds.length);
      int sumOfRollDice = 0;
       for (int i = 0; i < ds.length; i++){
         //System.out.println(ds[i].getClass());
         sumOfRollDice += ds[i].getValue();
      // for (int i : ds){
      //    sum = sum + i;
      // }
      // return sum;
      }
      return sumOfRollDice; //Keeping comments so I can see my thought process
   }

  /**
   * Randomly rolls all of the dice in this set
   *  NOTE: you will need to use one of the "toString()" methods to obtain
   *  the values of the dice in the set
   */
   public void roll() {
      for(int i = 0; i < ds.length; i++){
         ds[i].roll();
      }
   }

  /**
   * Randomly rolls a single die of the dice in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @return the integer value of the newly rolled die
   * @throws IllegalArgumentException if the index is out of range
   */
   public int rollIndividual( int dieIndex ) {
      if (dieIndex < 0 || dieIndex > ds.length){
         throw new IllegalArgumentException();
      }
      int randomOne = ds[dieIndex].roll();
         return randomOne;
   }

  /**
   * Gets the value of the die in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @throws IllegalArgumentException if the index is out of range
   */
   public int getIndividual( int dieIndex ) {
      return ds[dieIndex].getValue();
   }

  /**
   * @return Public Instance method that returns a String representation of the DiceSet instance
   */
   public String toString() {
      String result = "";
      for (int i = 0; i < count; i++){
         result = result + ds[i];
      }
      return result;
   }

  /**
   * @return Class-wide version of the preceding instance method
   */
   public static String toString( DiceSet ds ) {
      return ds.toString();
   }

  /**
   * @return  tru iff this set is identical to the set passed as an argument
   */
   public boolean isIdentical( DiceSet secondSet ) {
      if(ds.length != secondSet.ds.length){
         return false;
      }
      for(int i = 0; i < secondSet.ds.length; i++){
         if (secondSet.ds[i].getValue() != ds[i].getValue()){
            return false;
         }
      }
      return true;
   }
  /**
   * A little test main to check things out
   */
   public static void main( String[] args ) {
      // You do this part!
   }

}
