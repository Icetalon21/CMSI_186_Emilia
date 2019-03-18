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
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */



public class SoccerSim{
   private Ball[] soccerBalls = null;
   private int ballCount = 0;
   private double fieldWidth = 500.0;
   private double fieldHight = 500.0;
   private boolean stillMoving = true;
   private static Clock clock = null;
   private double timeSlice = 1.0; // for one second
   private double poleX = 50.0;
   private double poleY = 50.0;

   public SoccerSim(){

   }
   public static void main( String args[] ) {
      System.out.println( "\n   Hello world, from the SoccerSim program!!\n\n" );
      SoccerSim soccerSim = new SoccerSim();
      int ballCount = (args.length/4);
      Ball[] balls = new Ball[ballCount];
      int j = 0;
      // double last = SoccerSim.lastArg(stringArray);
      double last = 1.0;
      if (args.length % 4 == 1) {
         try{
            last = Double.parseDouble(args[args.length -1]);
         }
         catch (Exception exception){
            throw new IllegalArgumentException();
         }
      if (last <= 0.0){
         throw new IllegalArgumentException();
         }
      }
      clock = new Clock(last); // if
      //double.parse double if not use one second
      for(int i = 0; i < args.length; i +=4){
         try{
            double ballX = Double.parseDouble( args[i] );
            double ballY = Double.parseDouble( args[i+1] );
            double ballXAxis  = Double.parseDouble( args[i+2] );
            double ballYAxis  = Double.parseDouble( args[i+3] );
            balls[j] = new Ball(ballX, ballY, ballXAxis, ballYAxis);
            j++;
         }
         catch (Exception exception){
            throw new IllegalArgumentException("Please enter a valid input");
         }
      }

      do {
         soccerSim.clock.tick();
         // Clock clock = new Clock(this.timeSlice);
         // clock.tick();
         soccerSim.timeSiceUpdate();
         if(soccerSim.collision(balls) == true){
            System.out.println("A collision occurred");
            break;
         }
         if(!soccerSim.aBallMoving()){
            System.out.print("All of the balls have stopped moveing. No collsions occurred.");
         }

      } while (true);
      System.out.println("derp. End of program.");
      // Clock clock = new Clock (0, 0, 0.0, SoccerSim.timeSlice); //hours, minutes, & seconds
      // double BallX = 0;
      // double BallY = 0;
      // double BallXAxis = 0;
      // double BallYAxis = 0;

      //   try{
      //       BallX = Double.parseDouble( args[0] );
      //       BallY = Double.parseDouble( args[1] );
      //       BallXAxis  = Double.parseDouble( args[2] );
      //       BallYAxis  = Double.parseDouble( args[3] );

      //    }
      //   catch(NumberFormatException nfe){System.out.println("Bad input");}

   }
         public void handleInitialArguments(String args[]){
            if( 0 == args.length){
               System.out.println(" Sorry you must enter in at least four arguments\n");
               System.exit(0);
            }
         }

         static boolean collision(Ball[] ballArray){
            for(int i = 0; i < ballArray.length -1; ++i){
               for(int j = i +1; j < ballArray.length; ++j){
                  double ballX;
                  double ballY = (ballArray[i].getX() - ballArray[j].getX()) * 12.0;
                  if(!(ballY * ballY + (ballX = (ballArray[i].getY() - ballArray[j].getY()) * 12) * ballX < 79.21)) continue;
                  return true;
               }
            }
            return false;
         }

         static boolean notCollision(Ball[] ballArray){
            return !SoccerSim.collision(ballArray);
         }

         public boolean aBallMoving(){
            for(int i = 0; i < soccerBalls.length; ++i){ //dead code means code that is not used
               if(!soccerBalls[i].stillMoving());
                  return true;
            }
            return false;
         }

         public void timeSiceUpdate(){
            for(int i = 0; i < this.soccerBalls.length; ++i){
               this.soccerBalls[i].move(this.timeSlice);
            }
         }

         public String initialReport(){
            String string = "";
            string = string + "\n The field is " + fieldWidth + "by " + fieldHight;
            string = string + "\n The pole is located at " + poleX + "," + poleY;
            string = string + "\n The timeSlice is " + this.timeSlice;
            string = string + "\n The intial report is at 00:00:00.00";
            return string;
         }

         // static double lastArg(String[] stringArray){
         //    double last = 1.0;
         //    if (stringArray.length % 4 ==1) {
         //       try{
         //          last = Double.parseDouble(stringArray[stringArray.length -1]);
         //    }
         //       catch (Exception exception){
         //          throw new IllegalArgumentException();
         //    }
         //    if (last <= 0.0){
         //       throw new IllegalArgumentException();
         //    }
         //    }
         //    return last;
         // }


         // public int[] isTouching(){
         //    int t;
         //    int[] check = new int[2];
         //    double b = 0.0;
         //    check[0] = 100;
         //    check[1] = 100;
         //    for(t = 0; t < this.soccerBalls.length -1; ++t){
         //       for (int i = t + 1; i < this.soccerBalls.length; ++i){
         //          b = Math.sqrt(Math.pow(this.soccerBalls[t].getX()[0] - this.soccerBalls[i].getX()[0],2.0) + Math.pow(this.soccerBalls[t].getY()[1] - this.soccerBalls[i].getY()[1], 2.0));
         //          if (!( b * 12.0 <= 8.9)) continue;
         //          check[0] = t;
         //          check[1] = i;
         //          return check;
         //       }
         //    }
         // }

         // public void validateArgs(String[] args){

         //   }

      //      if( 0 != args.length % 4){
      //         this.timeSlice = this.clock.validateTimeSliceArg(args[args.length - 1]);
      //      }
      //   }
         //   double oneArg = Double.parseDouble(args[0]);
         //   if(Double.parseDouble(args[0]) > 500){
         //      System.out.println("Ball is out of bounds");
         //      System.exit(0);

         //   if(2 <= args.length){
         //      double twoArg = Double.parseDouble(args[1]);
         //   }
}
