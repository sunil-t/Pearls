package codility;

import java.util.Arrays;
import java.util.HashMap;

public class AbsDistinct {
	public static void main(String [] args) {
		int [] input = {};
		System.out.println(complementary_pairs(2, input));
	}
	
	public static int absDistinct(int [] A) {
		HashMap<Integer, Integer> uniques = new HashMap<Integer, Integer>();
		for(int a: A) {
			if(!uniques.containsKey(new Integer(Math.abs(a)))){
				uniques.put(new Integer(Math.abs(a)), 1);
			}
		}
		return uniques.size();
	}
	
	public static boolean testHeavy(int A) {
		int sum = 0;
		int digitCount = 1;
		while(A>9){
				sum += A%10;
				A = A/10;
				digitCount++;
		}
		sum += A;
		if(((sum*1.0)/digitCount) >7)
			return true;
		return false;
	}
	
	public static int countHeavy(int a, int b) {
		int count = 0;
		for(int i=a;i<=b;i++) {
			if(testHeavy(i)){
				count++;
			}
		}
		return count;
	}
	
	public static int complementary_pairs2(int k, int[] A) {
		Arrays.sort(A);
		int i=0;
		int j=A.length-1;
		int count = 0;

		while( i <= j ) {
		  if( A[i] + A[j] == k ) {
		    // (i,j) is a complementary pair.
			 System.out.println("("+i+","+j+")");
		    count++;

		    // if i!= j then (j,i) is also a complementary pair.
		    if( i != j) {
		    	System.out.println("("+j+","+i+")");
		       count++;
		    }
		    i++;
		    j--;
		  } else if( A[i] + A[j] < k ) {
		    i++;
		  } else {
		    j--;
		  }
		}
		return count;
	}
	public static int complementary_pairs(int k, int[] A) {
		int count = 0;
		int index = 0;
		while(index< A.length) {
			for(int i=index; i<A.length; i++) {
				if(A[index]+A[i] == k) {
					count++;
					if(index != i){
						count ++;
					}
				}
			}
			index++;
		}
		return count;
	}
}
