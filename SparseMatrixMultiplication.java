/*
Given two sparse matrices A and B, return the result of AB
You may assume that A's column number is equal to B's row number
Example:

A = [
[1, 0, 0],
[-1, 0, 3]
]

B = [
[7, 0, 0],
[0, 0, 0],
[0, 0, 1]
]
	 | 1 0 0 |   | 7 0 0 |   | 7 0 0 |
AB = |-1 0 3 | x | 0 0 0 | = |-7 0 3 |
				 | 0 0 1 |
*/				 

public class Solution {
	public int[][] multiply(int[][] A, int[][] B) {	
	    if(A == null || B == null) return null;
		int[][] ret = new int[A.length][B[0].length];
		for (int i = 0; i < ret.length; i++) {
			for (int j = 0; j < ret[i].length; j++) {
				ret[i][j] = rowByCol(A, B, i, j);
			}
		}
		return ret;
	}
	
	public int rowByCol(int[][] A, int[][] B, int rowIndex, int colIndex) {
		int ret = 0;
		for(int k = 0; k < A[rowIndex].length; k++) {
			ret += A[rowIndex][k] * B[k][colIndex]; 
		}
		return ret;
	}
}