/* There are 1000 buckets, one and only one of them contains poison, the rest are filled with water. They all look the same. 
 * If a pig drinks that poison it will die within 15 minutes. What is the minimum amount of pigs you need to figure out which bucket 
 * contains the poison within one hour. Answer this question, and write an algorithm for the follow-up general case.
 * Follow-up:
 * If there are n buckets and a pig drinking poison will die within m minutes, 
 * how many pigs (x) you need to figure out the "poison" bucket within p minutes? There is exact one bucket with poison.
 * strategy:
 * With 2 pigs, poison killing in 15 minutes, and having 60 minutes, we can find the poison in up to 25 buckets in the following way. 
 * Arrange the buckets in a 5×5 square
 * 1  2  3  4  5
 * 6  7  8  9 10
 * 11 12 13 14 15
 * 16 17 18 19 20
 * 21 22 23 24 25
 */
 public class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        return (int)Math.ceil(Math.log(buckets) / Math.log(minutesToTest / minutesToDie + 1)); 
    }
 }
