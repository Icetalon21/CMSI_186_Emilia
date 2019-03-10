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
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
//import java.awt.Point;
// import java.awt.*;
// import java.awt.geom.Point2D;

public class Ball{
    private double radius;
    private double weight;
    private double x;
    private double y;
    private double xVel;
    private double yVel;
    //private Point2D p = null;

    //public constructor
    public Ball(double x, double y, double xVel, double yVel){
        double radius = 4.45;
        double weight = 1;
        this.x = x;
        this.y = y;
        this.xVel = xVel;
        this.yVel = yVel;
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
        return x;
    }

    public double getY(){
        return y;
    }

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

    //  public static double isXInBounds(argOne){
    //     if( -500 < (Integer.parseInt(x) || Integer.parseInt(y) > 500){
    //        throw new IllegalArgumentException("Ball is not in Bounds");
    //     }
    //  }

    public String locationToString(){
        return "(" + x + "," + y + ")";
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
