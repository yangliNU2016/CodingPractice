/*
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that
 * the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the 
 * container contains the most water.
 * Note: You may not slant the container and n is at least 2.
 */
public class Solution {
    public int maxArea(int[] height) {
        /*
        O(N^2) time complexity & O(1) space complexity
        int maxVol = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int vol = Math.min(height[i], height[j]) * (j - i);
                if (vol > maxVol) maxVol = vol;
            }
        }
        return maxVol;
        */
        
        // O(N) time complexity & O(1) space complexity
        int maxVol = 0, left = 0, right = height.length - 1;
        while (left < right) {
            if (height[left] <= height[right]) {
                int vol = (right - left) * height[left];
                if (vol > maxVol) maxVol = vol;
                left++;
            }
            else {
                int vol = (right - left) * height[right];
                if (vol > maxVol) maxVol = vol;
                right--;
            }
        }
        return maxVol;
    }
}
 
