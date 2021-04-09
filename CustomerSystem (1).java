// Throughout this project, the use of data structures are not permitted such as methods like .split and .toCharArray




import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;

// More packages may be imported in the space below

class CustomerSystem2{
    public static void main(String[] args) throws FileNotFoundException{
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
    public static boolean validatePostalCode(String postalCode) throws FileNotFoundException{ 
      
      boolean valid = false;
      
      System.out.println("Please input your postal code.");
      Scanner input = new Scanner(System.in);
      String postal = input.nextLine();
      
      postalCode = postal.substring(0,3);
      FileReader fileName = new FileReader("postal_codes.csv"); //targets the file for opening

      Scanner reader = new Scanner(fileName);
      String line = reader.nextLine();
      line = reader.nextLine();     
      while (line != null) {
        if (line.contains(postalCode)) {
            valid = true;
        }
        line = reader.nextLine();    
      }
      System.out.println(line);
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