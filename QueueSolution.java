import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class QueueSolution {	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numberOfCases= in.nextInt();
		
		for(int i=0; i<numberOfCases; i++){
			int arrayLength = in.nextInt();
			int maxSum = in.nextInt();
			int[] givenArr = new int[arrayLength];
			for(int a=0; a<arrayLength; a++){
				givenArr[a]=in.nextInt();
			}
			Arrays.sort(givenArr);
			getMaxPossibleSum(maxSum, givenArr);			
		}	
	}
	
	public static void getMaxPossibleSum(int number, int[] arr){
		boolean newList[] = new boolean[2001];
		for(int i =0; i < arr.length; i++){
			int n = arr[i];
			newList[n] = true;
		}
		ArrayList<Integer> arList = new ArrayList<Integer>();
		for(int i =0; i < newList.length;i++){
			if(newList[i]) arList.add(i);
		}
		
		PriorityQueue<Integer> pqueue = new PriorityQueue<Integer>();		
		int cache = 0;
		int previous = 0;
		HashMap<Integer,Boolean> map = new HashMap<Integer,Boolean>();
		 map.put(0, true);
		while(cache <= number){
			for(int i : arList){
				if(!map.containsKey(cache + i)){
					pqueue.add((cache + i));
					map.put(cache + i, true);
				}
			}
			
			previous = cache;
			cache = pqueue.poll();
		} 
		System.out.println(previous);
	}

}
