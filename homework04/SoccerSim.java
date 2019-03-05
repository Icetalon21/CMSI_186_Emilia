public class SoccerSim{
    public static void main( String args[] ) {
        // int highRollCount = 0;
        // int highRollSides = 0;
        // int highScore = 0;
        int startFirstBallX = 0;
        int startFirstBallY = 0;
        int firstBallXAxis = 0;
        int firstBallYAxis = 0;
        int startSecondBallX = 0;
        int startSecondBallY = 0;
        int secondBallXAxis = 0;
        int secondBallYAxis = 0;


        try{
            highRollCount = Integer.parseInt( args[0] );
            highRollSides = Integer.parseInt( args[1] );
        }
        catch(NumberFormatException nfe){System.out.println("Bad input");}
    }
}
