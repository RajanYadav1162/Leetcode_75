
class Solution {
   public boolean canPlaceFlowers(int[] A, int n) {

      int mx = 0;
      int len = A.length;

      if (len == 0) {
         return mx >= n;
      }

      if (len == 1) {
         mx = A[0] == 0 ? 1 : 0;
         return mx >= n;
      }

      for (int i = 0; i < n; i++) {
         if (i + 1 < len && i == 0 && A[i + 1] == 0) {
            A[i] = 1;
            mx++;
         } else if (i > 0 && i + 1 < len && A[i] == 0 && A[i - 1] == 0 && A[i + 1] == 0) {
            A[i] = 0;
            mx++;
         }
      }

      return mx >= n;

   }
}

class Main {
   public static void main(String[] args) {

      var res = new Solution().canPlaceFlowers(new int[] { 1, 0, 0, 0, 0, 0, 1 }, 2);
      System.out.println(res);
   }
}