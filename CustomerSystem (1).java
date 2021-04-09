// Throughout this project, the use of data structures are not permitted such as methods like .split and .toCharArray




import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;

// More packages may be imported in the space below

class CustomerSystem2{
    public static void main(String[] args) throws IOException{
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
                enterCustomerInfo();
                String postalCode = reader.nextLine();
                validatePostalCode(postalCode);
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
        Scanner reader = new Scanner(System.in);
          System.out.println("Please enter the following information");

      System.out.println("First Name");
      String firstname = reader.nextLine();

      System.out.println("Last Name");
      String lastname = reader.nextLine();

      System.out.println("City");
      String city = reader.nextLine();

      System.out.println("Postal Code");
      String postalCode = reader.nextLine();
      int pcum = postalcode.length();
      while (pcum < 3) 

      boolean validity = validatePostalCode(String postalCode); //checks if postal code is valid or not
      while (validity == false) {
        System.out.println("Postal Code is invalid");
        System.out.println("Please retype you postal code")//asks customer to retype postal code if invalid
      postalCode = reader.nextLine();
      validity = validatePostalCode(String postalCode); //
      }
      System.out.println("Credit Card number");
      String creditcard = reader.nextLine(); //enters credit card numbers 

      int ccum = creditcard lenght();
      while (ccum < 9) {
          System.out.println("Invalid Credit Card numbers");
          System.out.println("Please renter Credit Card Numbers");
      creditcard = reader.nextLine();
      ccum = creditcard.length();  
      }

      }
    
    /*
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    public static boolean validatePostalCode(String postalCode) throws IOException{ 
      
      boolean valid = false;
      
      System.out.println("Please input your postal code.");
      Scanner input = new Scanner(System.in);
      String postal = input.nextLine();
      
      postalCode = postal.substring(0,3);
      String fileName = "postal_codes.csv"; //targets the file for opening
      BufferedReader reader = new BufferedReader(new FileReader(fileName));

      String lineNum = reader.readLine();
     
      //while loop to allow for reading the file continously 
      
      while (lineNum != null) {
        if (lineNum.contains(postalCode)) {
            valid = true;
        }
        lineNum = reader.readLine();    
      }
      reader.close();
      
      //if statements for valid
      if(valid == true) {
        System.out.println("Your postal code is valid");
      }
      
      else if(valid == false) {
        System.out.println("Your postal code is invalid");
      }
      
      
      return valid;

    }
    /* Description: Reads through a file that can be used to validate a person's postal code
     * Author: Vincent Nguyen
     * @param: String postalCode
     * @return: boolean valid
     * */ 
      
    
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
      //adding the total sum
      totalSum = oddSum + evenSum;
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

      try{
    	String content = "firstname " + "lastname" + "city" + "postalcode" "creditcard";

        //Specify the file name and path here
    	File file = new File("C://CustomerDataFile.csv");

    	/* This logic is to create the file if the
    	 * file is not already present
    	 */
    	if(!file.exists()){
    	   file.createNewFile();
    	}

    	//Here true is to append the content to file
    	FileWriter fw = new FileWriter(file,true);
    	//BufferedWriter writer give better performance
    	BufferedWriter bw = new BufferedWriter(fw);
    	bw.write(content);
    	//Closing BufferedWriter Stream
    	bw.close();

	System.out.println("Data transfer successful");

      }catch(IOException ioe){
         System.out.println("Data Transfer Unsuccessful");
    	 ioe.printStackTrace(); 
       }
   
}
    }
    /*******************************************************************
    *       ADDITIONAL METHODS MAY BE ADDED BELOW IF NECESSARY         *
    *******************************************************************/
}
