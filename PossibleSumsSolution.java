import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PossibleSumsSolution {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int numberOfCases= in.nextInt();
		
		for(int i=0; i<numberOfCases; i++){
			boolean isMaxSum = false;
			int minRemainder = 0;
			int arrayLength = in.nextInt();
			int maxSum = in.nextInt();
			int[] givenArr = new int[arrayLength];
			for(int a=0; a<arrayLength; a++){
				givenArr[a]=in.nextInt();				
			}
			for(int a=0; a<arrayLength; a++){
				if(a==0) {
					minRemainder = maxSum % givenArr[a];
				} else {
					minRemainder = Math.min(minRemainder, maxSum % givenArr[a]);
				}
				if(minRemainder==0){
					isMaxSum = true;
					break;
				}
			}
			if(isMaxSum){
				System.out.println(maxSum);
			} else {
				Arrays.sort(givenArr);
				if(maxSum<givenArr[0]){
					System.out.println(0);
				} else {
					System.out.println(getMaxPossibleSum(maxSum, givenArr, minRemainder));
				}
			}
		}				
	}
	
	public static int getMaxPossibleSum (int number, int[] arr, int minRemainder){
        int n = arr.length; 
        List<Integer> result = new ArrayList<Integer>();
        subsetSums(arr, 0, n - 1, 0, result); 
        int[] finalArr = result.stream().mapToInt(s -> number%s).sorted().toArray();
        for(int i=0; i<finalArr.length; i++){
        	int value = finalArr[i];
        	if(Arrays.stream(arr).anyMatch(s -> s== value)){
        		return number;
        	}
        }
        return number-Math.min(minRemainder, finalArr[0]);
	}
	
	public static void subsetSums(int[] arr, int l, int r, int sum, List<Integer> result) {
		if (l > r) {
			if(sum>0)
				result.add(sum);
			return;
		}
		subsetSums(arr, l + 1, r, sum + arr[l], result);
		subsetSums(arr, l + 1, r, sum, result);
	}

}
