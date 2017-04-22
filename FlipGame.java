/*
You are playing the following Flip Game with your friend: given a string that contains only these two characters: + and -, you and your
friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other
person will be the winner.
Write a function to compute all possible states of the string after one valid move.
For example, given s = "++++", after one move, it may become one of the following states.
[
 "--++",
 "+--+",
 "++--"
]
If there is no valid move, return an empty list [].
*/

public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> ret = new ArrayList<String>(); 
        for (int i = 0; i < s.length(); i++) {
            // Find the first character that equals to "+"
            if (s.charAt(i) == '+') {
                // Check if the following character is valid and also equals to "+" 
                if (i + 1 < s.length() && s.charAt(i + 1) == '+') {
                    String ad = s.substring(0, i) + "--";
                    // Check if the pattern is the end of the String
                    if (i + 2 < s.length()) {
                        ad += s.substring(i + 2);
                    }
                    ret.add(ad);
                }
            }
        }
        return ret;
    }
}
