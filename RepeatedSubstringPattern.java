/*
Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. 
You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

Example 1:
Input: "abab"
Output: True
Explanation: It's the substring "ab" twice.

Example 2:
Input: "aba"
Output: False

Example 3:
Input: "abcabcabcabc"
Output: True
Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
*/

public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        boolean ret = true;
        // if s is a single character return false
        if (s.length() == 1) { 
            return false;
        } else {
            // from length of 0 to half of the string, finding a substring and test it 
            for (int i = 0; i < s.length() / 2; i++) {
                String st = s.substring(0, i + 1);
                if(isRepeating(st, s)) return true;
            }
            ret = false;
        }
        return ret;
    }
    
    // check if s has the repeat pattern of substring rp 
    public boolean isRepeating(String rp, String s) {
        int len = rp.length();
        if (s.length() % len != 0) return false;
        for (int i = len; i < s.length(); i += len) {
            if (!rp.equals(s.substring(i, i + len))) {
                return false;
            }
            if (i + len > s.length()) {
                return false;
            }    
        }
        return true;
    }
}
