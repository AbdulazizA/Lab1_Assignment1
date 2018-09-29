import java.util.*;
public class PointCPTest6{
	public static void main(String[] arg) {
		Scanner scan = new Scanner(System.in);
		int design = getDesign(scan);
		if (design == 2) {
			PointCP6 point6 = getPointCP2(scan);
			testCP2(scan, point6);
		}
		else {
			PointCP6 point6 = getPointCP3(scan);
			testCP3(scan, point6);
		}
	}
	// Get the Option to decide between design 2 or 3
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
	// Using Design 2 so checks if you chose Polar or not, then calculates
	public static PointCP6 getPointCP2(Scanner scan) {
		while (true) {
		System.out.println("Enter what type of point to store (C)artesian/(P)olar (Use Capital C and P):");
		char type = scan.next().charAt(0);
			if (type == 'C' || type == 'P') {
				while (true) {
				System.out.println("Enter the value of x or Rho using a decimal point .");
					
					try {
						double xOrRho = scan.nextDouble();
						while (true) {
							try {
								System.out.println("Enter the value of y or Theta using a decimal point .");
								double yOrTheta = scan.nextDouble();
								PointCP6 point2 = new PointCP2(type, xOrRho, yOrTheta);
								System.out.println("You entered: \n" + point2.toString());
								return point2;
							} 
							catch (InputMismatchException e) {
								System.out.println("invalid input\n");
								scan.next();
							}
						}
					} 
					catch (InputMismatchException e) {
						System.out.println("invalid input for xOrRho\n");
						scan.next();
					}
				}
			} 
			else {
				System.out.println("Invalid Input\n");
			}
		}
	}
	// Using Design 3 so checks if you chose Polar or not, then calculates
	public static PointCP6 getPointCP3(Scanner scan) {
		while (true) {
		System.out.println("Enter what type of point to store (C)artesian/(P)olar (Use capital C and P):");
		char type = scan.next().charAt(0);
			if (type == 'C' || type == 'P') {
				while (true) {
				System.out.println("Enter the value of x or Rho using a decimal point .");
					
					try {
						double xOrRho = scan.nextDouble();
						while (true) {
							try {
								System.out.println("Enter the value of y or Theta using a decimal point .");
								double yOrTheta = scan.nextDouble();
								PointCP6 point3 = new PointCP2(type, xOrRho, yOrTheta);
								System.out.println("You entered: \n" + point3.toString());
								return point3;
							} 
							catch (InputMismatchException e) {
								System.out.println("invalid input\n");
								scan.next();
							}
						}
					} 
					catch (InputMismatchException e) {
						System.out.println("invalid input for xOrRho\n");
						scan.next();
					}
				}
			} 
			else {
				System.out.println("Invalid Input\n");
			}
		}
	}
	// The Test Run for PointCP2 as i was unable to get the args to work since it was a main code before
	public static void testCP2(Scanner scan, PointCP6 point6){
		System.out.println();
		System.out.println("After asking to store Cartesian: ");
		System.out.println(point6.convertStorageToCartesian().toString());
		System.out.println();
		
		System.out.println("After asking to store Polar:");
		System.out.println(point6.convertStorageToPolar().toString());
		System.out.println();

		System.out.println("Now enter another point to compute the distance: ");
		PointCP6 pointB = getPointCP2(scan);
		System.out.println();
		
		//Compute distance between pointA and pointB
		System.out.println("Distance between points: " + point6.getDistance(pointB));
		System.out.println();
				
		//get rotation amount from the user
		double rotation = getRotationAmount(scan);
				
		//Display current coordinates of pointA
		System.out.println("before rotation:");
		System.out.println(point6.toString());
		System.out.println();
	
		System.out.println("after rotation:");
		System.out.println(point6.rotatePoint(rotation).toString());
		System.out.println();
	
		System.out.println("Test complete");
		
	}
	// The Test Run for PointCP3 as i was unable to get the args to work since it was a main code before
	public static void testCP3(Scanner scan, PointCP6 point6){
		System.out.println("After asking to store Cartesian: \n");
		System.out.println(point6.convertStorageToCartesian().toString());
		System.out.println("After asking to store Polar: \n");
				
		System.out.println(point6.convertStorageToPolar().toString());
		System.out.println("Now enter another point to compute the distance: \n");
				
		PointCP6 pointB = getPointCP3(scan);
				
		//Compute distance between pointA and pointB
		System.out.println("Distance between points: \n" + point6.getDistance(pointB));
		System.out.println();
				
		//get rotation amount from the user
		double rotation = getRotationAmount(scan);
				
		//Display current coordinates of pointA
		System.out.println("before rotation:\n");
		System.out.println(point6.toString());
			
		System.out.println("after rotation:\n");
		System.out.println(point6.rotatePoint(rotation).toString());
			
		System.out.println("Test complete\n");
		
	}
	// the rotation value so when getting 2 output and it checks the distance between them and then
	//takes your rotate amount and it by.
	private static double getRotationAmount(Scanner scan) {
		
		double rotationAmount;
		while(true) {
			System.out.println("Now enter rotation amount in degrees using a decimal point: \n");
			
			try {
				rotationAmount = scan.nextDouble();
				return rotationAmount;
			}
			catch(InputMismatchException e) {
				System.out.println("Invalid input\n");
			}
		}
	}
	
}