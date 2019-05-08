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
 *  1.0.7  2019-05-08  Emilia Huerta Changed names of values
 *  1.0.8  2019-05-08  Emilia Huerta Fixed isValid - handles "," now
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

    // if (args.length < 2) {
    //   System.out.println("Invalid statement.");
    //   System.exit(0);
    // }
    // for (int x = 0; x < args.length; x++) {
    //   if (Integer.parseInt(args[x]) <= 0) {
    //     System.out.println("No negative amounts allowed.");
    //     System.exit(1);
    //   }
    // }
    // for (int x = 0; x < args.length; x++) {
    //   for (int y = x + 1; y < args.length - 1; y++) {
    //     if (args[x].equals(args[y])) {
    //       System.out.println("No duplicate denominations allowed.");
    //       System.exit(2);
    //     }
    //   }
    // }
    String[] strings = args[0].split(",");
    int[] denominations = new int[strings.length];

    for (int i = 0; i < denominations.length; i++) {
        denominations[i] = Integer.parseInt(strings[i]);
        if (denominations[i] <= 0) {
            System.out.println("Denominations cannot be negative.\n");
            System.exit(0);
        }

        for (int j = 0; j < i; j++) {
            if (denominations[j] == denominations[i]) {
                System.out.println("No duplicate denominations allowed.\n");
                System.exit(1);
            }
        }
        if (denominations.length < 2) {
          denominations[i] = Integer.parseInt(strings[i]);
          System.out.println("Invalid statement.");
          System.exit(3);
        }
    }

    int amount = Integer.parseInt(args[1]);
    if (amount < 0) {
        System.out.println("Change cannot be negative.\n");
        System.exit(2);
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
      table[i][0] = new Tuple(i);
    }
    for(int i = 0; i < rows; i++){
      for(int j = 1; j < columns; j++){
        if(j < array[i]){
          table[i][j] = Tuple.IMPOSSIBLE;
        } else {
          table[i][j] = new Tuple(rows);
          table[i][j].setElement(i, 1);
          if(table[i][j - array[i]].isImpossible()){
            table[i][j] = Tuple.IMPOSSIBLE;
          } else {
            table[i][j] = table[i][j].add(table[i][j - array[i]]);
          }
        }
        if(i > 0 && (table[i][j].isImpossible() || (!table[i - 1][j].isImpossible()))
          && table[i][j].total() > table[i - 1][j].total()){
            table[i][j] = table[i - 1][j];
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
