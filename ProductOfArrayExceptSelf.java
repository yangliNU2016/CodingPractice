/ * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements 
  * of nums except nums[i].
  *
  * Solve it without division and in O(n).
  *
  * For example, given [1,2,3,4], return [24,12,8,6].
  * 
  * Follow up:
  * Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space 
  * complexity analysis.)
  */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ret = new int[nums.length];
        // [a b c d e] use temp to store 1, 1*a, 1*a*b, ...
        int temp = 1;
        for (int i = 0; i < ret.length; i++) {
            ret[i] = temp;
            temp *= nums[i];
        }
        // [a b c d e] use temp to store e, e*d, e*d*c, ...
        temp = nums[nums.length - 1];
        
        for (int j = nums.length - 2; j >= 0; j--) {
            ret[j] *= temp;
            temp *= nums[j];
        }
        return ret;
    }
}  
