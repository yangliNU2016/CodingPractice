/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
Example a:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example b:
Input: "cbbd"
Output: "bb"
*/
public class Solution {
    public String longestPalindrome(String s) {
        if(s == null) return s;
        if(s.length() == 0 || s.length() == 1) return s;
        // Use two arraylists two track the indices of two types of palindromic pattern "..yxxy.." or "..zyxyz.."
        ArrayList<Integer> indices1 = new ArrayList<Integer>();
        ArrayList<Integer> indices2 = new ArrayList<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) indices1.add(i);
            if (i + 2 < s.length() && s.charAt(i) == s.charAt(i + 2)) indices2.add(i + 1);
        }
        // None of the two patterns are found then pick the first character to return
        if(indices1.size() == 0 && indices2.size() == 0) return s.substring(0, 1);
        
        // Take each instance from two-pattern collections and find how long each palindrom is 
        int[] lengths = new int[indices1.size() + indices2.size()];
        for (int j = 0; j < indices1.size(); j++) {
            lengths[j] = 2;
            for(int m = 1; m < s.length(); m++) {
                if (indices1.get(j) + 1 + m < s.length() && indices1.get(j) - m >= 0 && s.charAt(indices1.get(j) - m) == s.charAt(indices1.get(j) + 1 + m))
                    lengths[j] += 2;
                else m = s.length();
            }    
        }
        for (int k = 0; k < indices2.size(); k++) {
            lengths[indices1.size() + k] = 3;
            for (int n = 2; n < s.length(); n++) {
                if (indices2.get(k) + n < s.length() && indices2.get(k) - n >= 0 && s.charAt(indices2.get(k) + n) == s.charAt(indices2.get(k) - n))
                    lengths[indices1.size() + k] += 2;
                else n = s.length();
            }
        }
        
        int maxLen = 0;
        int index = -1;
        for (int p = 0; p < lengths.length; p++) {
            if (lengths[p] > maxLen) {
                maxLen = lengths[p];
                index = p;
            } 
        }
        
        // Construct the longest palindrome
        String palindrome = "";
        int count = 0;
        while(count < maxLen) {
            if (index < indices1.size())
                palindrome += Character.toString(s.charAt(indices1.get(index) - (maxLen / 2 - 1) + count));
            else
                palindrome += Character.toString(s.charAt(indices2.get(index - indices1.size()) - maxLen / 2 + count));
            count++;
        }    
        return palindrome;
    }
}
