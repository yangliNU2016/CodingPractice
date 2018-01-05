/*
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
 class Solution {
    public int[] twoSum(int[] nums, int target) {
        // O(N^2) Time, O(1) Space
        /*
        int[] ret = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ret[0] = i;
                    ret[1] = j;
                } 
            }
        }
        return ret;
        */
        
        // O(N) Time, O(N) Space
        /*
        int[] ret = new int[2];
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        // Load the mappings nums[i]-> i 
        for (int i = 0; i < nums.length; i++)  hm.put(nums[i], i);
        for (int j = 0; j < nums.length; j++) {
            int key = target - nums[j];
            if (hm.containsKey(key) && j != hm.get(key)) {
                ret[0] = j;
                ret[1] = hm.get(key);
            } 
        }
        return ret;
        */
        
        // O(N) Time, O(N) Space
        int[] ret = new int[2];
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (hm.containsKey(key)) {
                ret[0] = hm.get(key);
                ret[1] = i;
            } else {
                hm.put(nums[i], i);
            }
        }
        return ret;
    }
}
