package infosys;

import java.util.Arrays;
import java.util.Scanner;

public class KnapsackSolution {
	
	public static void main(String[] args){
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
			System.out.println(getMaxPossibleSum(maxSum, givenArr));			
		}				
	}
	
	public static int getMaxPossibleSum(int number, int[] arr){
		int[] sumArray = new int[number+1];
		for(int i=1; i<=number; i++){
			for(int j=0; j<arr.length; j++){
				if(arr[j]<=i){
					sumArray[i]=Math.max(sumArray[i], sumArray[i-arr[j]]+arr[j]);
				} else {
					break;
				}
			}
		}
		return sumArray[number];
	}

}
