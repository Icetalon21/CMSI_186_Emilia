/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  SoccerSim.java
 *  Purpose       :  Provides a class describing the soccer field.
 *  @author       :  Emilia Huerta
 *  Date          :  2019-03-05
 *  Description   :  N/A
 *
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None Yet
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2019-03-05  Emilia Huerta Created main
 *  @version 1.0.1  2019-03-06  Emilia Huerta Added documentation
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */



public class SoccerSim{
    public static void main( String args[] ) {
        double startFirstBallX = 0;
        double startFirstBallY = 0;
        double firstBallXAxis = 0;
        double firstBallYAxis = 0;
        double startSecondBallX = 0;
        double startSecondBallY = 0;
        double secondBallXAxis = 0;
        double secondBallYAxis = 0;


        try{
            startFirstBallX = Double.parseDouble( args[0] );
            startFirstBallY = Double.parseDouble( args[1] );
            firstBallXAxis  = Double.parseDouble( args[2] );
            firstBallYAxis  = Double.parseDouble( args[3] );
            startSecondBallX = Double.parseDouble(args[4] );
            startSecondBallY = Double.parseDouble(args[5] );
            secondBallXAxis  = Double.parseDouble(args[6] );
            secondBallYAxis  = Double.parseDouble(args[7] );
        }
        catch(NumberFormatException nfe){System.out.println("Bad input");}
    }
}
