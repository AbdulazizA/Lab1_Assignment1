/**
 * This class contains instances of coordinates in polar format.
 * It also provides the utilities to convert
 * them into cartesian. It is not an optimal design, it is used
 * only to illustrate some design issues.
 *
 *
 * Based upon the class PointCP.java provided for this Laboratory
 *
 * @author Matthew Langlois
 * @author Matthew Yaraskavitch
 * @version September 2015
 */
public class PointCP2 implements PointCP6 {
    //Instance variables ************************************************

    /**
     * Contains C(artesian) or P(olar) to identify the type of
     * coordinates that are being dealt with.
     */
    private char typeCoord;

    /**
     * Contains the current value of RHO.
     */
    private double rho;

    /**
     * Contains the current value of THETA.
     */
    private double theta;


    //Constructors ******************************************************

    /**
     * Constructs a coordinate object, with a type identifier.
     * Stores in Polar and converts from Cartesian if necessary.
     */
    public PointCP2(char type, double xOrRho, double yOrTheta) {
        if(type != 'C' && type != 'P')
        throw new IllegalArgumentException();
        this.typeCoord = type;
        if(this.typeCoord == 'C'){
            this.rho = (Math.sqrt(Math.pow(xOrRho, 2) + Math.pow(yOrTheta, 2)));
            this.theta = Math.toDegrees(Math.atan2(yOrTheta, xOrRho));
        }
        else{
            this.rho = xOrRho;
            this.theta = yOrTheta;
        }
        typeCoord = 'P';

    }


    //Instance methods **************************************************


    public double getX() {
        return (Math.cos(Math.toRadians(theta)) * rho);
    }

    public double getY() {
        return (Math.sin(Math.toRadians(theta)) * rho);
    }

    public double getRho() {
        return rho;
    }

    public double getTheta() {
        return theta;
    }
    
    /**
     * Converts Polar coordinates to Cartesian coordinates.
     * Does nothing since this implementation has only one storage format
     */
    public PointCP3 convertStorageToCartesian(){
        return new PointCP3('C', getX(), getY());
    }


    /**
     * Calculates the distance in between two points using the Pythagorean
     * theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
     *
     * @param pointA The first point.
     * @param pointB The second point.
     * @return The distance between the two points.
     */
    public double getDistance(PointCP6 pointB) {
        // Obtain differences in X and Y, sign is not important as these values
        // will be squared later.
        double deltaX = getX() - pointB.getX();
        double deltaY = getY() - pointB.getY();

        return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
    }

    /**
     * Rotates the specified point by the specified number of degrees.
     * Not required until E2.30
     *
     * @param point    The point to rotate
     * @param rotation The number of degrees to rotate the point.
     * @return The rotated image of the original point.
     */
    public PointCP2 rotatePoint(double rotation) {
        double radRotation = Math.toRadians(rotation);
        double X = getX();
        double Y = getY();

        return new PointCP2('C',
                (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
                (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
    }

    /**
     * Returns information about the coordinates.
     *
     * @return A String containing information about the coordinates.
     */
    public String toString() {
        return "Stored as Polar " + "[" + getRho() + "," + getTheta() + "]";
    }
    
	@Override
	public PointCP2 convertStorageToPolar() {
		return new PointCP2('P', this.rho, this.theta);
	}

	@Override
	public char getType() {
		return 'P';
	}
}