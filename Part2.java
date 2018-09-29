import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
import java.util.Iterator;

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
	///PART 2 B
	 @SuppressWarnings("unchecked")
	private static double arrayListTimeAndSum (int size) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		long StartTime, endTimeFill, endTimeAdd;
		long elapsedTimeSum = 0;
		int denominator = 0;
		int sum = 0;

		for (int i = 0; i < 1000; i++){
			arrayList = new ArrayList<Integer>();
			arrayList.ensureCapacity(size);
			StartTime = System.nanoTime();
			Random rand = new Random();
			for (int j = 0; j < size; j++){
			arrayList.add(ThreadLocalRandom.current().nextInt(0, 100));
			}
			endTimeFill = System.nanoTime();
			for (int k=0;k<size;k++ ) {
			 Iterator<Integer> iterator = arrayList.iterator();

			 while(iterator.hasNext()){
				 int test = iterator.next().intValue();
		  	 iterator.next();
				 sum += test;
			 }
			}
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
 @SuppressWarnings("unchecked")
	private static double vectorTimeAndSum (int size) {
		long StartTime, endTimeFill, endTimeAdd;
		long elapsedTimeSum = 0;
		int denominator = 0;
		int sum = 0;

		for (int i = 0; i < 1000; i++){
			StartTime = System.nanoTime();
			Vector v;
			v = new Vector(size);
			for (int j = 0; j < size; j++){
			Random rand = new Random();
			int  n = rand.nextInt(50) + 1;
			v.addElement(new Integer(n));
			}
			endTimeFill = System.nanoTime();
			for (int k=0;k<size;k++ ) {
			 Iterator<Integer> iterator = v.iterator();

			 while(iterator.hasNext()){
				 int test = iterator.next().intValue();
				 iterator.next();
				 sum += test;
			 }
		 }
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
