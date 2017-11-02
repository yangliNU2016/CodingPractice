/*
 * Given an integer, convert it to a roman numeral.
 * Input is guranteed to be within the range from 1 to 3999.
 */
 
// This is my solution. O(n) time O(1) space
public class Solution {
    public String intToRoman(int num) {
        // Create one-to-one map between roman literals and numbers
        String[] rmNum = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        
        String ret = "";
        for (int i = 0; i < nums.length; i++) {
            // While the number is no smaller than the current number pointer points at, subtract 
            // the current number and append a literal to ret
            while (num >= nums[i]) {
                num -= nums[i];
                ret += rmNum[i];
            }
        }
        return ret;
    }
}

// This is a very efficient solution availble online. O(1) time if modules takes O(1) and O(1) space
public static String intToRoman(int num) {
    String M[] = {"", "M", "MM", "MMM"};
    String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
}
