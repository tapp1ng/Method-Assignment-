// Throughout this project, the use of data structures are not permitted such as methods like .split and .toCharArray




import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

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
      
    
    public static void validateCreditCard(){
    }
    /*
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    public static void generateCustomerDataFile(){
    }
    /*******************************************************************
    *       ADDITIONAL METHODS MAY BE ADDED BELOW IF NECESSARY         *
    *******************************************************************/
}
