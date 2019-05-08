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
 *  1.0.2  2019-05-01  Emilia Huerta Worked on validation()
 *  1.0.3  2019-05-07  Emilia Huerta Finished isValid() & started main()
 *  1.0.4  2019-05-08  Emilia Huerta Worked on makeChangeWithDynamicProgramming()
 *  1.0.5  2019-05-08  Emilia Huerta Added pseudocode
 *  1.0.6  2019-05-08  Emilia Huerta Cont. makeChangeWithDynamicProgramming()
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */


public class DynamicChangeMaker{
  public DynamicChangeMaker(){

  }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to validate that all the characters in the value are valid demoninations
   *  @param args[] The deminations and amount
   *  Checks if there are negative or duplicate demonications
   *  Exits the program if not valid
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
  public void isValid(String args[]){
    if (args.length < 2) {
      System.out.println("Invalid statement.");
      System.exit(0);
    }
    for (int x = 0; x < args.length; x++) {
      if (Integer.parseInt(args[x]) <= 0) {
        System.out.println("No negative amounts allowed.");
        System.exit(1);
      }
    }
    for (int x = 0; x < args.length; x++) {
      for (int y = x + 1; y < args.length - 1; y++) {
        if (args[x].equals(args[y])) {
          System.out.println("No duplicate denominations allowed.");
          System.exit(2);
        }
      }
    }
  }
  //   Integer intArgs = Integer.parseInt(args);
  //   if(intArgs.isNaN  || intArgs < 0){
  //     System.out.println("Conversion impossible, monetary input not valid.");
  //     System.exit(0);
  //   }
    // try{
    //   Integer.parseInt(args);
    //   System.out.println(args + " is a valid integer.");
    // }
    // catch (NumberFormatException e){
    //   System.out.println(args + " is not a valid integer.");
    // }
  // }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  takes two arguments
   *  @param  array[] an integer array of denominations.
   *  @param  integer containing the target amount of cents.
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
  public static Tuple makeChangeWithDynamicProgramming(int array[], int amount){
    int rows = array.length;
    int columns = amount + 1;
    int denominations;
    Tuple[][] table = new Tuple [rows][columns];

    for (int i = 0; i < rows; i++){
      table[i][0] = new Tuple(rows);
    }
    for(int i = 0; i < rows; i++){
      for(int j = 0; j < columns; j++){
        if(j < array[i]){
          table[rows][columns] = Tuple.IMPOSSIBLE;
        } else {
          table[rows][columns] = new Tuple(rows);
          table[rows][columns].setElement(rows, 1);
          if(table[rows][columns - array[rows]].isImpossible()){
            table[rows][columns] = Tuple.IMPOSSIBLE;
          } else {
            table[rows][columns] = table[rows][columns].add(table[rows][columns - array[rows]]);
          }
        }
        if(rows > 0 && (table[rows][columns].isImpossible() || (!table[rows - 1][columns].isImpossible()))
          && table[rows][columns].total() > table[rows - 1][columns].total()){
            table[rows][columns] = table[rows - 1][columns];
          }
      }
    }
    return table[rows - 1][amount];
  }
  public static void main (String [] args) {
    DynamicChangeMaker dynamicChangeMaker = new DynamicChangeMaker();
    dynamicChangeMaker.isValid(args);
  }
}
