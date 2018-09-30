import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Part2 {
    
    private static double arrayTime (int size) {
        int[] array = new int[size];
        long startTime;
        long endTime; 
        long elapsedTimeSum = 0;
        int denominator = 0;
        for (int i = 0; i < 1000; i++){
            startTime = System.currentTimeMillis();
            for (int j = 0; j < size; j++){
                array[j] = ThreadLocalRandom.current().nextInt(0, 100);
            }
            endTime = System.currentTimeMillis();
            elapsedTimeSum += (endTime - startTime);
            denominator++;
        }
        return elapsedTimeSum/denominator;
    }
    
    private static double arrayTimeAndSum (int size) {
        int[] array = new int[size];
        long startTime;
        long endTime;
        long endTimeAdd; 
        long elapsedTimeSum = 0;
        int denominator = 0;
        int sum = 0;
        
        for (int i = 0; i < 1000; i++){
            startTime = System.currentTimeMillis();
            for (int j = 0; j < size; j++){
                array[j] = ThreadLocalRandom.current().nextInt(0, 100);
            }
            endTime = System.currentTimeMillis();
            for (int j = 0; j < size; j++){
                sum+= array[j];
            }
            endTimeAdd = System.currentTimeMillis();
            elapsedTimeSum += (endTimeAdd - startTime)-(endTime-startTime);
            denominator++;
        }
        return elapsedTimeSum/denominator;
    }
    
    private static double arrayListTime(int size){
        ArrayList<Integer> arrayList = new ArrayList<Integer>(size);
        long startTime;
        long endTime; 
        long diffTimeSum = 0;
        int avgDenominator = 0;
        
        for (int i = 0; i < 100; i++){
            arrayList = new ArrayList<Integer>(size);
            startTime = System.currentTimeMillis();
            for (int j = 0; j < size; j++){
                arrayList.add(ThreadLocalRandom.current().nextInt(0, 100));
            }
            endTime = System.currentTimeMillis();
            diffTimeSum += (endTime - startTime);
            avgDenominator++;
        }
        return diffTimeSum/avgDenominator;
    }
    
    private static double arrayListTimeAndSum (int size) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>(size);
        long startTime;
        long endTime; 
        long endTimeAdd; 
        long elapsedTimeSum = 0;
        int denominator = 0;
        int sum = 0;
        
        for (int i = 0; i < 100; i++){
            arrayList = new ArrayList<Integer>(size);
            startTime = System.currentTimeMillis();
            for (int j = 0; j < size; j++){
                arrayList.add(ThreadLocalRandom.current().nextInt(0, 100));
            }
            endTime = System.currentTimeMillis();
            Iterator<Integer> iter = arrayList.iterator();
            for (int j = 0; j < size; j++){
                sum += iter.next();
            }
            
            endTimeAdd = System.currentTimeMillis();
            elapsedTimeSum += (endTimeAdd - startTime)-(endTime - startTime);
            denominator++;
        }
        return elapsedTimeSum/denominator;
    }
    
    private static double vectorTime (int size) {
        Vector<Integer> vector = new Vector<Integer>(size);
        long startTime; 
        long endTime; 
        long elapsedTimeSum = 0;
        int denominator = 0;
        
        for (int i = 0; i < 1000; i++){
            vector = new Vector<Integer>();
            startTime = System.currentTimeMillis();
            for (int j = 0; j < size; j++){
                vector.addElement(ThreadLocalRandom.current().nextInt(0, 100));
            }
            endTime = System.currentTimeMillis();
            elapsedTimeSum += (endTime - startTime);
            denominator++;
        }
        return elapsedTimeSum/denominator;
    }
    
    private static double vectorTimeAndSum (int size) {
        Vector<Integer> vector = new Vector<Integer>(size);
        long startTime; 
        long endTime; 
        long endTimeAdd; 
        long elapsedTimeSum = 0;
        int denominator = 0;
        int sum = 0;
        
        for (int i = 0; i < 10; i++){
            vector = new Vector<Integer>(size);
            startTime = System.currentTimeMillis();
            for (int j = 0; j < size; j++){
                vector.add(ThreadLocalRandom.current().nextInt(0, 10));
            }
            endTime = System.currentTimeMillis();
            Iterator<Integer> iter = vector.iterator();
            for (int j = 0; j < size; j++){
                sum += iter.next();
            }
            endTimeAdd = System.currentTimeMillis();
            elapsedTimeSum += (endTimeAdd - startTime)-(endTime-startTime);
            denominator++;
        }
        return elapsedTimeSum/denominator;
    }
    
    public static void main(String[] args) {
        int size = 5000000;
        
        System.out.println("Array Time Taken: " + arrayTime(size) + " ms");
        System.out.println("Array List Time taken: " + arrayListTime(size)+ " ms");
        System.out.println("Vector Time taken: " +vectorTime(size)+ " ms" + "\n");
        System.out.println("Array summation Time taken: " + arrayTimeAndSum(size) + " ms");
        System.out.println("Array List summation Time taken: " + arrayListTimeAndSum(size) + " ms");
        System.out.println("Vector summation Time taken: " + vectorTimeAndSum(size) + " ms" + "\n");
    }
}