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
 *  @version 1.0.2  2019-03-12  Emilia Huerta Added an array for the soccerballs
 *  @version 1.0.3  2019-03-17  Emilia Huerta Wrote booleans for if a collsion/not
 *  @version 1.0.4  2019-03-18  Emilia Huerta Wrote tick(), timeSliceUpdate(), and fixed Clock
 *  @version 1.0.5  2019-03-19  Emilia Huerta Created getBalls() method & fixed main
 *  @version 1.0.6  2019-03-19  Emilia Huerta Cleaned up code
 *  @version 1.0.7  2019-03-19  Emilia Huerta Fixed timeSlice
 *  @version 1.0.8  2019-03-19  Emilia Huerta Cleaned up code again
 *  @version 1.0.9  2019-03-19  Emilia Huerta Deleted unecessary prints
 *  @version 1.1.0  2019-03-19  Emilia Huerta Added maxLength which fixed timeSlice
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */



public class SoccerSim{
   private Ball[] soccerBalls;
   private int ballCount;
   private double fieldWidth = 500.0;
   private double fieldHight = 500.0;
   private boolean stillMoving = true;
   private static Clock clock = null;
   private double timeSlice = 1.0; // for one second
   private double poleX = 50.0;
   private double poleY = 50.0;
   private double x;
   private double y;
   private double xVel;
   private double yVel;
   private boolean initialReport = true;
   private int maxLength = 0;

   public SoccerSim(double x, double y, double xVel, double yVel, int ballCount, double timeSlice){ //hey this is your construcotr
      this.ballCount = ballCount;
      // System.out.println(ballCount);
      this.soccerBalls = new Ball [ this.ballCount ];
      // System.out.println(this.ballCount);
      for (int i = 0; i < ballCount; i ++){
         soccerBalls[i] = new Ball(x, y, xVel, yVel);
   }
   this.x = x;
   this.y = y;
   this.xVel = xVel;
   this.yVel = yVel;
   this.timeSlice = timeSlice;
}

   public void handleInitialArguments(String args[]){
      if( 4 > args.length){
         System.out.println(" Sorry you must enter in at least four arguments\n");
         System.exit(0);
      }
      if( 1 < args.length % 4){
         throw new IllegalArgumentException();
      }
   }

   public void validateTimeSlice(){
      if(this.timeSlice < 0.001){
         System.out.print("TimeSlice is too small. Ending program");
         System.exit(3);
      }
      if(this.timeSlice > 1800){
         System.out.print("TimeSlice is too large. Ending program");
         System.exit(4);
      }
   }

   static boolean collision(Ball[] ballArray){
      for(int i = 0; i < ballArray.length -1; i++){
         for(int j = i +1; j < ballArray.length; j++){
            if(ballArray[i].hasCollided(ballArray[j])){
               return true;
            }
         }
      }
      return false;
   }

   static boolean notCollision(Ball[] ballArray){
      return !SoccerSim.collision(ballArray);
   }

   static boolean aBallMoving(Ball[] ballArray){
      for(int i = 0; i < ballArray.length; ++i){
         if(ballArray[i].stillMoving()) {
            return true;
         }
      }
      return false;
   }

   public void timeSliceUpdate(Ball[] balls){
      for(Ball ball: balls) {
         ball.move(this.timeSlice);
      }
   }

   public void report(){
      String string = "";
      if(this.initialReport){
         this.initialReport = false;
         string = string + "\n The field is " + fieldWidth + " by " + fieldHight;
         string = string + "\n The pole is located at " + poleX + "," + poleY;
         string = string + "\n The timeSlice is " + this.timeSlice;
         string = string + "\n The intial report is at 00:00:00.00";
         string = string + (this.timeSlice > 1.0 ? "s" : "");
         for (int i = 0; i < this.soccerBalls.length; ++i){
            string = string + "\n Ball" + i + ":\t" + this.soccerBalls[i].toString();
         }
      }else{
         string = string + "\n Reporting at " + this.clock.toString();
         // System.out.print(this.soccerBalls.length);
         for (int i = 0; i < this.soccerBalls.length; ++i){
            System.out.println(this.soccerBalls[i].isInBounds());
            string = string + "\n Ball" + i + ":\t" + this.soccerBalls[i].toString();
         }
      }
      System.out.println(string);
   }

   public Ball[] getBalls(){
      return this.soccerBalls;
   }

   public static void main( String args[] ) {
      System.out.println( "\n   Hello world, from the SoccerSim program!!\n\n" );
      SoccerSim soccerSim = new SoccerSim(0.0, 0.0, 0.0, 0.0, args.length/4, 1); //initial dec of soccerSim
      try{
         soccerSim.handleInitialArguments(args);
      }
      catch(NumberFormatException numberFormatException){
         System.out.println("Please enter in 4 args");
         System.exit(1);
      }
      catch(IllegalArgumentException illegalArgumentException){
         System.out.println("Please enter in valid arguments");
         System.exit(2);
      }
      int j = 0;
      double last = soccerSim.timeSlice;
      soccerSim.maxLength = args.length;
      if (args.length % 4 == 1) { // 9 % 4  = 1
         try{
            last = Double.parseDouble(args[args.length -1]);
            soccerSim.timeSlice = last;
            soccerSim.validateTimeSlice();
            soccerSim.maxLength = args.length -1;
         }
         catch (Exception exception){
            throw new IllegalArgumentException();
         }
      }
      clock = new Clock(last);
      for(int i = 0; i < soccerSim.maxLength; i +=4){
         try{
            double ballX = Double.parseDouble( args[i] );
            double ballY = Double.parseDouble( args[i+1] );
            double ballXAxis  = Double.parseDouble( args[i+2] );
            double ballYAxis  = Double.parseDouble( args[i+3] );
            soccerSim.getBalls()[j] = new Ball(ballX, ballY, ballXAxis, ballYAxis);
            j++;
         }
         catch (Exception exception){
            throw new IllegalArgumentException("Please enter a valid input");
         }
      }

      do {
         soccerSim.report();
         clock.tick();
         soccerSim.timeSliceUpdate(soccerSim.getBalls());
         soccerSim.report();
         if(soccerSim.collision(soccerSim.getBalls())){
            System.out.println("A collision occurred");
            break;
         }
         if(!soccerSim.aBallMoving(soccerSim.getBalls())){
            System.out.print("All of the balls have stopped moveing. No collsions occurred.");
            break;
         }
         for(Ball ball: soccerSim.getBalls()){
            if(!ball.isInBounds()){
               System.out.println("Your ball is out of bounds :(");
               // return;
               System.exit(0);
            }
         }

      } while (true);
   }
}
