/**
 * Given a string, find the length of the longest substring without repeating characters.
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and 
 * not a substring.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        ArrayList<String> subStrLst = new ArrayList<String>();
        String fstSubStr = "";
        subStrLst.add(fstSubStr);
        for (int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);
            int index = subStrLst.get(subStrLst.size() - 1).indexOf(target);
            // If the next char is never seen, append it to the current string
            if (index == -1) { 
                String toSet = subStrLst.get(subStrLst.size() - 1) + target; 
                subStrLst.set(subStrLst.size() - 1, toSet);
            }
            // If not, find the substring of the current string after that repeating index and append
            // it with the current char and that becomes our current string
            else {
                String next = subStrLst.get(subStrLst.size() - 1).substring(index + 1) + target;
                subStrLst.add(next);
            }
        }
        
        // Find the longest string in the list
        int len = subStrLst.get(0).length();
        for (int j = 1; j < subStrLst.size(); j++) {
            if (subStrLst.get(j).length() > len) {
                len = subStrLst.get(j).length();
            }
        }
        return len;
    }
} 


 
 
