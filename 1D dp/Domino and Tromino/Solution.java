/*
 * You have two types of tiles: a 2 x 1 domino shape and a tromino shape. You may rotate these shapes.


Given an integer n, return the number of ways to tile an 2 x n board. Since the answer may be very large, return it modulo 109 + 7.

In a tiling, every square must be covered by a tile. Two tilings are different if and only if there are two 4-directionally adjacent cells on the board such that exactly one of the tilings has both squares occupied by a tile.


Example 1:


Input: n = 3
Output: 5
Explanation: The five different ways are show above.
Example 2:

Input: n = 1
Output: 1

Constraints:

1 <= n <= 1000
 */

//Solution idea
/*
 * 1. lets saay we have n = 4, 
   2. if we place horizontal = G[n] = G[n-2];
   3. if we place vertical  = G[n] = G[n-1];
   4. if we place L = G[n] = F[n-1] --> some weird box with one gap at corner
   5. if we place L in different direction = G[n] = F[n-1];
   6. now we have to determin this F
   7. now on this F, if we can only place horizontal 2 X1--> F[i] = F[i-1];
   8. if we place a tromino on F = F[i] = G[n-1].
     so F[i] = G[i-1] + F[i-1] 
 */

class Solution {
  private final int mod = (int) 1e9 + 7;

  public int numTilings(int n) {

    if (n < 3)
      return n;

    int[] G = new int[n + 1], F = new int[n + 1];

    G[0] = F[0] = 0;
    G[1] = F[1] = 1;
    G[2] = F[2] = 2;

    for (int i = 3; i <= n; i++) {
      F[i] = (F[i - 1] + G[i - 1]) % mod;
      G[i] = ((G[i - 1] + G[i - 2]) % mod + (2 * F[i - 2]) % mod) % mod;
    }

    return G[n] % mod;
  }
}
