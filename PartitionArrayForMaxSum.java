//Time Complexity : O(n*k)
//Space Complexity : O(n)
public class PartitionArrayForMaxSum {	
	/**Approach: DP Array**/
	public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp= new int[arr.length];
        dp[0]= arr[0];        
        for(int i=1; i<dp.length; i++){
            int max= arr[i];
            for(int j=i; j>=i-k+1 && j>=0; j--){
                max= Math.max(max, arr[j]);
                if(j>0)
                    dp[i]= Math.max(dp[i], max*(i-j+1) + dp[j-1]);
                else
                    dp[i]= Math.max(dp[i], max*(i-j+1));
            }
        }        
        return dp[arr.length-1];
    }
	
	// Driver code to test above
	public static void main (String[] args) {
		PartitionArrayForMaxSum ob= new PartitionArrayForMaxSum();
		int[] arr= {1,15,7,9,2,5,10};
		int k=3;
		
		System.out.print("Largest sum of the given array after partitioning : "+ob.maxSumAfterPartitioning(arr,k));	
	}
}
