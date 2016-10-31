/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative of the non-zero elements
For example, given nums = [0, 1, 0, 3, 12]. After calling your function, nums should be [1, 3, 12, 0, 0].
Note:
	1. You must do this in-place without making a copy of the array.
	2. Minimize the total number of operations.
*/

public class Solution {
	public void moveZeros(int[] nums) {
		/*
		solution version one:
		// Use an arraylist to store all non-zero elements
		ArrayList<Integer> arrlst = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) arrlst.add(nums[i]);
		} 
		
		// Pull all the elements out from the arraylist and rewrite the array with them followed by 0s
		for (int j = 0; j < nums.length; j++) {
			if (j < arrlst.size()) {
				nums[j] = arrlst.get(j);
			} else nums[j] = 0;
		}
		*/
		
		// Use an integer to keep track of the index of the element to swap with a non-zero element
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[index] = nums[i];
				index++;
			}
		}
		
		// Rewrite the remaining part with zeros
		for (int j = index; j < nums.length; j++) {
			nums[j] = 0;
		}
	}
}