import java.util.*;
public class PointCPTest6Analysis {
	public static void main(String[] args) {
		analysis(2);
		analysis(3);
	}
			
	public static void analysis(int design) {
		System.out.println("ANALYSIS TEST FOR DESIGN " + design + " IMPLEMENTING POINTCP6 INTERFACE");
		Random r = new Random();
		long start;
		long end;
		long res;
		long total = 0;
		char[] types = new char[1000000];
		double[] rhos = new double[1000000];
		double[] thetas = new double[1000000];
		PointCP6[] points = new PointCP6[1000000];
				
				
		//Populate arrays with random data
		for(int i = 0; i < 1000000; i++){
			types[i] = r.nextBoolean() ? 'C' : 'P';
			rhos[i] = Math.random() * 10000; 
			thetas[i] = Math.random() * 10000;
		}
				
		//Time for creation
		if(design == 2) {
			start = System.currentTimeMillis();
			for(int i = 0; i < 1000000; i++) {
				points[i] = new PointCP2(types[i], rhos[i], thetas[i]);
			}
			end = System.currentTimeMillis();
			res = end - start;
			total += res;
			System.out.println("Time for creation: " + res + " ms");
			}
			else {
				start = System.currentTimeMillis();
				for(int i = 0; i < 1000000; i++) {
					points[i] = new PointCP3(types[i], rhos[i], thetas[i]);
				}
				end = System.currentTimeMillis();
				res = end - start;
				total += res;
				System.out.println("Time for creation: " + res + " ms");
			}
	
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
		for(int i = 0; i < 1000000; i++) {
			points[i].getY();
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
		for(int i = 0; i < 1000000; i++) {
			points[i].getTheta();
		}
		end = System.currentTimeMillis();
		res = end - start;
		total += res;
		System.out.println("Time for getTheta(): " + res + " ms");
		
		//Time for getDistance(PointCP2 other)
		PointCP6 point;
		if(design == 2) {
			point = new PointCP2(r.nextBoolean() ? 'C' : 'P', Math.random()*1000000, Math.random()*1000000);
		}
		else {
			point = new PointCP3(r.nextBoolean() ? 'C' : 'P', Math.random()*1000000, Math.random()*1000000);
		}
		start = System.currentTimeMillis();
		for(int i = 0; i < 1000000; i++) {
			points[i].getDistance(point);
		}
		end = System.currentTimeMillis();
		res = end - start;
		total += res;
		System.out.println("Time for getDistance(PointCP2 other): " + res + " ms");
		
		//Time for rotatePoint()
		double rotation = 60;
		start = System.currentTimeMillis();
		for(int i = 0; i < 1000000; i++) {
			points[i].rotatePoint(rotation);
		}
		end = System.currentTimeMillis();
		res = end - start;
		total += res;
		System.out.println("Time for rotatePoint(double rotation): " + res + " ms");
		
		//Time for convertStorageToCartesian
		start = System.currentTimeMillis();
		for(int i = 0; i < 1000000; i++) {
		points[i].convertStorageToCartesian();
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
		
		// Total Time
		System.out.println("Total time: " + total + " ms");
		System.out.println();
	}
}
