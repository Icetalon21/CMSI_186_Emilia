/*Write a script that prompts the user for an integer (in the range 1 to 10,000 — you must check this)
and reports the number of steps required in the Collatz sequence to reach the value 1.
The Collatz sequence is a sequence of positive integers obeying the following rules: */

public class Collatz{
    public int n;

    public int GetCollatzSequenceSteps(int n) {
    int steps = 0;
    while (n != 1) {
        n = Math.floor((n%2==0)?n/2:3*n+1);
        steps++;
    }
    return steps;
 }
 
 let input = 0;
 while (input < 1 || input > 10000) {
    input = parseInt(prompt("Enter an integer in the range [1,10000]"));
 }
 alert(GetCollatzSequenceSteps(input));
}
