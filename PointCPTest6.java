import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This class prompts the user for a set of coordinates, and then
 * converts them from polar to cartesian or vice-versa.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @author Paul Holden
 * @version July 2000
 */
public class PointCPTest6{
    //Class methods *****************************************************
    /**
     * This method is responsible for the creation of the PointCP2
     * object.  This can be done in two ways; the first, by using the
     * command line and running the program using <code> java
     * PointCPTest2 &lt;coordtype (c/p)&gt; &lt;X/RHO&gt; &lt;Y/THETA&gt;
     * </code> and the second by getting the program to prompt the user.
     * If the user does not enter a valid sequence at the command line,
     * the program will prompte him or her.
     *
     * @param args[0] The coordinate type.  P for polar and C for
     *                cartesian.
     * @param args[1] The value of X or RHO.
     * @param args[2] The value of Y or THETA.
     */
	public static int getDesign(Scanner scan) {
		while(true) {
			System.out.println("Enter which Design you wish to Use Design 2 or Design 3 (please type a number):");
			try {
				int design = scan.nextInt();
				if(design == 3 || design == 2) {
					return design;
				}
				else {
					System.out.println("Invaled Input\n");
				}
			}
			catch(InputMismatchException e){
				System.out.println("Invaled Input\n");
			}
		}
	}
    public static void main(String[] args){
    	Scanner scan = new Scanner(System.in);
		int design = getDesign(scan);
		if (design == 2) {
			PointCP2 point2;
			System.out.println("Cartesian-Polar Coordinates Conversion Program");

	        // Check if the user input coordinates from the command line
	        // If he did, create the PointCP2 object from these arguments.
	        // If he did not, prompt the user for them.
	        try{
	            point2 = new PointCP2(args[0].toUpperCase().charAt(0),
	                    Double.valueOf(args[1]).doubleValue(),
	                    Double.valueOf(args[2]).doubleValue());
	        }
	        catch(Exception e){
	            // If we arrive here, it is because either there were no
	            // command line arguments, or they were invalid
	            if(args.length != 0)
	                System.out.println("Invalid arguments on command line");

	            try{
	                point2 = getInput2();
	            }
	            catch(IOException ex){
	                System.out.println("Error getting input. Ending program.");
	                return;
	            }
	        }
	        PointCP3 point3 = point2.convertStorageToCartesian();
	        
	        System.out.println("\nYou entered:\n" + point2);
	        point3.convertStorageToCartesian();
	        System.out.println("\nAfter asking to store as Cartesian:\n" + point3);
	        point2.convertStorageToPolar();
	        System.out.println("\nAfter asking to store as Polar:\n" + point2);
	        System.out.println("\nNow enter another point to compute the distance:");
	        PointCP2 other = new PointCP2('P',0,0);
	        try {
				other = getInput2();
			} catch (IOException ex) {
				System.out.println("Error getting input. Ending program.");
			}
			System.out.println ("Origin point: " + point2);
			System.out.println ("New point: " + other);
			System.out.println ("The distance between two point is " +
				point2.getDistance (other));
			// Rotate the point with given rotation 
			double rotation = 0.0;
			boolean get = false;
			while (!get) {
				System.out.print ("\nEnter the angle in degree for rotation: ");
				get = true; 
				try {
					rotation = getRotation ();
				} catch (InputMismatchException exc) {
					System.out.println ("Illegal input. Try again.");
					get = false;
				}
			}
			PointCP2 afterRot = point2.rotatePoint (rotation);
			System.out.println ("After rotation, the point would be " + afterRot);
		}
		else {
			PointCP3 point3;
		      

		      System.out.println("Cartesian-Polar Coordinates Conversion Program");

		      // Check if the user input coordinates from the command line
		      // If he did, create the PointCP2 object from these arguments.
		      // If he did not, prompt the user for them.
		      try{
		          point3 = new PointCP3(args[0].toUpperCase().charAt(0),
		                  Double.valueOf(args[1]).doubleValue(),
		                  Double.valueOf(args[2]).doubleValue());
		      }
		      catch(Exception e){
		          // If we arrive here, it is because either there were no
		          // command line arguments, or they were invalid
		          if(args.length != 0)
		              System.out.println("Invalid arguments on command line");

		          try{
		              point3 = getInput3();
		          }
		          catch(IOException ex){
		              System.out.println("Error getting input. Ending program.");
		              return;
		          }
		      }
		      PointCP2 point2 = point3.convertStorageToPolar();
		      
		      System.out.println("\nYou entered:\n" + point3);
		      point3.convertStorageToCartesian();
		      System.out.println("\nAfter asking to store as Cartesian:\n" + point3);
		      point2.convertStorageToPolar();
		      System.out.println("\nAfter asking to store as Polar:\n" + point2);
		      System.out.println ("\nNow enter another point to compute the distance:");
				PointCP3 other = new PointCP3('C', 0, 0);
				try {
					other = getInput3();
				} catch (IOException ex) {
					System.out.println("Error getting input. Ending program.");
				}
				System.out.println ("Origin point: " + point3);
				System.out.println ("New point: " + other);
				System.out.println ("The distance between two point is " +
					point3.getDistance (other));
			    
			    
			 // Rotate the point with given rotation degree
			 		double rotation = 0.0;
			 		boolean get = false;
			 		while (!get) {
			 			System.out.print ("\nEnter the angle in degree for rotation: ");
			 			get = true; 
			 			try {
			 				rotation = getRotation ();
			 			} catch (InputMismatchException exc) {
			 				System.out.println ("Illegal input. Try again.");
			 				get = false;
			 			}
			 		}
			 		PointCP3 afterRot = point3.rotatePoint (rotation);
			 		System.out.println ("After rotation, the point would be " + afterRot);
		}
    }
	public static double getRotation () throws InputMismatchException {
		Scanner input = new Scanner (System.in);
		int result = input.nextInt ();
		input.close ();
		return result;
	} 

