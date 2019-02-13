import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
//import java.util.Scanner;

public class HighRoll{

   public static void main( String args[] ) {
       int highRollCount = 0;
       int highRollSides = 0;
       int highScore = 0;
       try{
           highRollCount = Integer.parseInt( args[0] );
           highRollSides = Integer.parseInt( args[1] );
       }
       catch(NumberFormatException nfe){System.out.println("Bad input");}

    DiceSet highRollGameSet = new DiceSet(highRollCount, highRollSides);

    System.out.println("Welcome to HighRoll. Follow the menu to play!");
    System.out.println("[1] Roll all the dice \n [2] Roll a single die \n [3] Calculate the score for this set \n [4] Save this score as a high score \n [5] Display the high score \n [6] Enter 'Q' to quit the program");

    BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );
      //Scanner input = new Scanner(System.in); //Create a Scanner object
      //System.out.println("Enter a number 1-5:");
      //String userInput = input.nextLine(); //Reads user input
    //   if (userInput == "1"){
    //     highRollGameSet.roll();
    //         System.out.println("You rolled all the dice " + highRollGameSet.toString());

    while( true ) {
        System.out.print( ">>" ); //Referenced from MainProgLoopDemo
        String inputLine = null;
        try {
          inputLine = input.readLine();
          if( 0 == inputLine.length() ) {
            System.out.println("enter some text!: ");
          }
          System.out.println( "   You typed: " + inputLine );
          if('1' == inputLine.charAt(0)){
            highRollGameSet.roll();
            System.out.println("You rolled all the dice" + highRollGameSet.toString());
          }
          if('2' == inputLine.charAt(0)){
            System.out.println("Roll a single die \n Enter the index of the die you want to roll" );
            System.out.print( ">>" );
            int Index = Integer.parseInt(input.readLine());
            highRollGameSet.rollIndividual(Index);
            System.out.println("You rolled: " + highRollGameSet.toString());
          }
          if('3' == inputLine.charAt(0)){
            System.out.println("Your score for this set is: " + highRollGameSet.sum());
          }
          if('4' == inputLine.charAt(0)){
            highScore = highRollGameSet.sum();
            System.out.println("This score has been saved as a high score");
          }
          if('5' == inputLine.charAt(0)){
            System.out.println("Your high score is: " + highScore);
          }
          if('Q' == inputLine.charAt(0)){
            System.out.println("You have quit the program");
            break;
          }
        }
        catch( IOException ioe ) {
          System.out.println( "Caught IOException" );
        }
      }
    }
  }
