import java.util.*;

/*
You have a long flowerbed in which some of the plots are planted, and some are not. However,
flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty,
and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers
rule and false otherwise.

Example 1:

Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
Example 2:

Input: flowerbed = [1,0,0,0,1], n = 2
Output: false
 */

//solution-idea
/*
For each position 'i', we have to check
  1. flowerbed[i] == 0 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0.
  2. it's better to create one extra array (n+2) size, that will make handling of edge case like for i==0 && i == n-1
     bit easier.
 */

class Solution {

  public boolean canPlaceFlowers(int[] flowerbed, int n) {

    int len = flowerbed.length;
    int[] temp = new int[len + 2];

    //if initially flowerbed=[1, 2, 3], temp will contains [0, 1, 2, 3, 0].
    System.arraycopy(flowerbed, 0, temp, 1, len);

    int count = 0;

    //simple left and right checks, make sure too mark the values as '1', so that it can't be added as duplicate.
    for (int i = 1; i <= len; i++) {
      if (temp[i] == 0 && temp[i - 1] == 0 && temp[i + 1] == 0) {
        count++;
        temp[i] = 1;
      }
    }

    return count >= n;
  }
}
