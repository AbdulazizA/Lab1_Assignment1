import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

public class Part2 {
	
	private static double arrayTime (int size) {
		int[] array = new int[size];
		long StartTime;
		long endTime; 
		long elapsedTimeSum = 0;
		int denominator = 0;
		for (int i = 0; i < 1000; i++){
			StartTime = System.nanoTime();
			for (int j = 0; j < size; j++){
				array[j] = ThreadLocalRandom.current().nextInt(0, 100);
			}
			endTime = System.nanoTime();
			elapsedTimeSum += (endTime - StartTime);
			denominator++;
		}
		return elapsedTimeSum/denominator;
	}
	
	private static double arrayTimeAndSum (int size) {
		int[] array = new int[size];
		long StartTime;
		long endTime;
		long endTimeAdd; 
		long elapsedTimeSum = 0;
		int denominator = 0;
		int sum = 0;
		
		for (int i = 0; i < 1000; i++){
			StartTime = System.nanoTime();
			for (int j = 0; j < size; j++){
				array[j] = ThreadLocalRandom.current().nextInt(0, 100);
			}
			endTime = System.nanoTime();
			for (int j = 0; j < size; j++){
				sum += array[j];
			}
			endTimeAdd = System.nanoTime();
			elapsedTimeSum += (endTimeAdd - StartTime)-(endTime-StartTime);
			denominator++;
		}
		return elapsedTimeSum/denominator;
	}
	
	private static double arrayListTime (int size) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		long StartTime, endTime; 
		long elapsedTimeSum = 0;
		int denominator = 0;
		
		for (int i = 0; i < 1000; i++){
			arrayList = new ArrayList<Integer>();
			arrayList.ensureCapacity(size);
			StartTime = System.nanoTime();
			for (int j = 0; j < size; j++){
				arrayList.add(ThreadLocalRandom.current().nextInt(0, 100));
			}
			endTime = System.nanoTime();
			elapsedTimeSum += (endTime - StartTime);
			denominator++;
		}
		return elapsedTimeSum/denominator;
	}
	
	private static double arrayListTimeAndSum (int size) {
		long StartTime, endTimeFill, endTimeAdd; 
		long elapsedTimeSum = 0;
		int denominator = 0;
		int sum = 0;
		
		for (int i = 0; i < 1000; i++){
			StartTime = System.nanoTime();
			for (int j = 0; j < size; j++){
			//Array list
			}
			endTimeFill = System.nanoTime();
			//Array list and sum code
			endTimeAdd = System.nanoTime();
			elapsedTimeSum += (endTimeAdd - StartTime)-(endTimeFill-StartTime);
			denominator++;
		}
		return elapsedTimeSum/denominator;
	}
	
	private static double vectorTime (int size) {
		Vector<Integer> vector = new Vector<Integer>(size);
		long StartTime, endTime; 
		long elapsedTimeSum = 0;
		int denominator = 0;
		
		for (int i = 0; i < 1000; i++){
			vector = new Vector<Integer>();
			StartTime = System.nanoTime();
			for (int j = 0; j < size; j++){
				vector.addElement(ThreadLocalRandom.current().nextInt(0, 100));
			}
			endTime = System.nanoTime();
			elapsedTimeSum += (endTime - StartTime);
			denominator++;
		}
		return elapsedTimeSum/denominator;
	}
	
	private static double vectorTimeAndSum (int size) {
		long StartTime, endTimeFill, endTimeAdd; 
		long elapsedTimeSum = 0;
		int denominator = 0;
		int sum = 0;
		
		for (int i = 0; i < 1000; i++){
			StartTime = System.nanoTime();
			for (int j = 0; j < size; j++){
			//Vector code
			}
			endTimeFill = System.nanoTime();
			//Vector and sum code
			endTimeAdd = System.nanoTime();
			elapsedTimeSum += (endTimeAdd - StartTime)-(endTimeFill-StartTime);
			denominator++;
		}
		return elapsedTimeSum/denominator;
	}
	
	public static void main(String[] args) {
		int size = 10000;
		System.out.println("Array Average Time: " + arrayTime(size) + " ns");
		System.out.println("Array List Average Time: " + arrayListTime(size)+ " ns");
		System.out.println("Vector Time: " + vectorTime(size) + " ns");
		System.out.println();
		System.out.println("Array and Summation Time: " + arrayTimeAndSum(size)+ " ns");
		System.out.println("Array List and Summation Time: " + arrayListTimeAndSum(size)+ " ns");
		System.out.println("Vector and Summation Time: " + vectorTimeAndSum(size)+ " ns");
	}
}
