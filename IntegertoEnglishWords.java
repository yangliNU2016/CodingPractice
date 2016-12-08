/**
Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 2^31 - 1.
For example,
123 -> "One Hundred Twenty Three"
12345 -> "Twelve Thousand Three Hundred Forty Five"
1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
**/

public class Solution {
    public String numberToWords(int num) {
        String ret = "";
        if (num / 1000000000 > 0) {
            ret += billionsToWords(num);
            if (num % 1000000000 != 0) num %= 1000000000;
            else return ret.substring(1);
        }
        if (num / 1000000 > 0) {
            ret += millionsToWords(num);
            if (num % 1000000 != 0) num %= 1000000;
            else return ret.substring(1);
        }
        if (num / 1000 > 0) {
            ret += thousandsToWords(num);
            if (num % 1000 != 0) num %= 1000;
            else return ret.substring(1);
        }
        ret += numToWords(num);
        return ret.substring(1); 
    }
    // If the number has 9 or more digits
    public String billionsToWords(int num) {
        return numToWords(num / 1000000000) + " Billion";
    }
    
    // If the number has 6 or more digits
    public String millionsToWords(int num) {
        return numToWords(num / 1000000) + " Million";
    }    
        
    // If the number has more than 3 but less than 6 digits
    public String thousandsToWords(int num) {
        return numToWords(num / 1000) + " Thousand";
    }    
    
    // If the number has 3 or less digits
    public String numToWords(int num) {
        String ret = "";
        String[] num1 = {" Zero", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine", " Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"};
        String[] num2 = {" Zero", " Ten", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"};
        
        if (num / 100 > 0) {
            ret += num1[num / 100] + " Hundred";
            if (num % 100 != 0) num %= 100;
            else return ret;
        }
        if (num / 10 > 1) {
            ret += num2[num / 10];
            if (num % 10 != 0) num %= 10;
            else return ret;
        }
        ret += num1[num];
        return ret;
    }
}
