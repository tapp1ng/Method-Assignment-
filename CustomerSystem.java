// Throughout this project, the use of data structures are not permitted such as methods like .split and .toCharArray




import java.util.Scanner;
// More packages may be imported in the space below

class CustomerSystem{
    public static void main(String[] args){
        // Please do not edit any of these variables
        Scanner reader = new Scanner(System.in);
        String userInput, enterCustomerOption, generateCustomerOption, exitCondition;
        enterCustomerOption = "1";
        generateCustomerOption = "2";
        exitCondition = "9";

        // More variables for the main may be declared in the space below


        do{
            printMenu();                                    // Printing out the main menu
            userInput = reader.nextLine();                  // User selection from the menu

            if (userInput.equals(enterCustomerOption)){
                // Only the line below may be editted based on the parameter list and how you design the method return
          // Any necessary variables may be added to this if section, but nowhere else in the code
              
              
              String creditCard = reader.nextLine();
              validateCreditCard(creditCard);
              
                enterCustomerInfo();
            }
            else if (userInput.equals(generateCustomerOption)) {
                // Only the line below may be editted based on the parameter list and how you design the method return
                generateCustomerDataFile();
            }
            else{
                System.out.println("Please type in a valid option (A number from 1-9)");
            }

        } while (!userInput.equals(exitCondition));         // Exits once the user types 
        
        reader.close();
        System.out.println("Program Terminated");
    }
    public static void printMenu(){
        System.out.println("Customer and Sales System\n"
        .concat("1. Enter Customer Information\n")
        .concat("2. Generate Customer data file\n")
        .concat("3. Report on total Sales (Not done in this part)\n")
        .concat("4. Check for fraud in sales data (Not done in this part)\n")
        .concat("9. Quit\n")
        .concat("Enter menu option (1-9)\n")
        );
    }
    /*
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    public static void enterCustomerInfo() {
    }
    /*
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    public static void validatePostalCode(){
    }
    /*
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    public static boolean validateCreditCard(String creditCard){
    
    
      //Variables 
      boolean valid = false;
      int charCount = 0;
      String reverseCC = " ";
      char creditCardChar = ' ';
      char reverseDigit = ' ';
      int reverseDigitNum = 0;
      int oddSum = 0;
      int evenProduct = 0;
      int sumEvenDouble = 0;
      char evenDigit = ' ';
      int evenDigitDouble = 0;
      int evenDigitNum1 = 0;
      int evenSum = 0;
      int totalSum = 0;
      int charCount2 = 0;
      int evenDigitNum2 = 0;
      int reverseDigitCounter = 0;
      String noSpaceCC = " ";
      //counting characters of the credit card
      noSpaceCC = creditCard.replaceAll("\\s","");
      charCount = noSpaceCC.length();
      if(charCount < 9) {
        System.out.println("Invalid");
        valid = false;
      }
    
      
      
      //reversing the characters of the credit card
      //the for loop starts printing the string at the last character and loops to print the rest of the string
      for (int i  = charCount - 1; i >= 0; i--) { 
        creditCardChar = noSpaceCC.charAt(i);  
        reverseCC = reverseCC + creditCardChar;
       
      }
      
      //counting the characters of the reverse credit card
      charCount = reverseCC.length();
      
      //finding the odd and even digits in the string
      for (int i = 1; i < charCount; i++) {
        reverseDigit = reverseCC.charAt(i);
        reverseDigitCounter = reverseDigitCounter + 1;
        //coverting the characters to integers
        reverseDigitNum = reverseDigit - '0';
        
        //adding all the odd digits together
        if (reverseDigitCounter%2 != 0) {
          oddSum = reverseDigitNum + oddSum;
          
          
        }
        
        //doubling the even digits
        else if (reverseDigitCounter%2 == 0) {
          evenProduct = reverseDigitNum*2;
          if (evenProduct > 9 ) {
            //converting the integer to a string
            charCount2 = String.valueOf(evenProduct).length() - 1;
            for (int j = 0; j <= charCount2; j++) {
              evenDigit = String.valueOf(evenProduct).charAt(j);
              //coverting the characters to integers
              evenDigitNum1 = evenDigit - '0';
              sumEvenDouble = sumEvenDouble + evenDigitNum1;
            }
          }
        //if the number is not a double digit number
          else if (evenProduct <= 9) {
            evenDigitNum2 = evenDigitNum2 + evenProduct;
            
          }
        }
      }
      //adding the total even sum

      evenSum = evenDigitNum2 + sumEvenDouble;
      System.out.println(oddSum);
      //adding the total sum
      totalSum = oddSum + evenSum;
      System.out.println(totalSum);
      //determining if the credit card is valid or not
      if (totalSum%10 != 0) {
        System.out.println("Sorry, this card is invalid");
        valid = false;
      }
      else if (totalSum%10 == 0) {
        System.out.println("Accepted");
        valid = true;
      }
      
      else if(charCount < 9) {
        System.out.println("Sorry, this card is invalid");
        valid = false;
      }
      return valid;
        
    }
    
    /*
     * Description: Uses an algorithm to determine whether this credit card number is valid or not 
     * Author: Vincent Nguyen
     * @param creditCard - the user's inputted credit card number
     * @return valid - decides whether the card is valid or not
     * 
     */
    
    public static void generateCustomerDataFile(){
    }
    /*******************************************************************
    *       ADDITIONAL METHODS MAY BE ADDED BELOW IF NECESSARY         *
    *******************************************************************/
}
