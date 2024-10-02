/*
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

 

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
*/


//we have to maintain two largest element in PQ at any interval of time.
//since if PQ size exceeds k, we can pop out the most smallest element from PQ.
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int a : nums){
            pq.offer(a);
            if(pq.size() > k) pq.poll();
        }

        return pq.peek();
    }
}
