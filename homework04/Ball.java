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
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
//import java.awt.Point;
// import java.awt.*;
// import java.awt.geom.Point2D;

public class Ball{
    private double radius = 4.45;
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
    public static double isXInBounds(String argOne){
        if(Double.parseDouble(argOne) < -500 || Double.parseDouble(argOne) > 500){
           throw new IllegalArgumentException("Ball is not in Bounds");
        }
        return Double.parseDouble(argOne);
    }

    public static double isYInBounds(String argTwo){
        if(Double.parseDouble(argTwo) < -500 || Double.parseDouble(argTwo) > 500){
           throw new IllegalArgumentException("Ball is not in Bounds");
        }
        return Double.parseDouble(argTwo);
    }

    public boolean atRest(){
        return this.atRest;
    }

    public boolean stillMoving(){
        return !this.atRest;
    }

    public void move(double b){  //got help from TA. Honestly dont understand this movement formula yet.
        if(!this.atRest){
            while(b >= 1.0){
                this.x += this.xVel;
                this.y += this.yVel;
                this.xVel -= 0.01 * this.xVel;
                this.yVel -= 0.01 * this.yVel;
                b -= 1.0;

            if(b > 0.0){
                this.x += this.xVel * b;
                this.y += this.yVel * b;
                this.xVel -= 0.01 * this.xVel * b;
                this.yVel -= 0.01 * this.yVel * b;
            }
            this.atRest = Math.sqrt(this.xVel * this.xVel + this.yVel * this.yVel) < 0.0833333;
            }
        }
    }

    // public String getCurrentSpeed(){
    //     return "(" + this.xVel + "," + this.yVel + ")";
    // }

    //  public static double isXInBounds(argOne){
    //     if( -500 < (Integer.parseInt(x) || Integer.parseInt(y) > 500){
    //        throw new IllegalArgumentException("Ball is not in Bounds");
    //     }
    //  }

    public String locationToString(){
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

    public String speedAfterTick(double b){ //was lcoation??
        double newX = this.x * 0.99;
        double newY = this.y * 0.99;
        return "(" + newX + "," + newY + ")";
    }




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

        // System.out.println(new Point(5,5).toString());
        // Point p = new Point(3,2);
        //     System.out.println(p.toString());
     }
}
