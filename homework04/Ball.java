/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Ball.java
 *  Purpose       :  Provides a class describing a single soccer ball.
 *  @author       :  Emilia Huerta
 *  Date          :  2019-03-05
 *  Description   :  This class provides the data fields and methods to describe a single ball.
 *
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None Yet
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2019-03-05  Emilia Huerta Created basic constructor
 *  @version 1.0.1  2019-03-06  Emilia Huerta Tried Point and Point2D - failed
 *  @version 1.0.2  2019-03-10  Emilia Huerta Wrote methods to validate x & y
 *  @version 1.0.3  2019-03-12  Emilia Huerta Wrote method to return current speed of the ball
 *  @version 1.0.4  2019-03-14  Emilia Huerta Tested the location return strings - worked
 *  @version 1.0.5  2019-03-15  Emilia Huerta Tried to incorporate friction for speed after tick - failed
 *  @version 1.0.6  2019-03-17  Emilia Huerta Wrote methods to see if ball is still moving/at rest
 *  @version 1.0.7  2019-03-18  Emilia Huerta Added a hasCollided method
 *  @version 1.0.8  2019-03-19  Emilia Huerta Added an isInBounds method
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
//import java.awt.Point;
// import java.awt.*;
// import java.awt.geom.Point2D;

public class Ball{
    private double radius = 4.45; // radius * 2 = 8.9
    private double weight = 1.0;
    private double x;
    private double y;
    private double xVel;
    private double yVel;
    private boolean atRest;
    //private Point2D p = null;

    //public constructor
    public Ball(double x, double y, double xVel, double yVel){
        // double radius = 4.45;
        // double weight = 1.0;
        this.x = x;
        this.y = y;
        this.xVel = xVel;
        this.yVel = yVel;
        this.atRest = Math.sqrt(this.xVel * this.xVel + this.yVel * this.yVel) < 0.0833333;
        //0.0833333 is one inch of a foot
        //https://msu.edu/~tuckeys1/highschool/physics/p_equations.htm referenced for formula
        //This equation relates the lengths of the vector and its components.
        //It is taken directly from the Pythagorean theorem.
    }
    /**
    *  Method to validate the angle argument
    @param   argValue  String from the main programs args[0] input
    @return  double-precision value of the argument
    @throws  NumberFormatException
   */


//    public boolean validateArg( double[] argValue ){
//     for( double i : argValue){
//         if(Double.isNaN(argValue)){
//             return true;
//         }
//     }
//     return false;
// }


    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public double getXVelocity(){
        return this.xVel;
    }

    public double getYVelocity(){
        return this.yVel;
    }

    /**
    *  Method to validate the X argument
    @param   argOne String from the main programs args[0] input
    @return  double-precision value of the argument
    @throws  IllegalArgumentException
   */
    // public static double isXInBounds(String argOne){
    //     if(Double.parseDouble(argOne) < -500 || Double.parseDouble(argOne) > 500){
    //        throw new IllegalArgumentException("Ball is not in Bounds");
    //     }
    //     return Double.parseDouble(argOne);
    // }

    // public static double isYInBounds(String argTwo){
    //     if(Double.parseDouble(argTwo) < -500 || Double.parseDouble(argTwo) > 500){
    //        throw new IllegalArgumentException("Ball is not in Bounds");
    //     }
    //     return Double.parseDouble(argTwo);
    // }

    public boolean isInBounds(){
        if(this.x < -250 || this.x > 250){
            return false;
        }
        if(this.y < -250 || this.y > 250){
            return false;
        }
        return true;
    }

    public boolean atRest(){
        return this.atRest;
    }

    public boolean stillMoving(){
        return !this.atRest;
    }

    public void move(double timeSlice){  //got help from TA.
        if(!this.atRest){
            while(timeSlice >= 1.0){
                this.x += this.xVel;
                this.y += this.yVel;
                this.xVel -= 0.01 * this.xVel; //Subtracting 0.01 from the velocity
                this.yVel -= 0.01 * this.yVel; //Due to friction
                timeSlice -= 1.0;
            }
                if(timeSlice > 0.0){
                    this.x += this.xVel * timeSlice;
                    this.y += this.yVel * timeSlice;
                    this.xVel -= 0.01 * this.xVel * timeSlice;
                    this.yVel -= 0.01 * this.yVel * timeSlice;
                    System.out.println(this.xVel);
                    System.out.println(this.atRest);
                }
                this.atRest = Math.sqrt(this.xVel * this.xVel + this.yVel * this.yVel) < 0.0833333;
            }
        }


