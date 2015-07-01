package moravian.edu;

import java.util.Random;


/*
 * I must ensure that get
 * 
 */
public class MathProblem {
 int answer;
 String equation;
 
 /**
  * Constructor creates the math problem
  * List variables in java doc?
  */
 public MathProblem() {
  Random rand = new Random();
     int amtOfNums = rand.nextInt(3) + 3; // will generate numbers between 3 and 5
     int numbers[] = new int[amtOfNums]; // numbers of the math problem
     int sign[] = new int[amtOfNums - 1]; // signs of the math problem
     String signString[] = new String[amtOfNums - 1];
     int total = 0;

     /*
      * Regenerates the numbers randomly between 0 and 500
      */
     for (int i = 0; i < numbers.length;i++) {
       numbers[i] = rand.nextInt(501); 
     }
     
     /*
      * Regenerates the signs randomly where: 
      * if 0 is generated, sign is ADD
      * if 1 is generated, sign is SUBTRACT
      * if 2 is generated, sign is MULTIPLY
      * 
      */
     for (int j = 0; j < sign.length; j++) { 
         sign[j] = rand.nextInt(2);
         if (sign[j] == 0) {
           signString[j] = "+";
         } else {
           signString[j] = "-";
         }
     }
     
     /*
      * Not Flexible?
      * Too many if's
      * Is there a less intuitive way of doing this and create a way that is more algorithm-like?
      */ 
     
     total = numbers[0]; // the total takes on the initial number in the array
     
     for (int x = 0; x < sign.length; x++) {
       if (sign[x] == 0) {   // ADD
          total += numbers[x+1];
       } else if (sign[x] == 1) { // SUBTRACT
         total -= numbers[x+1];
       } 
     }
     /*
     for (int x = 0; x < numbers.length;x++) {
       System.out.println("num: " + numbers[x]);
     }
     for (int x = 0; x < sign.length;x++) {
       System.out.println("sign: " + sign[x]);
     }
     System.out.println("total: " +total);
     */
     answer = total;
     equation = equationToString(sign,numbers,signString);
  
 }
 
 /**
     * Prepare String builder
     * 
     * Can make this into equation_maker()
     * 
     * Spots are set like:
     * [1][+][7][-][12]
     * where every even spot is a number and
     * every odd spot is a sign
     * 
     * 
     * @return the equation which is string, with spaces for the user to read easier 
     */
 
 private String equationToString(int sign[], int numbers[], String signStr[]) {
     StringBuilder sb = new StringBuilder();
  
     int signCount = 0;
     int numbersCount = 0;
     
     for (int x = 0; x < (sign.length + numbers.length); x++) {
      if (x % 2 == 0) { // if the spot is even...
       sb.append(numbers[numbersCount] + " ");  
       numbersCount++;
      } else { // if the spot is odd...
       sb.append(signStr[signCount] + " ");
       signCount++;
      }
     }
     return sb.toString();
  
 }
 
 /**
  * Get the answer of the question
  * 
  * @return answer int
  */
 public int getAnswer() { 
  return answer;
 }
 
 /**
  * Get the equation of the problem in string representation
  * 
  * @return equation a string
  */
 public String getEquation() {
  return equation;
  
 }
}
