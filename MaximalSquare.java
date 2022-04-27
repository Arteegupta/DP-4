//Time Complexity : O(m*n); where m and n are number of rows and columns in input matrix
//Space Complexity : O(n)
public class MaximalSquare {	
	/**Approach1: DP Matrix| Time O(m*n)| Space O(m*n)**/
	/*public int maximalSquare(char[][] matrix) {
        int m= matrix.length;
        int n= matrix[0].length;
        int[][] dp= new int[m+1][n+1];//imagining extra row and column in beginning of the matrix
        
        int max=0;
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length;  j++){
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j]= 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                    max=Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
    }*/
	/**Approach2: DP Array**/
	public int maximalSquare(char[][] matrix) {
        int m= matrix.length;
        int n= matrix[0].length;
        int[] dp= new int[n+1];//imagining extra column in beginning of the array.
        
        int max=0;
        for(int i=1; i<m+1; i++){
        	int diag= dp[0];
            for(int j=1; j<n+1;  j++){
            	int temp= dp[j];
                if(matrix[i-1][j-1]=='1'){
                    dp[j]= 1 + Math.min(dp[j], Math.min(dp[j-1], diag));
                    max=Math.max(max, dp[j]);
                    diag=temp;
                }else {
                	dp[j]=0;
                }
            }
        }
        return max*max;
    }
	
	// Driver code to test above
	public static void main (String[] args) {
		MaximalSquare ob= new MaximalSquare();
		char[][] mat= {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
			
		System.out.print("Largest square containing only 1's : "+ob.maximalSquare(mat));	
	}
}
