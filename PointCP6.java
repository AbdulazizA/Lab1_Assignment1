public interface PointCP6{
	double getX();
	double getY();
	double getRho();
	double getTheta();
	String toString();
	double getDistance(PointCP6 pointB);
	PointCP6 convertStorageToCartesian();
	PointCP6 convertStorageToPolar();
	PointCP6 rotatePoint(double rotation);
}