    public boolean hasCollided(Ball b){
        // System.out.print(b.x)
        if(Math.hypot(Math.abs(b.getX() - this.x), Math.abs(b.getY() - this.y)) < 8.9){
            return true;
        }
        return false;
    }

    // public String getCurrentSpeed(){
    //     return "(" + this.xVel + "," + this.yVel + ")";
    // }

    //  public static double isXInBounds(argOne){
    //     if( -500 < (Integer.parseInt(x) || Integer.parseInt(y) > 500){
    //        throw new IllegalArgumentException("Ball is not in Bounds");
    //     }
    //  }

    public String toString(){
        if(this.atRest){
            return "Ball is located at (" + this.x + "," + this.y + ")";
        }
        return "Ball is located at ("+ this.x + "," + this.y + ") at a velocity of (" + this.xVel + "," + this.yVel + ") feet per second";
    }

    //https://stackoverflow.com/questions/15990209/game-physics-friction
    // public double getXSpeedAfterTick(){
    //     double newX = 0.99 * this.xVel;
    //     return newX;
    // }

    // public double getYSpeedAfterTick(){
    //     double newY = 0.99 * this.yVel;
    //     return newY;
    // }

    // public String speedAfterTick(double b){ //was lcoation??
    //     double newX = this.x * 0.99;
    //     double newY = this.y * 0.99;
    //     return "(" + newX + "," + newY + ")";
    // }




    // public double getLocation(){
    //     return (this.x, this.y);
    //     //return new Point(x,y);
    // }
    // public Point2D pointTest(){
    //     Point2D.Double pointDouble = new Point2D.Double(this.p.x, this.p.y);
    //     System.out.println(pointDouble);
    // }

    // public String toString(){
    //     String ballString = "(" + this.p.x + "," + this.p.y + ")";
    //     return ballString;
    // }

    public static void main( String[] args ) {
        System.out.println( "Hello world from the Ball class..." );
        Ball ball1 = new Ball(10.0, 50.0, 6.0, 2.0);
        Ball ball2 = new Ball(2.0, 6.0, 3.0, 7.0);
        Ball ball3 = new Ball(30.0, 70.0, 0.0, 0.0);
        Ball ball4 = new Ball(4.0, 7.0, 3.0, 2.0);
        System.out.println("Ball ball1: " + ball1.toString());
        // System.out.println("Ball b1: " + ball1.getCurrentSpeed());
        System.out.println("Ball ball2: " + ball2.toString());
        // System.out.println("Ball b2: " + ball2.getCurrentSpeed());
        System.out.println("Ball ball3: " + ball3.toString());
        // System.out.println("Ball b3: " + ball3.getCurrentSpeed());
        System.out.println("Ball ball4: " + ball4.toString());
        // System.out.println("Ball b4: " + ball4.getCurrentSpeed());
        System.out.println();
        ball1.move(1.0);
        ball2.move(1.0);
        ball3.move(0.0);
        ball4.move(2.0);
        // ball2.speedAfterTick(0.1);
        // ball3.speedAfterTick(0.1);
        // ball4.speedAfterTick(0.1);
        System.out.println("Ball ball1: " + ball1.toString());
        System.out.println("Ball ball2: " + ball2.toString());
        System.out.println("Ball ball3: " + ball3.toString());
        System.out.println("Ball ball4: " + ball4.toString());
        // System.out.println("Ball b2: " + ball2.locationToString());
        // System.out.println("Ball b3: " + ball3.toString());
        // System.out.println("Ball b4: " + ball4.toString());
        System.out.println(ball1.atRest());
        System.out.println(ball2.atRest());
        System.out.println(ball3.atRest());
        System.out.println(ball4.atRest());
        // System.out.println(new Point(5,5).toString());
        // Point p = new Point(3,2);
        //     System.out.println(p.toString());
     }
}
