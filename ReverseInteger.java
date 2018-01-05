/*
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output:  321
 *
 * Example 2:
 *
 * Input: -123
 * Output: -321
 *
 * Example 3:
 *
 * Input: 120
 * Output: 21
 *
 * Note:
 * Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range.
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows. 
 */
class Solution {
    public int reverse(int x) {
        /*
        String num = Integer.toString(x);
        boolean neg = false, endZero = false;
        if (num.charAt(0) == '-') neg = true;
        if (num.charAt(num.length() - 1) == '0') endZero = true;
        ArrayList<Character> digits = new ArrayList<Character>();
        for (int i = 0; i < num.length(); i++) digits.add(num.charAt(i));
        Collections.reverse(digits);
        num = "";
        for (int j = 0; j < digits.size(); j++) num += digits.get(j);
        if (endZero) {
            int index = 1;
            for (int z = 1; z < num.length(); z++) {
                if (num.charAt(z) == '0') index = z + 1;
                else break;
            }
            num = num.substring(index);
        }
        if (neg) num = "-" + num.substring(0, num.length() - 1);
        int number = 0;
        try {
            number = Integer.parseInt(num);
        } catch(Exception e) {
            return 0;
        }
        return number;
        */
        
        // O(N) Time O(1) Space
        int ret = 0;
        while (x != 0) {
            // Make a shift and add a digit
            int num = ret * 10 + x % 10;
            // Check for overflow or underflow
            if ((num - x % 10) / 10 != ret) return 0;
            x /= 10;
            ret = num;
        }
        return ret;
    }
}
