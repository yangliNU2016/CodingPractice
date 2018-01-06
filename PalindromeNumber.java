/*Determine whether an integer is a palindrome. Do this without extra space.*/
class Solution {
    public boolean isPalindrome(int x) {
        // O(N) Time where N is the number of digits of x and O(1) Space
        if (x < 0) return false;
        int backup = x; 
        int pal = 0;
        while (x != 0) {
            int mid = pal * 10 + x % 10;
            if ((mid - x % 10) / 10 != pal) return false;
            x = x / 10;
            pal = mid;
        }
        return pal == backup;
    }
}
