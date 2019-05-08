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
  public void makeChangeWithDynamicProgramming(int array[], int amount){
    int rows = array.length;
    int colums = amount + 1;
    int denominations;
    Tuple[][] table = new Tuple [rows][colums];

    for(int i = 0; i < rows; i++){
      denominations = array[i];
      for(int j = 0; j < colums; j++){
        //special case for colum zero for all rows
        if(j == 0){
          if((j < denominations) || j % denominations !=0){
            table[i][j] = Tuple.IMPOSSIBLE;
          }

        } else { //otherwise, this is NOT colum zero
          //check if we CAN take ONE thing out of the current value;
          //if we CAN'T take one of the demoninations out of the value "j"
          //impossible, at leat temporarily
          if(/*some check to see if er can take ONE thing out of the current value */){
            //look backaward to see if there is a valid/impossible solution
            //if there is, copu it over and add/replace the one that is there
            if(/*some check to see if we are ABLE to loook backwards */){
              //if the cell looking backwards is NOT an "IMPOSSIBLE", add it
            }
            //if this is NOT row zero we need to look aboce to see if there is
            //a better non-impossible solution; if so, copy it down
            if(i != 0){
              //if the cell above is impossible, basically do nothing since
              //this the current cell is already IMPOSSIBLE

              //else if the cell above has a total that is less than the current
              //cell, copy it down
            }
          }
          //ELSE -- we *CAN* take one current denomination out
        } else {
          //make a new tuple with a one in the current demonination index

          //look backward to see if there is a valid/impossible solution
          if((j - denominations[i]) >= 0){
            //if it's IMPOSSIBLE, mark the current cell IMPOSSIBLE, too

            //else, add the previous cell to the current cell
          }
          //if this is NOT row zero we need to look above to see if there is
          //a better non-impossible solutionl if so, copy it down
          if(i != 0) {
            //if the cell aboce is impossible, basically so nothing since
            //this the current cell is already IMPOSSIBLE

            //else if the cell above has a total that is less than the current
            //cell, copy it down
          }
        }
        }
      }
    }
  }
  public static void main (String [] args) {
    DynamicChangeMaker dynamicChangeMaker = new DynamicChangeMaker();
    dynamicChangeMaker.isValid(args);
  }
}
