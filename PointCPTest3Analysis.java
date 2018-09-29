import java.util.*;

public class PointCPTest3Analysis {
	public static void main(String[] args) {
		long total = 0;
		Random random = new Random();
		char[] types = new char[1000000];
		double[] rhos = new double[1000000];
		double[] thetas = new double[1000000];
		PointCP3[] points = new PointCP3[1000000];
		
		//Populate arrays with random data
		for(int i = 0; i < 1000000; i++){
			types[i] = random.nextBoolean() ? 'C' : 'P';
			rhos[i] = Math.random() * 10000; 
			thetas[i] = Math.random() * 10000;
		}
		
		//Time for creation
		long start = System.currentTimeMillis();
		for(int j = 0; j < 1000000; j++) {
			points[j] = new PointCP3(types[j], rhos[j], thetas[j]);
		}
		long end = System.currentTimeMillis();
		long res = end - start;
		total += res;
		System.out.println("Time for creation: " + res + " ms");
		
		//Time for getX
		start = System.currentTimeMillis();
		for(int i = 0; i < 1000000; i++) {
			points[i].getX();
		}
		end = System.currentTimeMillis();
		res = end - start;
		total += res;
		System.out.println("Time for getX(): " + res + " ms");
	
		//Time for getY
		start = System.currentTimeMillis();
		for(int j = 0; j < 1000000; j++) {
				points[j].getY();
		}
		end = System.currentTimeMillis();
		res = end - start;
		total += res;
		System.out.println("Time for getY(): " + res + " ms");
	
		//Time for getRho
		start = System.currentTimeMillis();
		for(int i = 0; i < 1000000; i++) {
				points[i].getRho();
		}
		end = System.currentTimeMillis();
		res = end - start;
		total += res;
		System.out.println("Time for getRho(): " + res + " ms");
		
		//Time for getTheta
		start = System.currentTimeMillis();
		for(int j = 0; j < 1000000; j++) {
				points[j].getTheta();
		}
		end = System.currentTimeMillis();
		res = end - start;
		total += res;
		System.out.println("Time for getTheta(): " + res + " ms");
			
		//Time for getDistance(PointCP3 other)
		PointCP3 point2 = new PointCP3(random.nextBoolean() ? 'C' : 'P', Math.random()*1000, Math.random()*1000);
		start = System.currentTimeMillis();
		for(int i = 0; i < 1000000; i++) {
				points[i].getDistance(point2);
		}
		end = System.currentTimeMillis();
		res = end - start;
		total += res;
		System.out.println("Time for getDistance(PointCP3 other): " + res + " ms");

		//Time for rotatePoint()
		double rotation = 60;
		start = System.currentTimeMillis();
		for(int j = 0; j < 1000000; j++) {
				points[j].rotatePoint(rotation);
		}
		end = System.currentTimeMillis();
		res = end - start;
		total += res;
		System.out.println("Time for rotatePoint(double rotation): " + res + " ms");
		
		//Time for convertStorageToCartesian
		start = System.currentTimeMillis();
		for(int j = 0; j < 1000000; j++) {
			points[j].convertStorageToCartesian();
		}
		end = System.currentTimeMillis();
		res = end - start;
		total += res;
		System.out.println("Time for convertStorageToCartesian(): " + res + " ms");
		
		//Time for convertStorageToPolar
		start = System.currentTimeMillis();
		for(int i = 0; i < 1000000; i++) {
			points[i].convertStorageToPolar();
		}
		end = System.currentTimeMillis();
		res = end - start;
		total += res;
		System.out.println("Time for convertStorageToPolar(): " + res + " ms");
		
		// Total time
		System.out.println("Total time: " + total + " ms");
		
	
	}
}
