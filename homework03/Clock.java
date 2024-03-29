/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Clock.java
 *  Purpose       :  Provides a class defining methods for the ClockSolver class
 *  @author       :  B.J. Johnson
 *  Date written  :  2017-02-28
 *  Description   :  This class provides a bunch of methods which may be useful for the ClockSolver class
 *                   for Homework 4, part 1.  Includes the following:
 *
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-28  B.J. Johnson  Initial writing and release
 *  @version 2.0.0  2019-02-13  Emilia Huerta Copied from the repo
 *  @version 2.0.1  2019-02-16  Emilia Huerta Attempted tick() & realized that minutes may not ne used
 *  @version 2.0.2  2019-02-18  Emilia Huerta Worked on getting the angles for minutes and hours
 *  @version 2.0.3  2019-02-20  Emilia Huerta Valitated timeSlice
 *  @version 2.0.4  2019-02-25  Emilia Huerta Changed location of timeSlice
 *  @version 2.0.5  2019-02-26  Emilia Huerta Major rework to the toString method
 *  @version 2.0.6  2019-02-27  Emilia Huerta 03:00:00 was not printing - fixed
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class Clock {
  /**
   *  Class field definintions go here
   */
   //private static final double DEFAULT_TIME_SLICE_IN_SECONDS = 60.0;
   //private static final double INVALID_ARGUMENT_VALUE = -1.0;
   //private static final double MAXIMUM_DEGREE_VALUE = 360.0;
   private static final double HOUR_HAND_DEGREES_PER_SECOND = 0.00834;
   private static final double MINUTE_HAND_DEGREES_PER_SECOND = 0.1;
   private double hours;
   private double minutes;
   private double seconds;
   private double timeSlice;
  /**
   *  Constructor goes here
   */
   public Clock(double timeSlice) {
      this.timeSlice = timeSlice;
      this.hours = 0.0;
      this.minutes = 0.0;
      this.seconds = 0.0;
   }

  /**
   *  Methods go here
   *
   *  Method to calculate the next tick from the time increment
   *  @return double-precision value of the current clock tick
   */
     public Double tick(){
        this.seconds = this.seconds + timeSlice;
        getHourHandAngle();
        getMinuteHandAngle();
        getHandAngle();
        return this.seconds;
   }

  /**
   *  Method to validate the angle argument
   *  @param   argValue  String from the main programs args[0] input
   *  @return  double-precision value of the argument
   *  @throws  NumberFormatException
   */
   public static double validateAngleArg( String argValue ) throws NumberFormatException {
      if(Double.isNaN(Integer.parseInt(argValue))){
         throw new NumberFormatException();
      }
      return Double.parseDouble(argValue);
   }

  /**
   *  Method to validate the optional time slice argument
   *  @param  argValue  String from the main programs args[1] input
   *  @return double-precision value of the argument or -1.0 if invalid
   *  note: if the main program determines there IS no optional argument supplied,
   *         I have elected to have it substitute the string "60.0" and call this
   *         method anyhow.  That makes the main program code more uniform, but
   *         this is a DESIGN DECISION, not a requirement!
   *  note: remember that the time slice, if it is small will cause the simulation
   *         to take a VERY LONG TIME to complete!
   */
   public static double validateTimeSliceArg( String argValue ) {
      //return 0.0;
      if (Integer.parseInt(argValue) < 0 || Integer.parseInt(argValue) > 1800){
         throw new IllegalArgumentException();
      }
      return Double.parseDouble(argValue);
   }

  /**
   *  Method to calculate and return the current position of the hour hand
   *  @return double-precision value of the hour hand location
   */
   public double getHourHandAngle() {
      double hourAngle = (this.getTotalSeconds() * HOUR_HAND_DEGREES_PER_SECOND);
      return hourAngle;
   }

  /**
   *  Method to calculate and return the current position of the minute hand
   *  @return double-precision value of the minute hand location
   */
   public double getMinuteHandAngle() {
      double minuteAngle = (this.getTotalSeconds() * MINUTE_HAND_DEGREES_PER_SECOND);
      // minuteAngle = minuteAngle % 360;
      while(minuteAngle >= 360){
         minuteAngle -= 360;
      }
      return minuteAngle;
   }

  /**
   *  Method to calculate and return the angle between the hands
   *  @return double-precision value of the angle between the two hands
   */
   public double getHandAngle() {
      double handAngle = Math.abs(this.getHourHandAngle() - this.getMinuteHandAngle());
      return handAngle;
   }

  /**
   *  Method to fetch the total number of seconds
   *   we can use this to tell when 12 hours have elapsed
   *  @return double-precision value the total seconds private variable
   */
   public double getTotalSeconds() {
      return this.seconds;
   }

  /**
   *  Method to return a String representation of this clock
   *  @return String value of the current clock
   */
   public String toString() {
      int currSeconds = (int) this.seconds;
      int newHours = (int) Math.floor(currSeconds / 3600);
      currSeconds = currSeconds % 3600;
      int newMinutes = (int) Math.floor(currSeconds / 60);
      currSeconds = currSeconds % 60;

      String hoursInt = Integer.toString(newHours);
      String minutesInt = Integer.toString(newMinutes);
      String secondsInt = Integer.toString(currSeconds);

      if (newHours < 10) {
         hoursInt = "0" + hoursInt;
     } else if (newHours == 0) {
         hoursInt = "12";
     }

     if (newMinutes < 10) {
         minutesInt = "0" + minutesInt;
     }

     if (currSeconds < 10) {
         secondsInt = "0" + secondsInt;
     }

   String clockString = hoursInt + ":" + minutesInt + ":" + secondsInt;
      return clockString;

   }

  /**
   *  The main program starts here
   *  remember the constraints from the project description
   *  @see  http://bjohnson.lmu.build/cmsi186web/homework04.html
   *  be sure to make LOTS of tests!!
   *  remember you are trying to BREAK your code, not just prove it works!
   */
   public static void main( String args[] ) {

      System.out.println( "\nCLOCK CLASS TESTER PROGRAM\n" +
                          "--------------------------\n" );
      System.out.println( "  Creating a new clock: " );
      Clock clock = new Clock(60.0);
      System.out.println( "    New clock created: " + clock.toString() );
      System.out.println( "    Testing validateAngleArg()....");
      System.out.print( "      sending '  0 degrees', expecting double value   0.0" );
      try { System.out.println( (0.0 == clock.validateAngleArg( "0.0" )) ? " - got 0.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
   }
}