    /**
     * This method obtains input from the user and verifies that
     * it is valid.  When the input is valid, it returns a PointCP2
     * object.
     *
     * @return A PointCP2 constructed using information obtained
     *         from the user.
     * @throws IOException If there is an error getting input from
     *         the user.
     */
    private static PointCP2 getInput2() throws IOException{
        byte[] buffer = new byte[1024];  //Buffer to hold byte input
        boolean isOK = false;  // Flag set if input correct
        String theInput = "";  // Input information

        //Information to be passed to the constructor
        char coordType = 'A'; // Temporary default, to be set to P or C
        double a = 0.0;
        double b = 0.0;

        // Allow the user to enter the three different arguments
        for (int i = 0; i < 3; i++){
            while (!(isOK)){
                isOK = true;  //flag set to true assuming input will be valid

                // Prompt the user
                if (i == 0){ // First argument - type of coordinates
                    System.out.print("Enter the type of Coordinates you "
                            + "are inputting ((C)artesian / (P)olar): ");
                }
                else{ // Second and third arguments
                    System.out.print("Enter the value of "
                            + (coordType == 'C'
                            ? (i == 1 ? "X " : "Y ")
                            : (i == 1 ? "Rho " : "Theta "))
                            + "using a decimal point(.): ");
                }

                // Get the user's input

                // Initialize the buffer before we read the input
                for(int k=0; k<1024; k++)
                    buffer[k] = '\u0020';

                System.in.read(buffer);
                theInput = new String(buffer).trim();

                // Verify the user's input
                try{
                    if (i == 0){  // First argument -- type of coordinates
                        if (!((theInput.toUpperCase().charAt(0) == 'C')
                                || (theInput.toUpperCase().charAt(0) == 'P'))){
                            //Invalid input, reset flag so user is prompted again
                            isOK = false;
                        }
                        else{
                            coordType = theInput.toUpperCase().charAt(0);
                        }
                    }
                    else{  // Second and third arguments
                        //Convert the input to double values
                        if (i == 1)
                            a = Double.valueOf(theInput).doubleValue();
                        else
                            b = Double.valueOf(theInput).doubleValue();
                    }
                }
                catch(Exception e){
                    System.out.println("Incorrect input");
                    isOK = false;  //Reset flag as so not to end while loop
                }
            }

            //Reset flag so while loop will prompt for other arguments
            isOK = false;
        }
        //Return a new PointCP2 object
        return (new PointCP2(coordType, a, b));
    }
    private static PointCP3 getInput3() throws IOException{
        byte[] buffer = new byte[1024];  //Buffer to hold byte input
        boolean isOK = false;  // Flag set if input correct
        String theInput = "";  // Input information

        //Information to be passed to the constructor
        char coordType = 'A'; // Temporary default, to be set to P or C
        double a = 0.0;
        double b = 0.0;

        // Allow the user to enter the three different arguments
        for (int i = 0; i < 3; i++){
            while (!(isOK)){
                isOK = true;  //flag set to true assuming input will be valid

                // Prompt the user
                if (i == 0){ // First argument - type of coordinates
                    System.out.print("Enter the type of Coordinates you "
                            + "are inputting ((C)artesian / (P)olar): ");
                }
                else{ // Second and third arguments
                    System.out.print("Enter the value of "
                            + (coordType == 'C'
                            ? (i == 1 ? "X " : "Y ")
                            : (i == 1 ? "Rho " : "Theta "))
                            + "using a decimal point(.): ");
                }

                // Get the user's input

                // Initialize the buffer before we read the input
                for(int k=0; k<1024; k++)
                    buffer[k] = '\u0020';

                System.in.read(buffer);
                theInput = new String(buffer).trim();

                // Verify the user's input
                try{
                    if (i == 0){  // First argument -- type of coordinates
                        if (!((theInput.toUpperCase().charAt(0) == 'C')
                                || (theInput.toUpperCase().charAt(0) == 'P'))){
                            //Invalid input, reset flag so user is prompted again
                            isOK = false;
                        }
                        else{
                            coordType = theInput.toUpperCase().charAt(0);
                        }
                    }
                    else{  // Second and third arguments
                        //Convert the input to double values
                        if (i == 1)
                            a = Double.valueOf(theInput).doubleValue();
                        else
                            b = Double.valueOf(theInput).doubleValue();
                    }
                }
                catch(Exception e){
                    System.out.println("Incorrect input");
                    isOK = false;  //Reset flag as so not to end while loop
                }
            }

            //Reset flag so while loop will prompt for other arguments
            isOK = false;
        }
        //Return a new PointCP2 object
        return (new PointCP3(coordType, a, b));
    }
}