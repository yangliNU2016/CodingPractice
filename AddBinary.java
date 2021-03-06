/*
Given two binary strings, return their sum (also a binary string).
a = "11"
b = "1"
Return "100"
*/

public class Solution {
    public String addBinary(String a, String b) {
        if (a == null || b == null) return "";
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0, sum = 0;
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            carry = sum / 2;
            sb.append(sum % 2);
            sum = carry;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
