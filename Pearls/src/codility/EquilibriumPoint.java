package codility;

public class EquilibriumPoint {
	public static void main(String[] args) {
		int[] array = {};
		EquilibriumPoint eq = new EquilibriumPoint();
		System.out.println(eq.equi(array));
		System.out.println(eq.equi2(array));
	}
	
	public int equi (int[] A ) {
		if(A.length == 0)
			return -1;
		if(A.length == 1) 
			return A[0];
	    Integer[] inc = new Integer[A.length];
	    Integer[] dec = new Integer[A.length];
	    
	    inc[0] = A[0];
	    dec[A.length-1] = A[A.length-1];
	    
	    for(int i=1; i<A.length;i++) {
	        inc[i] = A[i]+inc[i-1];
	    }
	    for(int i=A.length-2; i>=0 ; i--) {
	        dec[i] = A[i]+dec[i+1];
	    }
	    for(int i=0; i<A.length;i++) {
	    	if(inc[i] == dec[i])
	    		return i;
	    }
	    
	    return -1;
	} 
	
	public int equi2 ( int[] A ) {        
	    
	    long leftSum = 0;
	    long rightSum = 0;
	    
	    for (int iterator= 0; iterator< A.length; iterator++){
	        rightSum += A[iterator];
	    }
	    
	    for(int eqIndexCandidate = 0; eqIndexCandidate < A.length; eqIndexCandidate ++){
	       
	        if (eqIndexCandidate != 0)
	           leftSum += A[eqIndexCandidate - 1];
	        
	        rightSum -= A[eqIndexCandidate];
	        
	        if (leftSum == rightSum)
	            return eqIndexCandidate;
	        
	    }
	    
	    return -1;
	}
	
	public void printArray(Integer[] A) {
		for(int i=0; i<A.length; i++) {
			System.out.print(A[i]+",");
		}
		System.out.print("\n");
	}
}

