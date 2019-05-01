/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  DynamicChangemaker.java
 * Purpose    :  The DynamicChangeMaker class
 * @author    :  Emilia Huerta
 * Date       :  2019-04-29
 * Description:  takes as input arguments a sequence of coin denominations
 *               [distinct positive integers in no particular order],
 *               followed by an arbitrary amount of money [a non-negative integer],
 *               and which outputs the optimal way of making change for that amount
 *               using those denominations [optimal meaning the minimum number of coins],
 *               or if change cannot be made, outputs the message IMPOSSIBLE.
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:  Reason for change or modification
 *  -----  ----------  ------------  ---------------------------------------------------------------------
 *  1.0.0  2019-04-29  Emilia Huerta Began writing class
 *  1.0.1  2019-04-28  Emilia Huerta Started makeChangeWithDynamicProgramming()
 *  1.0.2  2019-05-01  Emilia Huerta Worked on validation
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */


public class DynamicChangeMaker{
  public DynamicChangeMaker(){

  }
  public void validate(String args){
    Integer intArgs = Integer.parseInt(args);
    if(intArgs.isNaN  || intArgs < 0){
      System.out.println("Conversion impossible, monetary input not valid.");
      System.exit(0);
    }
    // try{
    //   Integer.parseInt(args);
    //   System.out.println(args + " is a valid integer.");
    // }
    // catch (NumberFormatException e){
    //   System.out.println(args + " is not a valid integer.");
    // }
  }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  takes two arguments
   *  @param  array[] an integer array of denominations.
   *  @param  integer containing the target amount of cents.
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
  public void makeChangeWithDynamicProgramming(int array[], int amount){

  }
}
